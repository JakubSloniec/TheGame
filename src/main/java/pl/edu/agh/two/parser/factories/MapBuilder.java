package pl.edu.agh.two.parser.factories;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import pl.edu.agh.two.console.GameConsole;
import pl.edu.agh.two.domain.events.EventWithDescription;
import pl.edu.agh.two.domain.events.IEvent;
import pl.edu.agh.two.domain.map.Map;
import pl.edu.agh.two.domain.rooms.Coordinates;
import pl.edu.agh.two.domain.rooms.Direction;
import pl.edu.agh.two.domain.rooms.IRoom;
import pl.edu.agh.two.domain.rooms.Wall;
import pl.edu.agh.two.domain.rooms.preconditions.IPrecondition;
import pl.edu.agh.two.factories.RoomsFactory;
import pl.edu.agh.two.parser.ConfigReader;
import pl.edu.agh.two.parser.exceptions.DuplicateEventNamesException;
import pl.edu.agh.two.parser.exceptions.NoSuchEventException;
import pl.edu.agh.two.parser.map.RawMap;
import pl.edu.agh.two.parser.map.RawRoom;

/**
 * Created by oem on 2015-11-18.
 */
//XXX beware of collisions between java.util.Map and pl.edu.agh.two.domain.map.Map
public class MapBuilder {

    private MapBuildConfig config;
    private Map product;
    private HashMap<String,IEvent> events=new HashMap<String,IEvent>();

    public MapBuilder() {
        this.config=new MapBuildConfig();
    }

    public MapBuilder(MapBuildConfig config) {
        this.config=config;
    }

    public MapBuildConfig getConfig() {
        return config;
    }

    public void setConfig(MapBuildConfig config) {
        this.config = config;
    }

    //It is assumed all events all read before calling this method
    public MapBuilder getMapFromFile(String mapFileName) {
        ConfigReader<RawMap> mapConfigReader=new ConfigReader<>(RawMap.class);

        RawMap rawMap=mapConfigReader.readConfig(mapFileName);
        product=new Map(10);
        //checking where we didn't put a room
        boolean checkingBoard[][]=new boolean[10][10];

        List<RawRoom> rawRooms=rawMap.getRooms();
        for(RawRoom rawRoom: rawRooms) {
            String eventName=rawRoom.getEvent();
            IEvent event;
            if(eventName.equals("EMPTY")) {
                event = null;
            } else {
                event = events.get(rawRoom.getEvent());
                if (event == null) {
                    throw new NoSuchEventException();
                }
            }
            IRoom room=RoomsFactory.createEventRoom(event, rawRoom.getX(), rawRoom.getY(), Optional.<List<IPrecondition>>empty(), Optional.<GameConsole>empty());
            if(rawRoom.isStart())
                product.setCurrentRoom(room);
            product.addRoom(rawRoom.getX(),rawRoom.getY(),room
                    );
            checkingBoard[rawRoom.getX()][rawRoom.getY()]=true;
        }
        //if the room wasn't put, put a wall
        for(int i=0;i<10;i++) {
            for(int j=0;j<10;j++) {
                if(checkingBoard[i][j]==false)
                    product.addRoom(i,j,new Wall(new Coordinates(i,j)));
            }
        }

        IRoom rooms[][]=product.getMap();
        for(int i=1;i<9;i++) {
            for(int j=1;j<9;j++) {
                IRoom room=rooms[i][j];
                if(j==0)
                    room.addAdjectiveRoom(Direction.NORTH,null);
                else
                    room.addAdjectiveRoom(Direction.NORTH,rooms[i][j-1]);
                if(j==9)
                    room.addAdjectiveRoom(Direction.SOUTH,null);
                else
                    room.addAdjectiveRoom(Direction.SOUTH,rooms[i][j+1]);
                if(i==0)
                    room.addAdjectiveRoom(Direction.WEST,null);
                else
                    room.addAdjectiveRoom(Direction.WEST,rooms[i-1][j]);
                if(i==9)
                    room.addAdjectiveRoom(Direction.EAST,null);
                else
                    room.addAdjectiveRoom(Direction.EAST,rooms[i+1][j]);
            }
        }
        //for(int i=0;i<10;i++) {
          //  IRoom room=rooms[0][i];
            //room.addAdjectiveRoom(Direction.NORTH,null);

        //}
        return this;
    }

    //for files with single event
    public MapBuilder parseEventFile(String eventType, String eventFileName, GameConsole gameConsole) {
        IEvent fetchedEvent=config.getEventFactory(eventType).getEventFromFile(eventFileName);
        String eventName=eventFileName.substring(eventFileName.lastIndexOf("/")+1).replaceAll("\\.json$","");
        if(events.containsKey(eventName)) {
            throw new DuplicateEventNamesException();
        }
        events.forEach((name, event) -> {
            if (event instanceof EventWithDescription) { //todo: move somwhere
                ((EventWithDescription) event).setGameConsole(gameConsole);
            }
        });
        events.put(eventName, fetchedEvent);
        return this;
    }

    public Map build() {
        return product;
    }

}

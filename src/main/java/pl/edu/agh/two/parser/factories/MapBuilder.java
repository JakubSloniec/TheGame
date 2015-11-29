package pl.edu.agh.two.parser.factories;

import pl.edu.agh.two.console.GameConsole;
import pl.edu.agh.two.domain.events.IEvent;
import pl.edu.agh.two.domain.map.Map;
import pl.edu.agh.two.domain.rooms.preconditions.IPrecondition;
import pl.edu.agh.two.factories.RoomsFactory;
import pl.edu.agh.two.parser.ConfigReader;
import pl.edu.agh.two.parser.exceptions.DuplicateEventNamesException;
import pl.edu.agh.two.parser.exceptions.NoSuchEventException;
import pl.edu.agh.two.parser.map.RawMap;
import pl.edu.agh.two.parser.map.RawRoom;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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
            product.addRoom(rawRoom.getX(),rawRoom.getY(),
                    RoomsFactory.createEventRoom(event, rawRoom.getX(), rawRoom.getY(), Optional.<List<IPrecondition>>empty(), Optional.<GameConsole>empty()));
        }
        return this;
    }

    //for files with single event
    public MapBuilder parseEventFile(String eventType,String eventFileName) {
        IEvent fetchedEvent=config.getEventFactory(eventType).getEventFromFile(eventFileName);
        String eventName=eventFileName.substring(eventFileName.lastIndexOf("/")+1).replaceAll("\\.json$","");
        if(events.containsKey(eventName)) {
            throw new DuplicateEventNamesException();
        }
        events.put(eventName,fetchedEvent);
        return this;
    }

    //for files with multiple events
    public MapBuilder parseEventsFile(String eventType,String eventFileName) {
        java.util.Map<String,IEvent> fetchedEvents=config.getEventFactory(eventType).getEventsFromFile(eventFileName);
        for(String eventName:fetchedEvents.keySet()) {
            if(events.containsKey(eventName)) {
                throw new DuplicateEventNamesException();
            }
        }
        events.putAll(fetchedEvents);
        return this;
    }

    public Map build() {
        return product;
    }

}

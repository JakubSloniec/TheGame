package pl.edu.agh.two.parser;

import static org.mockito.Mockito.mock;

import pl.edu.agh.two.console.GameConsole;
import pl.edu.agh.two.domain.events.EventWithDescription;
import pl.edu.agh.two.domain.map.Map;
import pl.edu.agh.two.domain.rooms.EmptyRoom;
import pl.edu.agh.two.domain.rooms.EventRoom;
import pl.edu.agh.two.domain.rooms.IRoom;
import pl.edu.agh.two.parser.factories.MapFactory;

/**
 * Created by oem on 2015-11-23.
 */
public class MapBuildingTest {
    public static void main(String[] args) {

        Map map = MapFactory.getMap(mock(GameConsole.class));

        printMap(map);
    }

    private static void printMap(Map map) {
        IRoom[][] rooms=map.getMap();
        for(int i=0;i<rooms.length;i++) {
            for(int j=0;j<rooms[i].length;j++) {
                IRoom room=rooms[i][j];
                if(room instanceof EventRoom) {
                    EventRoom roomAsEventRoom=(EventRoom)room;
                    EventWithDescription event=(EventWithDescription)roomAsEventRoom.getEvent();
                    System.out.print(event.getEventDescription());
                }   else if(room instanceof EmptyRoom) {
                    System.out.print("EMPTY");
                } else  if(room==null) {
                    System.out.print("NULL");
                } else {
                    System.out.print("UNDEFINED");
                }
                System.out.print("\t");
            }
            System.out.print("\n");
        }
    }

}

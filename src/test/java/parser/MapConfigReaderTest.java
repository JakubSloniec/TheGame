package parser;

/**
 * Created by Michal Mrowczyk on 11/10/2015.
 */
public class MapConfigReaderTest {
    public static void main(String[] args) {
        System.out.println("---- Testing reading map configuration using Jackson ----");

        // Reading raw game map from JSON file
        MapConfigReader mapConfigReader = new MapConfigReader();
        RawMap gameMap1 = mapConfigReader.readMapConfig("gamemap1.json");

        System.out.println();
        System.out.println("---- gameMap1 printed using pretty format ----");
        String prettyGameMapString1 = mapConfigReader.prettyPrint(gameMap1);
        System.out.println(prettyGameMapString1);

        System.out.println("gameMap1 :: Number of columns: " + gameMap1.getColumns());
        System.out.println("gameMap1 :: Number of rows: " + gameMap1.getRows());
        System.out.println("gameMap1 :: Rooms: " + gameMap1.getRooms());
        System.out.println("gameMap1 :: Rooms[0] id: " + gameMap1.getRooms().get(4).getId());

        RawMap gameMap2 = mapConfigReader.readMapConfig("gamemap2.json");

        System.out.println();
        System.out.println("---- gameMap2 printed using pretty format ----");
        String prettyGameMapString2 = mapConfigReader.prettyPrint(gameMap2);
        System.out.println(prettyGameMapString2);
    }
}

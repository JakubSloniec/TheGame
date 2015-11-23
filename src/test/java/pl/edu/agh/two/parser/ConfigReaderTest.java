package pl.edu.agh.two.parser;

import pl.edu.agh.two.parser.item.RawItem;
import pl.edu.agh.two.parser.map.RawMap;
import pl.edu.agh.two.parser.quiz.RawQuiz;

/**
 * Created by Michal Mrowczyk on 11/10/2015.
 */
public class ConfigReaderTest {
    public static void main(String[] args) {
        System.out.println("---- Testing reading map configuration using Jackson ----");

        // Reading raw game map from JSON file
//        MapConfigReader mapConfigReader = new MapConfigReader();
//        RawMap gameMap1 = mapConfigReader.readMapConfig("gamemap1.json");
//
//        System.out.println();
//        System.out.println("---- gameMap1 printed using pretty format ----");
//        String prettyGameMapString1 = mapConfigReader.prettyPrint(gameMap1);
//        System.out.println(prettyGameMapString1);
//
//        System.out.println("gameMap1 :: Number of columns: " + gameMap1.getColumns());
//        System.out.println("gameMap1 :: Number of rows: " + gameMap1.getRows());
//        System.out.println("gameMap1 :: Rooms: " + gameMap1.getRooms());
//        System.out.println("gameMap1 :: Rooms[0] id: " + gameMap1.getRooms().get(4).getId());
//
//        RawMap gameMap2 = mapConfigReader.readMapConfig("gamemap2.json");
//
//        System.out.println();
//        System.out.println("---- gameMap2 printed using pretty format ----");
//        String prettyGameMapString2 = mapConfigReader.prettyPrint(gameMap2);
//        System.out.println(prettyGameMapString2);

        System.out.println("MAP:");
        ConfigReader<RawMap> mapConfigReader = new ConfigReader<>(RawMap.class);
        RawMap mapLev1 = mapConfigReader.readConfig("plotConfig/mapLev1.json");
        mapConfigReader.prettyPrint(mapLev1);

        System.out.println("QUIZ:");
        ConfigReader<RawQuiz> quizConfigReader = new ConfigReader<>(RawQuiz.class);
        RawQuiz quizLev1 = quizConfigReader.readConfig("plotConfig/quizLev1.json");
        quizConfigReader.prettyPrint(quizLev1);

        System.out.println("PIWO:");
        ConfigReader<RawItem> rawItemReader = new ConfigReader<>(RawItem.class);
        RawItem piwoItem = rawItemReader.readConfig("plotConfig/itemPiwo.json");
        rawItemReader.prettyPrint(piwoItem);

        System.out.println("PASSY DO WIKI:");
        RawItem passyDoWikiItem = rawItemReader.readConfig("plotConfig/itemPassyDoWiki.json");
        rawItemReader.prettyPrint(passyDoWikiItem);
    }
}

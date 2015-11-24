package pl.edu.agh.two.parser;

import pl.edu.agh.two.parser.events.getters.RawGetter;
import pl.edu.agh.two.parser.item.RawItem;
import pl.edu.agh.two.parser.map.RawMap;
import pl.edu.agh.two.parser.events.quiz.RawQuiz;

/**
 * Created by Michal Mrowczyk on 11/10/2015.
 */
public class ConfigReaderTest {
    public static void main(String[] args) {
        System.out.println("---- Testing reading map configuration using Jackson ----");


        System.out.println("MAP:");
        ConfigReader<RawMap> mapConfigReader = new ConfigReader<>(RawMap.class);
        RawMap mapLev1 = mapConfigReader.readConfig("plotConfig/maps/mapLev1.json");
        mapConfigReader.prettyPrint(mapLev1);

        System.out.println("QUIZ:");
        ConfigReader<RawQuiz> quizConfigReader = new ConfigReader<>(RawQuiz.class);
        RawQuiz quizLev1 = quizConfigReader.readConfig("plotConfig/events/quiz/quizLev1.json");
        quizConfigReader.prettyPrint(quizLev1);

        System.out.println("ITEM WODKA:");
        ConfigReader<RawItem> rawItemReader = new ConfigReader<>(RawItem.class);
        RawItem piwoItem = rawItemReader.readConfig("plotConfig/items/itemPiwo.json");
        rawItemReader.prettyPrint(piwoItem);

        System.out.println("ITEM PIWO:");
        RawItem wodkaItem = rawItemReader.readConfig("plotConfig/items/itemWodka.json");
        rawItemReader.prettyPrint(wodkaItem);

        System.out.println("ITEM StudentAghEduPl:");
        RawItem studentItem = rawItemReader.readConfig("plotConfig/items/itemStudentAghEduPl.json");
        rawItemReader.prettyPrint(studentItem);

        System.out.println("ITEM PASSY DO WIKI:");
        RawItem passyDoWikiItem = rawItemReader.readConfig("plotConfig/items/itemPassyDoWiki.json");
        rawItemReader.prettyPrint(passyDoWikiItem);

        System.out.println("GETTER PASSY DO WIKI:");
        ConfigReader<RawGetter> rawGetterReader = new ConfigReader<>(RawGetter.class);
        RawGetter passyDoWikiGetter = rawGetterReader.readConfig("plotConfig/events/getters/getPassyDoWiki.json");
        rawGetterReader.prettyPrint(passyDoWikiGetter);
    }
}

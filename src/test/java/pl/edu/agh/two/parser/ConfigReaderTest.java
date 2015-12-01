package pl.edu.agh.two.parser;

import pl.edu.agh.two.parser.events.fights.RawFight;
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



        ConfigReader<RawMap> mapConfigReader = new ConfigReader<>(RawMap.class);
        System.out.println("mapLev1.json:");
        RawMap mapLev1 = mapConfigReader.readConfig("plotConfig/maps/mapLev1.json");
        mapConfigReader.prettyPrint(mapLev1);

        System.out.println("quizLev1.json:");
        ConfigReader<RawQuiz> quizConfigReader = new ConfigReader<>(RawQuiz.class);
        RawQuiz quizLev1 = quizConfigReader.readConfig("plotConfig/events/quiz/quizLev1.json");
        quizConfigReader.prettyPrint(quizLev1);
        System.out.println("quizLev2.json:");
        RawQuiz quizLev2 = quizConfigReader.readConfig("plotConfig/events/quiz/quizLev2.json");
        quizConfigReader.prettyPrint(quizLev2);


        ConfigReader<RawItem> rawItemReader = new ConfigReader<>(RawItem.class);
        System.out.println("itemPiwo.json:");
        RawItem piwoItem = rawItemReader.readConfig("plotConfig/items/itemPiwo.json");
        rawItemReader.prettyPrint(piwoItem);

        System.out.println("itemWodka.json:");
        RawItem wodkaItem = rawItemReader.readConfig("plotConfig/items/itemWodka.json");
        rawItemReader.prettyPrint(wodkaItem);

        System.out.println("itemWino.json:");
        RawItem winoItem = rawItemReader.readConfig("plotConfig/items/itemWino.json");
        rawItemReader.prettyPrint(winoItem);

        System.out.println("itemStudentAghEduPl.json");
        RawItem studentItem = rawItemReader.readConfig("plotConfig/items/itemStudentAghEduPl.json");
        rawItemReader.prettyPrint(studentItem);

        System.out.println("itemPassyDoWiki.json:");
        RawItem passyDoWikiItem = rawItemReader.readConfig("plotConfig/items/itemPassyDoWiki.json");
        rawItemReader.prettyPrint(passyDoWikiItem);

        System.out.println("getPassyDoWiki.json:");
        ConfigReader<RawGetter> rawGetterReader = new ConfigReader<>(RawGetter.class);
        RawGetter passyDoWikiGetter = rawGetterReader.readConfig("plotConfig/events/getters/getPassyDoWiki.json");
        rawGetterReader.prettyPrint(passyDoWikiGetter);

        System.out.println("spotkanieProwadzacegoKorytarzOregano.json");
        ConfigReader<RawFight> rawFightReader = new ConfigReader<>(RawFight.class);
        RawFight spotkanieProwadzacegoFight = rawFightReader.readConfig("plotConfig/events/fights/spotkanieProwadzacegoKorytarzOregano.json");
        rawFightReader.prettyPrint(spotkanieProwadzacegoFight);
    }
}

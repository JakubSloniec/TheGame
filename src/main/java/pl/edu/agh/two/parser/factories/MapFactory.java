package pl.edu.agh.two.parser.factories;

import java.io.File;

import pl.edu.agh.two.console.GameConsole;
import pl.edu.agh.two.domain.map.Map;

/**
 * Created by oem on 2015-11-23.
 */
public class MapFactory {

    public static Map getMap(GameConsole gameConsole) {
        MapBuildConfig config=new MapBuildConfig();

        //place for adding factories for new types of events
        config.setEventFactory("quiz", new QuizEventsFactory(gameConsole));
        config.setEventFactory("pickItem",new GetItemEventsFactory());
        config.setEventFactory("text",new EventsWithDescriptionFactory());
        config.setEventFactory("fight",new FightEventsFactory());

        MapBuilder builder=new MapBuilder(config);

        ClassLoader classLoader=MapFactory.class.getClassLoader();

        File quizEventsFolder=new File(classLoader.getResource("plotConfig/events/quiz").getFile());
        for(String fileName:quizEventsFolder.list()) {
            builder = builder.parseEventFile("quiz", "plotConfig/events/quiz/" + fileName, gameConsole);
        }

        File pickItemEventsFolder=new File(classLoader.getResource("plotConfig/events/getters").getFile());
        for(String fileName:pickItemEventsFolder.list()) {
            builder = builder.parseEventFile("pickItem", "plotConfig/events/getters/" + fileName, gameConsole);
        }

        File textEventsFolder=new File(classLoader.getResource("plotConfig/events/text").getFile());
        for(String fileName:textEventsFolder.list()) {
            builder = builder.parseEventFile("text", "plotConfig/events/text/" + fileName, gameConsole);
        }

        File fightEventsFolder=new File(classLoader.getResource("plotConfig/events/fights").getFile());
        for(String fileName:fightEventsFolder.list()) {
            builder = builder.parseEventFile("fight","plotConfig/events/fights/"+ fileName, gameConsole);
        }

        //place for adding new files
        return builder
                .getMapFromFile("plotConfig/maps/mapLev2.json")
                .build();


    }
}

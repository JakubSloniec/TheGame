package pl.edu.agh.two.parser.factories;

import pl.edu.agh.two.domain.map.Map;

import java.io.File;

/**
 * Created by oem on 2015-11-23.
 */
public class MapFactory {

    public static Map getMap() {
        MapBuildConfig config=new MapBuildConfig();

        //place for adding factories for new types of events
        config.setEventFactory("quiz",new QuizEventsFactory());
        config.setEventFactory("pickItem",new GetItemEventsFactory());
        config.setEventFactory("text",new EventsWithDescriptionFactory());

        MapBuilder builder=new MapBuilder(config);

        ClassLoader classLoader=MapFactory.class.getClassLoader();

        File quizEventsFolder=new File(classLoader.getResource("plotConfig/events/quiz").getFile());
        for(String fileName:quizEventsFolder.list()) {
            builder=builder.parseEventFile("quiz","plotConfig/events/quiz/"+fileName);
        }

        File pickItemEventsFolder=new File(classLoader.getResource("plotConfig/events/getters").getFile());
        for(String fileName:pickItemEventsFolder.list()) {
            builder=builder.parseEventFile("pickItem","plotConfig/events/getters/"+fileName);
        }

        File textEventsFolder=new File(classLoader.getResource("plotConfig/events/text").getFile());
        for(String fileName:textEventsFolder.list()) {
            builder=builder.parseEventFile("text","plotConfig/events/text/"+fileName);
        }

        //place for adding new files
        return builder
                .getMapFromFile("plotConfig/maps/mapLev1.json")
                .build();


    }
}

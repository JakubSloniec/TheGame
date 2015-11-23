package pl.edu.agh.two.parser.factories;

import pl.edu.agh.two.domain.map.Map;

/**
 * Created by oem on 2015-11-23.
 */
public class MapFactory {

    public static Map getMap() {
        MapBuildConfig config=new MapBuildConfig();

        //place for adding factories for new types of events
        config.setEventFactory("quiz",new QuizEventsFactory());

        MapBuilder builder=new MapBuilder(config);

        //place for adding new files
        return builder
                .parseEventFile("quiz","plotConfig/quizLev1.json")
                .getMapFromFile("plotConfig/mapLev1.json")
                .build();


    }
}

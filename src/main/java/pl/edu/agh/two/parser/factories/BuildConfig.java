package pl.edu.agh.two.parser.factories;

import pl.edu.agh.two.domain.events.IEvent;

import java.util.HashMap;

public class BuildConfig {

    private String mapFileName;
    private HashMap<String,IEventsFactory> eventParsers;

    public BuildConfig() {
        eventParsers=new HashMap<String,IEventsFactory>();
        //place for adding factories for new types of events
        eventParsers.put("quiz",new QuizEventsFactory());
    }

    public String getMapFileName() {
        return mapFileName;
    }

    public void setMapFileName(String mapFileName) {
        this.mapFileName = mapFileName;
    }

    public void setEventFactory(String eventTypeName,IEventsFactory factory) {
        eventParsers.put(eventTypeName,factory);
    }

    public IEventsFactory getEventFactory(String eventTypeName) {
        return eventParsers.get(eventTypeName);
    }
}

package pl.edu.agh.two.parser.factories;

import pl.edu.agh.two.domain.events.IEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oem on 2015-11-22.
 */
public interface IEventsFactory {
    //obsolete due to change of the event description inside json standard
    //Map<String,IEvent> getEventsFromFile(String eventFileName);

    IEvent getEventFromFile(String eventFileName);

}

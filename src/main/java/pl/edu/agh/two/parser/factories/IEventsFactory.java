package pl.edu.agh.two.parser.factories;

import pl.edu.agh.two.domain.events.IEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oem on 2015-11-22.
 */
public interface IEventsFactory {

    Map<String,IEvent> getEventsFromFile(String eventFileName);
    // Map is used only to retrieve single instance of name and event,
    // I was too lazy to use Tuple
    Map<String,IEvent> getEventFromFile(String eventFileName);

}

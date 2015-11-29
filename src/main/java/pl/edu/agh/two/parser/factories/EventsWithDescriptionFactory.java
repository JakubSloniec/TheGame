package pl.edu.agh.two.parser.factories;

import pl.edu.agh.two.domain.events.EventWithDescription;
import pl.edu.agh.two.domain.events.IEvent;
import pl.edu.agh.two.parser.ConfigReader;
import pl.edu.agh.two.parser.events.text.RawTextEvent;

import java.util.Map;

/**
 * Created by oem on 2015-11-26.
 */
public class EventsWithDescriptionFactory implements IEventsFactory {

    //obsolete
    @Override
    public Map<String, IEvent> getEventsFromFile(String eventFileName) {
        return null;
    }

    @Override
    public IEvent getEventFromFile(String eventFileName) {
        ConfigReader<RawTextEvent> configReader=new ConfigReader<>(RawTextEvent.class);
        RawTextEvent event=configReader.readConfig(eventFileName);
        EventWithDescription retVal=new EventWithDescription();
        retVal.setEventDescription(event.getTextToDisplay());
        return retVal;
    }
}

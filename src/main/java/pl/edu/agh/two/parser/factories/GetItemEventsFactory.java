package pl.edu.agh.two.parser.factories;

import pl.edu.agh.two.domain.events.IEvent;
import pl.edu.agh.two.parser.ConfigReader;
import pl.edu.agh.two.parser.events.getters.RawGetter;

import java.util.Map;

/**
 * Created by oem on 2015-11-26.
 */
public class GetItemEventsFactory implements IEventsFactory {
    //obsolete
    @Override
    public Map<String, IEvent> getEventsFromFile(String eventFileName) {
        return null;
    }

    @Override
    public IEvent getEventFromFile(String eventFileName) {
        ConfigReader<RawGetter> configReader=new ConfigReader<>(RawGetter.class);
        RawGetter event=configReader.readConfig(eventFileName);
        //TODO after creating items is done
        return null;
    }
}

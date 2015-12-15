package pl.edu.agh.two.parser.factories;

import pl.edu.agh.two.console.GameConsole;
import pl.edu.agh.two.domain.events.EventWithDescription;
import pl.edu.agh.two.domain.events.IEvent;
import pl.edu.agh.two.parser.ConfigReader;
import pl.edu.agh.two.parser.events.text.RawTextEvent;

/**
 * Created by oem on 2015-11-26.
 */
public class EventsWithDescriptionFactory implements IEventsFactory {

    @Override
    public IEvent getEventFromFile(String eventFileName, GameConsole gameConsole) {
        ConfigReader<RawTextEvent> configReader=new ConfigReader<>(RawTextEvent.class);
        RawTextEvent event=configReader.readConfig(eventFileName);
        EventWithDescription retVal=new EventWithDescription();
        retVal.setEventDescription(event.getTextToDisplay());
        retVal.setGameConsole(gameConsole);
        return retVal;
    }
}

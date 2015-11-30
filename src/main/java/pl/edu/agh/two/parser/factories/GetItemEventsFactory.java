package pl.edu.agh.two.parser.factories;

import pl.edu.agh.two.domain.events.IEvent;
import pl.edu.agh.two.domain.events.PickItemEvent;
import pl.edu.agh.two.parser.ConfigReader;
import pl.edu.agh.two.parser.events.getters.RawGetter;
import pl.edu.agh.two.repositories.ItemsRepository;

import java.util.Map;

/**
 * Created by oem on 2015-11-26.
 */
public class GetItemEventsFactory implements IEventsFactory {

    @Override
    public IEvent getEventFromFile(String eventFileName) {
        ConfigReader<RawGetter> configReader=new ConfigReader<>(RawGetter.class);
        RawGetter rawEvent=configReader.readConfig(eventFileName);
        //fetching only first item, due to misfit with the model
        PickItemEvent event=new PickItemEvent(ItemsRepository.getItem(rawEvent.getItems().get(0).getItem()));
        return event;
    }
}
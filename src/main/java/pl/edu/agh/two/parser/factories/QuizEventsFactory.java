package pl.edu.agh.two.parser.factories;

import pl.edu.agh.two.domain.events.IEvent;
import pl.edu.agh.two.parser.ConfigReader;
import pl.edu.agh.two.parser.quiz.RawQuiz;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oem on 2015-11-22.
 */
public class QuizEventsFactory implements IEventsFactory {

    @Override
    public Map<String, IEvent> getEventsFromFile(String eventFileName) {
        //TODO
        return null;
    }

    @Override
    public Map<String, IEvent> getEventFromFile(String eventFileName) {
        ConfigReader<RawQuiz> configReader= new ConfigReader<>(RawQuiz.class);
        Map<String,IEvent> retVal=new HashMap<String,IEvent>();
        RawQuiz rawQuiz=configReader.readConfig(eventFileName);
        //TODO
        return null;
    }
}

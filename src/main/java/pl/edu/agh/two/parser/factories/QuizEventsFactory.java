package pl.edu.agh.two.parser.factories;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import pl.edu.agh.two.console.GameConsole;
import pl.edu.agh.two.domain.events.EventWithDescription;
import pl.edu.agh.two.domain.events.IEvent;
import pl.edu.agh.two.domain.events.PickItemEvent;
import pl.edu.agh.two.domain.events.quiz.Answer;
import pl.edu.agh.two.domain.events.quiz.Question;
import pl.edu.agh.two.domain.events.quiz.Quiz;
import pl.edu.agh.two.domain.items.IItem;
import pl.edu.agh.two.parser.ConfigReader;
import pl.edu.agh.two.parser.events.quiz.RawAnswer;
import pl.edu.agh.two.parser.events.quiz.RawEndText;
import pl.edu.agh.two.parser.events.quiz.RawQuestion;
import pl.edu.agh.two.parser.events.quiz.RawQuiz;
import pl.edu.agh.two.parser.exceptions.NoSuchItemTypeException;
import pl.edu.agh.two.repositories.ItemsRepository;

/**
 * Created by oem on 2015-11-22.
 */
public class QuizEventsFactory implements IEventsFactory {

    private final GameConsole gameConsole;

    public QuizEventsFactory(GameConsole gameConsole) {
        this.gameConsole = gameConsole;
    }

    @Override
    public IEvent getEventFromFile(String eventFileName, GameConsole gameConsole) {

        ConfigReader<RawQuiz> configReader= new ConfigReader<>(RawQuiz.class);
        Map<String,IEvent> retVal=new HashMap<String,IEvent>();
        RawQuiz rawQuiz=configReader.readConfig(eventFileName);

        LinkedList<Question> questions=new LinkedList<Question>();
        for(RawQuestion rawQuestion:rawQuiz.getQuestions()) {
            String questionText=rawQuestion.getQuestion();
            Set<Answer> answerSet=new HashSet<Answer>();
            for(RawAnswer rawAnswer:rawQuestion.getAnswers()) {
                answerSet.add(new Answer(rawAnswer.getAnswer(),
                        //way of how score is turn into an answer
                        rawAnswer.getPoints()));
            }
            questions.addLast(new Question(questionText,answerSet));
        }
        //list of questions created

        List<RawEndText> rawEndTexts= rawQuiz.getEndTexts();
        Quiz quiz = new Quiz(questions, rawQuiz.getIntroduction());
        Map<Set<Integer>,IEvent> resultMap=new HashMap<>();

        for(RawEndText endText:rawEndTexts) {
            Set<Integer> resultSet=new HashSet<Integer>();
            for(int result:endText.getForNotes()) {
                resultSet.add(result);
            }

            IEvent awardEvent;
            //deciding whether the event is an item pick event, or text event
            if(endText.getAwards()==null) {
                EventWithDescription awardDescriptionEvent=new EventWithDescription();
                awardDescriptionEvent.setEventDescription(endText.getTextToDisplay());
                awardDescriptionEvent.setGameConsole(this.gameConsole);
                awardEvent=awardDescriptionEvent;
            } else {
                //pick up item
                //item creation
                IItem item=ItemsRepository.getItem(endText.getAwards().get(0).getItemName());
                if(item==null) {
                    throw new NoSuchItemTypeException();
                }
                PickItemEvent pickItemEvent = new PickItemEvent(item);
                awardEvent = pickItemEvent;
                pickItemEvent.setGameConsole(this.gameConsole);
            }
            resultMap.put(resultSet,awardEvent);
        }

        quiz.setPointsToEvents(resultMap);
        quiz.setGameConsole(gameConsole);
        return quiz;
    }

}

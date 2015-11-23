package pl.edu.agh.two.parser.factories;

import pl.edu.agh.two.domain.events.IEvent;
import pl.edu.agh.two.domain.events.quiz.Answer;
import pl.edu.agh.two.domain.events.quiz.BasicAnswerFormatter;
import pl.edu.agh.two.domain.events.quiz.Question;
import pl.edu.agh.two.domain.events.quiz.Quiz;
import pl.edu.agh.two.parser.ConfigReader;
import pl.edu.agh.two.parser.quiz.RawAnswer;
import pl.edu.agh.two.parser.quiz.RawEndText;
import pl.edu.agh.two.parser.quiz.RawQuestion;
import pl.edu.agh.two.parser.quiz.RawQuiz;

import java.util.*;

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

        LinkedList<Question> questions=new LinkedList<Question>();
        for(RawQuestion rawQuestion:rawQuiz.getQuestions()) {
            String questionText=rawQuestion.getQuestion();
            Set<Answer> answerSet=new HashSet<Answer>();
            for(RawAnswer rawAnswer:rawQuestion.getAnswers()) {
                answerSet.add(new Answer(rawAnswer.getAnswer(),
                        //way of how score is turn into an answer
                        rawAnswer.getPoints() > 0? true:false));
            }
            questions.addLast(new Question(questionText,answerSet));
        }
        //list of questions created

        //XXX there is a problem in turning answers into quiz model
        //(multiple end texts and results in jsons, only one boolean in model)
        //temporary (UGLY) fix - lowest score from the second "for notes"
        // form the bottom is sufficient to pass
        //the least number of good questions to pass
        List<RawEndText> rawEndTexts= rawQuiz.getEndTexts();
        rawEndTexts.sort(new EndTextComparator());
        Collections.sort(rawEndTexts.get(1).getForNotes());
        int lowestScore=rawEndTexts.get(1).getForNotes().get(0);

        Quiz quiz=new Quiz(questions,lowestScore);
        retVal.put(rawQuiz.getName(),quiz);
        return retVal;
    }

        //for sorting EndTextComparators by lowest score
    private static class EndTextComparator implements Comparator<RawEndText> {

        @Override
        public int compare(RawEndText o1, RawEndText o2) {
            List<Integer> l1=o1.getForNotes();
            List<Integer> l2=o2.getForNotes();
            Collections.sort(l1);
            Collections.sort(l2);
            return (l1.get(0)>l2.get(0))?1:
                    (l1.get(0)==l2.get(0)?0:-1);
        }
    }
}

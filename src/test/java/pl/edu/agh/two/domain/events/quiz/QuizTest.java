package pl.edu.agh.two.domain.events.quiz;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import pl.edu.agh.two.console.GameConsole;
import pl.edu.agh.two.domain.events.IEvent;
import pl.edu.agh.two.domain.players.IPlayer;

/**
 * Created by Mateusz Pszczolka on 11/24/2015.
 */
@RunWith(MockitoJUnitRunner.class)
public class QuizTest {

    @Mock
    IPlayer player;
    @Mock
    GameConsole gameConsole;
    @Mock
    IEvent subEventExpectedTrigger;
    @Mock
    IEvent subEventNotTriggered;

    public Quiz quiz1;

    @Before
    public void setUp() {
        quiz1 = new Quiz(Arrays.asList(
                new Question("question 1", Arrays.asList(
                        new Answer("correct Answer", 1),
                        new Answer("second correct Answer", 2),
                        new Answer("wrong answer", 0)
                ))
        ));
        quiz1.setGameConsole(gameConsole);
    }

    @Test
    public void testExecutePrintln() throws Exception {
        when(gameConsole.readLine()).thenReturn("a,b");
        quiz1.execute(player);

        Mockito.verify(gameConsole).println("question 1");
        Mockito.verify(gameConsole).println("\ta) correct Answer");
        Mockito.verify(gameConsole).println("\tb) second correct Answer");
        Mockito.verify(gameConsole).println("\tc) wrong answer");
    }
    @Test
    public void testExecuteOneAnswer() throws Exception {
        when(gameConsole.readLine()).thenReturn("b");
        quiz1.setPointsToEvents(new HashMap() {
            {
                put(new HashSet<>(Arrays.asList(2)), subEventExpectedTrigger);
                put(new HashSet<>(Arrays.asList(0, 1, 3, 4)), subEventNotTriggered);
            }
        });
        quiz1.execute(player);

        verify(subEventExpectedTrigger).execute(player);
        verifyNoMoreInteractions(subEventNotTriggered);
    }
    @Test
    public void testExecuteTwoAnswers() throws Exception {
        when(gameConsole.readLine()).thenReturn("b,a");
        quiz1.setPointsToEvents(new HashMap() {
            {
                put(new HashSet<>(Arrays.asList(3)), subEventExpectedTrigger);
                put(new HashSet<>(Arrays.asList(0, 1, 2, 4)), subEventNotTriggered);
            }
        });
        quiz1.execute(player);

        verify(subEventExpectedTrigger).execute(player);
        verifyNoMoreInteractions(subEventNotTriggered);
    }
    @Test
    public void testExecuteTwoAnswersNoAllSets() throws Exception {
        when(gameConsole.readLine()).thenReturn("b,a");
        quiz1.setPointsToEvents(new HashMap() {
            {
                put(new HashSet<>(Arrays.asList(3)), subEventExpectedTrigger);
            }
        });
        quiz1.execute(player);

        verify(subEventExpectedTrigger).execute(player);
        verifyNoMoreInteractions(subEventNotTriggered);
    }
    @Test
    public void testExecuteWrongAnswer() throws Exception {
        when(gameConsole.readLine()).thenReturn("c");
        quiz1.setPointsToEvents(new HashMap() {
            {
                put(new HashSet<>(Arrays.asList(0)), subEventExpectedTrigger);
                put(new HashSet<>(Arrays.asList(1,2,3)), subEventNotTriggered);
            }
        });
        quiz1.execute(player);

        verify(subEventExpectedTrigger).execute(player);
        verifyNoMoreInteractions(subEventNotTriggered);
    }
}
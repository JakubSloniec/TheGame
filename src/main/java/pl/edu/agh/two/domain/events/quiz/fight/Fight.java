package pl.edu.agh.two.domain.events.quiz.fight;

import java.util.List;

import pl.edu.agh.two.console.GameConsole;
import pl.edu.agh.two.domain.attributes.Attribute;
import pl.edu.agh.two.domain.events.quiz.Answer;
import pl.edu.agh.two.domain.events.quiz.Question;
import pl.edu.agh.two.domain.events.quiz.Quiz;
import pl.edu.agh.two.domain.items.IContextFinishListener;
import pl.edu.agh.two.domain.items.IItem;
import pl.edu.agh.two.domain.items.IUsageContext;
import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;
import pl.edu.agh.two.exceptions.ContextRequireException;
import pl.edu.agh.two.exceptions.ItemNotInBackpackException;
import pl.edu.agh.two.parser.command.Action;
import pl.edu.agh.two.parser.command.Command;
import pl.edu.agh.two.parser.command.CommandParser;
import pl.edu.agh.two.parser.exceptions.ParseException;
import pl.edu.agh.two.repositories.ItemsRepository;

/**
 * Created by Puszek_SE on 2015-12-22.
 */
public class Fight extends Quiz implements IUsageContext {

    IEnemy enemy;
    IPlayer player;
    List<IContextFinishListener> fightFinishListeners;

    public Fight(List<Question> questionList, IEnemy enemy) {
        super(questionList);
        this.enemy = enemy;
    }

    @Override
    protected int executeQuiz(IPlayer player) {
        this.player = player;
        return super.executeQuiz(player);
    }

    @Override
    protected String getAnswerText(Answer answer) {
        StringBuffer buffer = new StringBuffer(answer.getText()).append("\n");
        if (answer instanceof FightAnswer) {
            modifier((FightAnswer) answer, buffer);
        }
        return buffer.toString();
    }

    @Override
    public String getEventDescription() {
        StringBuffer buffer = new StringBuffer(super.getEventDescription());
        buffer.append("Enemie's power: ").append(enemy.getPower());
        if (!enemy.getStatistics().isEmpty())
            buffer.append("\nStats: ");
        for (IPlayerStatistic statistic : enemy.getStatistics()) {
            buffer.append("[").append(statistic.getAttribute().getName()).append(" ").append(statistic.getCurrentValue()).append("]; ");
        }
        return buffer.toString();
    }

    private void modifier(FightAnswer answer, StringBuffer buffer) {
        Attribute attribute = answer.getAttribute();
        if (attribute != null) {
            int modifier = (int) (player.getStatistic(attribute).getCurrentValue() - enemy.getStatistic(attribute));
            answer.updateModifier(modifier);
            String name = attribute.getName();
            buffer.append("Answer is based upon '").append(name).append("'\n");
            buffer.append("Achieved modifier equals: ").append(modifier).append("\n");
        }
    }

    @Override
    protected int resultEvents(IPlayer player, int damageDealt) {
        final int finalEnemyPowerBalance = damageDealt - enemy.getPower();
        pointsToEvents.forEach((pointsSet, event) -> {
            if (pointsSet.stream().anyMatch(powerBalance -> powerBalance <= finalEnemyPowerBalance)) {
                event.execute(player);
            }
        });
        return finalEnemyPowerBalance;
    }

    @Override
    public GameConsole getGameConsole() {
        final GameConsole originalGameConsole = super.getGameConsole();
        return new GameConsole() {
            @Override
            public void println(String string) {
                originalGameConsole.println(string);
            }

            @Override
            public String readLine() {
                CommandParser commandParser = new CommandParser();
                String line = originalGameConsole.readLine();
                try {
                    Command comand = commandParser.parse(line);
                    if (comand.getAction() == Action.USE) {
                        try {
                            useItem(ItemsRepository.getItem(comand.getRest()));
                        } catch (ItemNotInBackpackException | ContextRequireException e) {
                            println(e.getMessage());
                        }
                        return readLine();
                    } else {
                        return line;
                    }

                } catch (ParseException e) {
                    return line;
                }
            }

            @Override
            public void winGame() {
                originalGameConsole.winGame();
            }

            @Override
            public void display(String string) {
                originalGameConsole.display(string);
            }
        };
    }

    public void useItem(IItem item) throws ItemNotInBackpackException, ContextRequireException {
        item.use(player, this);
    }

    @Override
    protected void cleanUp() {
        super.cleanUp();
        fightFinishListeners.forEach(IContextFinishListener::onFinish);
    }

    @Override
    protected void onIncorrectAnswer() {
        getGameConsole().println("Weak attack...");
    }

    @Override
    protected void onCorrectAnswer() {
        getGameConsole().println("Successful attack!");
    }

    @Override
    public void registerOnFinishListener(IContextFinishListener contextFinishListener) {
        fightFinishListeners.add(contextFinishListener);
    }
}

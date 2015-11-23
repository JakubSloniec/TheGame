package pl.edu.agh.two.factories;

import pl.edu.agh.two.domain.players.Backpack;
import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.domain.players.Player;
import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;

import java.util.Set;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class PlayersFactory {

    public static IPlayer createDefaultPlayer(String name) {
        return new Player(name, Backpack.createBackpack(), PlayerStatisticsFactory.createDefaultPlayerStatistics());
    }

    public static IPlayer createPlater(String name, Set<IPlayerStatistic> playerStatistics) {
        return new Player(name, Backpack.createBackpack(), playerStatistics);
    }

}

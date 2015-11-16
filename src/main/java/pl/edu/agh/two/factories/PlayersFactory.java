package pl.edu.agh.two.factories;

import pl.edu.agh.two.domain.players.Backpack;
import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.domain.players.Player;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class PlayersFactory {

    public static IPlayer createPlayer(String name) {
        return new Player(name, Backpack.createBackpack(), PlayerStatisticsFactory.createDefaultPlayerStatistics());
    }

}

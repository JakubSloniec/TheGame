package pl.edu.agh.two.theGame.model.rooms;

import pl.edu.agh.two.theGame.model.player.Player;
import pl.edu.agh.two.theGame.model.player.PlayerStatistic;

public class StatisticsRequiredToEnter<T extends Number> extends BasicRoom {
    private final PlayerStatistic<T> requiredStatistic;
    private final T minimumValue;

    public StatisticsRequiredToEnter(PlayerStatistic<T> requiredStatistic, T minimumValue) {
        this.requiredStatistic = requiredStatistic;
        this.minimumValue = minimumValue;
    }

    @Override
    public boolean tryEnter(Room previousRoom, Player player) {
        super.tryEnter(previousRoom, player);
        final double testValue = player.getStatistic(requiredStatistic).doubleValue();
        return testValue >= minimumValue.doubleValue();
    }
}

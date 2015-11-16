package pl.edu.agh.two.domain.rooms;

import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.domain.players.statistics.IPlayerStatistic;

public class StatisticsRequiredToEnter<T extends Number> extends BasicRoom {
    private final IPlayerStatistic<T> requiredStatistic;
    private final T minimumValue;

    public StatisticsRequiredToEnter(IPlayerStatistic<T> requiredStatistic, T minimumValue) {
        this.requiredStatistic = requiredStatistic;
        this.minimumValue = minimumValue;
    }

    @Override
    public boolean tryEnter(Room previousRoom, IPlayer player) {
        super.tryEnter(previousRoom, player);
        final double testValue = player.getStatistic(requiredStatistic).doubleValue();
        return testValue >= minimumValue.doubleValue();
    }
}

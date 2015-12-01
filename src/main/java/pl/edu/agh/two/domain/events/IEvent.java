package pl.edu.agh.two.domain.events;

import pl.edu.agh.two.domain.players.IPlayer;

public interface IEvent {

    void execute(IPlayer player);

    boolean isFinished();

}

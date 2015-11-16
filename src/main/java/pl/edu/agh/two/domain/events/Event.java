package pl.edu.agh.two.domain.events;

import pl.edu.agh.two.domain.players.IPlayer;

public interface Event {

    void execute(IPlayer player);

}

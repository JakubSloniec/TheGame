package pl.edu.agh.two.theGame.model.events;

import pl.edu.agh.two.theGame.model.player.Player;

public interface Event {
    void execute(Player player);
}

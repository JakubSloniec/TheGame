package pl.edu.agh.two.domain.rooms;

import pl.edu.agh.two.domain.players.IPlayer;

import java.util.Optional;

/**
 * Created by ps_krzysztof on 2015-11-24.
 */
public class Wall extends AbstractRoom {

    public Wall(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void enterRoom(IPlayer player) {
    }

    @Override
    public void executeEvent(IPlayer player) {
    }

    @Override
    public Optional<IRoom> getAdjacentRoom(Direction direction) {
        return null;
    }

    @Override
    public boolean tryEnter(IPlayer player) {
        return false;
    }

}

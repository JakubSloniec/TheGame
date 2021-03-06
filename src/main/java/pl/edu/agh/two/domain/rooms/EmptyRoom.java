package pl.edu.agh.two.domain.rooms;

import pl.edu.agh.two.domain.players.IPlayer;

public class EmptyRoom extends AbstractRoom {

    public EmptyRoom(Coordinates coordinates) {
        super(coordinates);
    }

    @Override
    public void enterRoom(IPlayer player) {
    }

    @Override
    public void executeEvent(IPlayer player) {
    }

    public static class Builder extends AbstractRoom.Builder<EmptyRoom> {

        public Builder(Coordinates coordinates) {
            super(new EmptyRoom(coordinates));
        }

    }

}

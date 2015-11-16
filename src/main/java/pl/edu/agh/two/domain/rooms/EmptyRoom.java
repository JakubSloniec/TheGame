package pl.edu.agh.two.domain.rooms;

import pl.edu.agh.two.domain.players.IPlayer;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class EmptyRoom extends AbstractRoom {

    public static class Builder extends AbstractRoom.Builder<EmptyRoom> {

        public Builder() {
            super(new EmptyRoom());
        }

    }


    @Override
    public void enterRoom(IPlayer player) {
    }

    @Override
    public void executeEvent(IPlayer player) {
    }

}
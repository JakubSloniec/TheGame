package pl.edu.agh.two.domain.rooms;

import pl.edu.agh.two.domain.players.IPlayer;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class MessageRoom extends AbstractRoom {

    public static class Builder extends AbstractRoom.Builder<MessageRoom> {

        public Builder(String message) {
            super(new MessageRoom(message));
        }

    }

    private final String message;

    public MessageRoom(String message) {
        this.message = message;
    }

    @Override
    public void enterRoom(IPlayer player) {
        if(getGameConsole().isPresent()) {
            getGameConsole().get().display(message);
        }
    }

    @Override
    public void executeEvent(IPlayer player) {
    }

}

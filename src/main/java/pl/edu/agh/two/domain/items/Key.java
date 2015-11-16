package pl.edu.agh.two.domain.items;

import pl.edu.agh.two.domain.players.IPlayer;

/**
 * Created by ps_krzysztof on 2015-11-17.
 */
public class Key extends AbstractItem {

    public static class Builder extends AbstractItem.Builder<Key> {

        protected Builder(String name) {
            super(new Key(name));
        }

    }

    public Key(String name) {
        super(name);
    }

    @Override
    public void use(IPlayer player) {

    }
}

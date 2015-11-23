package pl.edu.agh.two.domain.items;

import pl.edu.agh.two.domain.players.IPlayer;
import pl.edu.agh.two.exceptions.ContextRequireException;
import pl.edu.agh.two.exceptions.ItemNotInBackpackException;

public interface IItem {

    public String getName();

    public String getIconName();

    void use(IPlayer player) throws ItemNotInBackpackException, ContextRequireException;

    default void use(IPlayer player, IUsageContext usageContext) throws ItemNotInBackpackException, ContextRequireException {
        use(player);
    }

}

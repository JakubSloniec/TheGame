package pl.edu.agh.two.domain.items;

import pl.edu.agh.two.domain.players.IPlayer;

public interface IItem {

    public String getName();

    public String getIconName();

    public void use(IPlayer player);

}

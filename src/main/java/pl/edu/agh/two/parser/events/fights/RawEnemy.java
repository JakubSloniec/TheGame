package pl.edu.agh.two.parser.events.fights;

import pl.edu.agh.two.parser.map.RawAttribute;

import java.util.List;

/**
 * Created by Michal Mrowczyk on 12/1/2015.
 */
public class RawEnemy {
    private int hp;
    private List<RawAttribute> attributes;

    public int getHP() {
        return hp;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public List<RawAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<RawAttribute> attributes) {
        this.attributes = attributes;
    }
}

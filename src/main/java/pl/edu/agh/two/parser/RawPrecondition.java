package pl.edu.agh.two.parser;

import java.util.List;

/**
 * Created by Michal Mrowczyk on 11/17/2015.
 */
public class RawPrecondition {

    private List<RawAttribute> attributes;
    private List<RawItem> items;

    public List<RawAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<RawAttribute> attributes) {
        this.attributes = attributes;
    }

    public List<RawItem> getItems() {
        return items;
    }

    public void setItems(List<RawItem> items) {
        this.items = items;
    }
}

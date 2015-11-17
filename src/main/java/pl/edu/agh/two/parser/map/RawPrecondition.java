package pl.edu.agh.two.parser.map;

import java.util.List;

/**
 * Created by Michal Mrowczyk on 11/17/2015.
 */
public class RawPrecondition {

    private List<RawAttribute> attributes;

    // I am not sure if the list of items will be ultimately a list of String's, but leaving it for now
    private List<String> items;

    public List<RawAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<RawAttribute> attributes) {
        this.attributes = attributes;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}

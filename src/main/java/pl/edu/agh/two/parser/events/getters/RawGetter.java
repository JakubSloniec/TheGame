package pl.edu.agh.two.parser.events.getters;

import java.util.List;

/**
 * Created by Michal Mrowczyk on 11/24/2015.
 */
public class RawGetter {
    private String textToDisplay;
    private List<RawGetterItem> items;

    public List<RawGetterItem> getItems() {
        return items;
    }

    public void setItems(List<RawGetterItem> items) {
        this.items = items;
    }

    public String getTextToDisplay() {
        return textToDisplay;
    }

    public void setTextToDisplay(String textToDisplay) {
        this.textToDisplay = textToDisplay;
    }


}

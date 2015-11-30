package pl.edu.agh.two.parser.item;

import java.util.List;

/**
 * Created by Michal Mrowczyk on 11/17/2015.
 */
public class RawItem {
    private String itemName;
    private String itemIcon;
    private String usage;
    private List<RawItemAttribute> attributes;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(String itemIcon) {
        this.itemIcon = itemIcon;
    }

    public String getUsage() {
        return usage;
    }

    public void setUsage(String usage) {
        this.usage = usage;
    }

    public List<RawItemAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<RawItemAttribute> attributes) {
        this.attributes = attributes;
    }
}
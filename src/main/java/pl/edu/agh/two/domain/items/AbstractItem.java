package pl.edu.agh.two.domain.items;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public abstract class AbstractItem implements IItem {

    protected static class Builder<T extends AbstractItem> {

        protected T item;

        protected Builder(T item) {
            this.item = item;
        }

        public Builder<T> setIconName(String iconName) {
            item.setIconName(iconName);
            return this;
        }

    }

    public final String name;
    public String iconName;

    protected AbstractItem(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

}

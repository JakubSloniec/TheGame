package pl.edu.agh.two.domain.items;

public class SimpleItem implements Item {

    private final String name;

    public SimpleItem(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}

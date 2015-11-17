package pl.edu.agh.two.domain.attributes;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class ItemAttribute<T extends Number> {

    private final Attribute<T> attribute;
    private final T changeValue;

    private ItemAttribute(Attribute<T> attribute, T changeValue) {
        this.attribute = attribute;
        this.changeValue = changeValue;
    }

    public Attribute<T> getAttribute() {
        return attribute;
    }

    public T getChangeValue() {
        return changeValue;
    }

    public static <T extends Number> ItemAttribute<T> createAttribute(Attribute<T> attribute, T changeValue) {
        return new ItemAttribute<>(attribute, changeValue);
    }



}

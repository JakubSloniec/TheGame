package pl.edu.agh.two.domain.attributes;

import java.util.Optional;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class Attribute<T extends Number> {

    private final String name;
    private final T minimumValue;
    private final T maximumValue;
    private final Optional<T> initialValue;

    private Attribute(String name, T minimumValue, T maximumValue, Optional<T> initialValue) {
        this.name = name;
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
        this.initialValue = initialValue;
    }

    public String getName() {
        return name;
    }

    public T getMinimumValue() {
        return minimumValue;
    }

    public T getMaximumValue() {
        return maximumValue;
    }

    public Optional<T> getInitialValue() {
        return initialValue;
    }

    public static <T extends Number> Attribute<T> createAttribute(String name) {
        return new Attribute<>(name, null, null, null);
    }

    public static <T extends Number> Attribute<T> createAttributeWithRange(String name, T minimum, T maximum, Optional<T> initialValue) {
        return new Attribute<T>(name, minimum, maximum, initialValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attribute)) return false;

        Attribute attribute = (Attribute) o;

        if (!name.equals(attribute.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

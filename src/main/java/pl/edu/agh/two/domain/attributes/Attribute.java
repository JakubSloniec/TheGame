package pl.edu.agh.two.domain.attributes;

import java.util.Optional;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class Attribute {

    private final String name;
    private final Double minimumValue;
    private final Double maximumValue;
    private final Optional<Double> initialValue;

    protected Attribute(String name, Double minimumValue, Double maximumValue, Optional<Double> initialValue) {
        this.name = name;
        this.minimumValue = minimumValue;
        this.maximumValue = maximumValue;
        this.initialValue = initialValue;
    }

    public String getName() {
        return name;
    }

    public Double getMinimumValue() {
        return minimumValue;
    }

    public Double getMaximumValue() {
        return maximumValue;
    }

    public Optional<Double> getInitialValue() {
        return initialValue;
    }

    public static Attribute createAttribute(String name) {
        return new Attribute(name, null, null, null);
    }

    public static Attribute createAttributeWithRange(String name, Double minimum, Double maximum, Optional<Double> initialValue) {
        return new Attribute(name, minimum, maximum, initialValue);
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

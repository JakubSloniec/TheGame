package pl.edu.agh.two.domain.attributes;

import java.lang.reflect.ParameterizedType;

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

    /**
     * It is ugly method, need refactoring or changes assumptions about T
     * @return
     */
    public T getOpositeOfChangeValue() {
        final double opositeValue = changeValue.doubleValue() * (-1);

        final ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        final Class<T> tClasss = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        return tClasss.cast(opositeValue);

    }

    public static <T extends Number> ItemAttribute<T> createAttribute(Attribute<T> attribute, T changeValue) {
        return new ItemAttribute<>(attribute, changeValue);
    }

}

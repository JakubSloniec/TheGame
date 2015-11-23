package pl.edu.agh.two.domain.attributes;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class ItemAttribute {

    private final Attribute attribute;
    private final Double changeValue;

    private ItemAttribute(Attribute attribute, Double changeValue) {
        this.attribute = attribute;
        this.changeValue = changeValue;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public Double getChangeValue() {
        return changeValue;
    }

    /**
     * It is ugly method, need refactoring or changes assumptions about T
     * @return
     */
    public Double getOpositeOfChangeValue() {
        return changeValue * (-1.0d);
    }

    public static ItemAttribute createAttribute(Attribute attribute, Double changeValue) {
        return new ItemAttribute(attribute, changeValue);
    }

}

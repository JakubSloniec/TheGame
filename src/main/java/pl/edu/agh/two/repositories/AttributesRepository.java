package pl.edu.agh.two.repositories;

import pl.edu.agh.two.configuration.ApplicationConstants;
import pl.edu.agh.two.domain.attributes.Attribute;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by ps_krzysztof on 2015-11-16.
 */
public class AttributesRepository {

    private static Map<String, Attribute> repository;

    static {
        repository = new HashMap<>();
        repository.put(ApplicationConstants.AVERAGE, createNewAttribute(ApplicationConstants.AVERAGE, 2.0, 5.0, Optional.empty()));
        repository.put(ApplicationConstants.YEAR_OF_STUDY, createNewAttribute(ApplicationConstants.YEAR_OF_STUDY, 1, 5, Optional.of(1)));
        repository.put(ApplicationConstants.SEMESTER_OF_STUDY, createNewAttribute(ApplicationConstants.SEMESTER_OF_STUDY, 1, 1, Optional.of(1)));
    }

    public static <T extends Number> Attribute<T> getAttribute(String name, T minimum, T maximum, T initialValue) {
        Optional<Attribute> attributeOptional = getOptionalAttribute(name);
        if (attributeOptional.isPresent()) {
            return attributeOptional.get();
        } else {
            return createNewAttribute(name, minimum, maximum, Optional.of(initialValue));
        }
    }

    private static <T extends Number> Attribute<T> createNewAttribute(String name, T minimum, T maximum, Optional<T> initialValue) {
        Attribute<T> attribute = Attribute.createAttributeWithRange(name, minimum, maximum, initialValue);
        repository.put(name, attribute);
        return attribute;
    }

    private static Optional<Attribute> getOptionalAttribute(String name) {
        return Optional.ofNullable(repository.get(name));
    }

}

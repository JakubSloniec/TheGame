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
        repository.put(ApplicationConstants.YEAR_OF_STUDY, createNewAttribute(ApplicationConstants.YEAR_OF_STUDY, 1d, 5d, Optional.of(1d)));
        repository.put(ApplicationConstants.SEMESTER_OF_STUDY, createNewAttribute(ApplicationConstants.SEMESTER_OF_STUDY, 1d, 1d, Optional.of(1d)));
    }

    public static Attribute getAttribute(String name, Double minimum, Double maximum, Double initialValue) {
        Optional<Attribute> attributeOptional = getOptionalAttribute(name);
        if (attributeOptional.isPresent()) {
            return attributeOptional.get();
        } else {
            return createNewAttribute(name, minimum, maximum, Optional.of(initialValue));
        }
    }

    private static Attribute createNewAttribute(String name, Double minimum, Double maximum, Optional<Double> initialValue) {
        Attribute attribute = Attribute.createAttributeWithRange(name, minimum, maximum, initialValue);
        repository.put(name, attribute);
        return attribute;
    }

    private static Optional<Attribute> getOptionalAttribute(String name) {
        return Optional.ofNullable(repository.get(name));
    }

}

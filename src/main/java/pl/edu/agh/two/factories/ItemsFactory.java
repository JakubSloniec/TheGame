package pl.edu.agh.two.factories;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import pl.edu.agh.two.domain.attributes.Attribute;
import pl.edu.agh.two.domain.attributes.ItemAttribute;
import pl.edu.agh.two.domain.items.IItem;
import pl.edu.agh.two.domain.items.Key;
import pl.edu.agh.two.domain.items.PermanentAttributeItem;
import pl.edu.agh.two.domain.items.TemporaryAttributeItem;
import pl.edu.agh.two.repositories.ItemsRepository;

public class ItemsFactory {
    public static IItem createTemporaryItem(String name, Optional<Map<String, Double>> attributes, Optional<String> iconName) {
        return tryFind(name, () -> {
            TemporaryAttributeItem.Builder builder = new TemporaryAttributeItem.Builder(
                    name,
                    attributes.orElse(new HashMap<>())
                            .entrySet()
                            .stream()
                            .map(
                                    attributeNumberEntry -> ItemAttribute.createAttribute(
                                            Attribute.createAttribute(attributeNumberEntry.getKey()),
                                            attributeNumberEntry.getValue()
                                    )
                            ).collect(Collectors.toSet())
            );
            iconName.ifPresent(builder::setIconName);
            return builder.build();
        });
    }

    public static IItem createKeyItem(String name, Optional<String> iconName) {
        return tryFind(name, () -> {
            Key.Builder builder = new Key.Builder(name);
            iconName.ifPresent(builder::setIconName);
            return builder.build();
        });
    }

    private static IItem tryFind(String name, Supplier<IItem> supplier) {
        IItem item = ItemsRepository.getItem(name);
        if (item != null) {
            return item;
        } else {
            IItem iItem = supplier.get();
            ItemsRepository.addItem(iItem);
            return iItem;
        }
    }

    public static IItem createPernamentItem(String name, Optional<Map<String, Double>> attributes, Optional<String> iconName) {
        return tryFind(name, () -> {
            PermanentAttributeItem.Builder builder = new PermanentAttributeItem.Builder(
                    name,
                    attributes.orElse(new HashMap<>())
                            .entrySet()
                            .stream()
                            .map(
                                    attributeNumberEntry -> ItemAttribute.createAttribute(
                                            Attribute.createAttribute(attributeNumberEntry.getKey()),
                                            attributeNumberEntry.getValue()
                                    )
                            ).collect(Collectors.toSet())
            );
            iconName.ifPresent(builder::setIconName);
            return builder.build();
        });
    }
}
package pl.edu.agh.two.parser.factories;

import pl.edu.agh.two.domain.items.IItem;
import pl.edu.agh.two.repositories.ItemsRepository;

import java.io.File;

/**
 * Created by oem on 2015-11-30.
 */
public class ItemsInitializer {
    public static void initializeItems() {
        ClassLoader classLoader=ItemsInitializer.class.getClassLoader();
        File itemsFolder=new File(classLoader.getResource("plotConfig/items").getFile());
        for(String itemFileName:itemsFolder.list()) {
            IItem item=IItemParsingFactory.getItemFromFile("plotConfig/items/"+itemFileName);
            ItemsRepository.addItem(item);
        }
    }
}

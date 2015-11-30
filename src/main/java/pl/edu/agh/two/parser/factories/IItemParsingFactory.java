package pl.edu.agh.two.parser.factories;

import pl.edu.agh.two.domain.items.IItem;
import pl.edu.agh.two.factories.ItemsFactory;
import pl.edu.agh.two.parser.ConfigReader;
import pl.edu.agh.two.parser.exceptions.NoSuchItemTypeException;
import pl.edu.agh.two.parser.item.RawItem;
import pl.edu.agh.two.parser.item.RawItemAttribute;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by oem on 2015-11-30.
 */
public class IItemParsingFactory {

    public static IItem getItemFromFile(String itemFileName) {
        ConfigReader<RawItem> configReader=new ConfigReader<>(RawItem.class);
        RawItem rawItem=configReader.readConfig(itemFileName);
        IItem retVal=null;
        Map<String,Double> attributeMap=new HashMap<String,Double>();
        for(RawItemAttribute attribute:rawItem.getAttributes()) {
            attributeMap.put(attribute.getAttrName(),Double.parseDouble(attribute.getChange()));
        }
        switch(rawItem.getUsage()) {
            case "INSTANT":
                retVal= ItemsFactory.createTemporaryItem(rawItem.getItemName(), Optional.of(attributeMap), Optional.<String>empty());
                break;
            case "CONST":
                retVal=ItemsFactory.createPernamentItem(rawItem.getItemName(), Optional.of(attributeMap), Optional.<String>empty());
                break;
            default:
                throw new NoSuchItemTypeException();
        }
        return retVal;
    }
}

package parser;

/**
 * Created by Michal Mrowczyk on 11/10/2015.
 */

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * MapConfigReader class reads JSON file representing map configuration
 */
public class MapConfigReader {

    private ObjectMapper mapper;

    public MapConfigReader() {
        mapper = new ObjectMapper();
    }

    public RawMap readMapConfig(String fileName) {
        // Getting JSON resource representing game map.
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        RawMap gameMap = null;

        try {
            // Convert JSON string from file to RawMap object
            gameMap = mapper.readValue(file, RawMap.class);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return gameMap;
    }

    public String prettyPrint(RawMap gameMap) {
        String prettyGameMapString = null;
        try {
            prettyGameMapString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(gameMap);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return prettyGameMapString;
    }
}

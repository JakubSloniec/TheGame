package pl.edu.agh.two.parser;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * Created by Michal Mrowczyk on 11/17/2015.
 */
public class ConfigReader<T> {

    private ObjectMapper mapper;
    private Class<T> clazz;

    // This is an abomination, but that how it works in Java - generics are for compile time
    // validation - not for runtime dynamic typing, blah, blah, blah ...
    public ConfigReader(Class<T> clazzz) {
        clazz = clazzz;
        mapper = new ObjectMapper();
    }

    // Reading fileName file from resources
    public T readConfig(String fileName) {
        // Getting JSON resource representing game map.
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        T rawObject = null;

        try {
            // Convert JSON string from file to T object
            rawObject = mapper.readValue(file, clazz);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return rawObject;
    }

    // Pretty printing raw object (map, item, quiz)
    public void prettyPrint(T rawObject) {
        String prettyGameMapString = null;
        try {
            prettyGameMapString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rawObject);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(prettyGameMapString);
    }
}

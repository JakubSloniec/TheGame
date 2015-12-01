package pl.edu.agh.two.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Jakub Sloniec
 * @since 17 lis 2015
 */
public class PropertyManager {

	private static Properties properties = new Properties();
	private static String propFileName = "gui/config.properties";

	private static InputStream inputStream;

	static {
		try {
			new PropertyManager();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private PropertyManager() throws IOException {
		inputStream = getClass().getClassLoader().getResourceAsStream(getPropFileName());
		if (inputStream != null) {
			properties.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + getPropFileName() + "' not found in the classpath");
		}
	}

	public static String getPropFileName() {
		return propFileName;
	}

	public static String getProperty(String propertyKey) {
		return (String) properties.get(propertyKey);
	}

	public void setPropFileName(String propFileName) {
		PropertyManager.propFileName = propFileName;
		PropertyManager.inputStream = getClass().getClassLoader().getResourceAsStream(getPropFileName());
	}

}

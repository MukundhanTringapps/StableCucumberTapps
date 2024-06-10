package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;

import constants.FrameworkConstants;
import enums.ProjectConfig;
import exceptions.PropertyFileUsageException;

public final class PropertyUtils {

	private PropertyUtils() {
	}

	private static Properties prop = new Properties();
	private static final Map<String, String> CONFIGMAP = new HashMap<>();

	static {
		try (FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath())) {
			prop.load(file);
			for (Entry<Object, Object> keyValuePair : prop.entrySet()) {
				
				String key = String.valueOf(keyValuePair.getKey());
				String value = String.valueOf(keyValuePair.getValue()).trim();
				
				CONFIGMAP.put(key, value);
			}
		} catch (IOException e) {
			e.getStackTrace();
			System.exit(0);
		}
	}

	public static String getValueFromConfigMap(ProjectConfig key) {
		if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
			throw new PropertyFileUsageException(String.format("The key %s is not found in the config file", key));
		}
		return CONFIGMAP.get(key.name().toLowerCase());
	}
}
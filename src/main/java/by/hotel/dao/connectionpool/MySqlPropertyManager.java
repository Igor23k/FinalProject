package by.hotel.dao.connectionpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;

/**
 * MySqlPropertyManager.java
 * This class implements a pattern singleton. This class derives from the
 * configuration file settings for the database.
 * @author Igor Kozlov
 * @version 2.0
 */
public class MySqlPropertyManager {
	/**
	 * It is a logger which print some messages to log file.
	 */
	private static final Logger logger = LogManager.getLogger(MySqlPropertyManager.class.getName());

	private final String PATH = "config.properties";
	private final String PREFIX = this.getClass().getResource("/").getPath();

	private Properties properties = new Properties();
	private BufferedReader reader = null;
	private File file = new File(PREFIX + PATH);

	/**
	 * The inner class for implementation singleton. It holds
	 * MySqlPropertyManager instance.
	 */
	private static class Holder {
		private static final MySqlPropertyManager INSTANCE = new MySqlPropertyManager();
	}

	/**
	 * The method gives MySqlPropertyManager singleton instance.
	 */
	public static MySqlPropertyManager getInstance() {
		return Holder.INSTANCE;
	}

	/**
	 * The constructor creates BufferedReader and reads configuration file
	 * database.
	 */
	private MySqlPropertyManager() {
		try {
			reader = new BufferedReader(new FileReader(file));
			properties.load(reader);
		} catch (FileNotFoundException e) {
			logger.error("File db.properties not found.", e);
		} catch (IOException e) {
			logger.error(e);
		}
	}

	/**
	 * The method gives extract key parameters.
	 * @param key - to get value by this key
	 * @return String
	 */
	public String getValue(String key) {
		return properties.getProperty(key);
	}

}

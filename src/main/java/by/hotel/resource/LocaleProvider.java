package by.hotel.resource;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * LocaleProvider.java
 * Class to provide data for localization.
 * getLocale - method to get locale.
 * @author Igor Kozlov
 * @version 1.0
 */
public class LocaleProvider {
    /**
     * Field - field to store locales.
     */
    final private static Map<String, java.util.Locale> locales = new HashMap();

    static {
        locales.put("en", new Locale("en"));
        locales.put("ru", new Locale("ru"));
    }

    /**
     * Holder.java
     * This internal class is a template Singleton.
     * @author Igor Kozlov
     * @version 1.0
     */
    private static class Holder{
        /**
         * Field - this field need to be singleton of LocaleProvider class.
         */
        private final static LocaleProvider INSTANCE = new LocaleProvider();
    }

    /**
     * Get a singleton object.
     * @return singleton object.
     */
    public static LocaleProvider getInstance(){
        return LocaleProvider.Holder.INSTANCE;
    }

    /**
     * Get a command by name.
     * @param locale the operand to get a locale.
     * @return locale.
     */
    public Locale getLocale(String locale) {
        return locales.get(locale);
    }

}

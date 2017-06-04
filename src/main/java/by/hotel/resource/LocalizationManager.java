package by.hotel.resource;

import java.util.*;

/**
 * LocalizationManager.java
 * Class to provide data for localization.
 * getValue - method to get values from resources.
 * @author Igor Kozlov
 * @version 1.0
 */
public class LocalizationManager {
    /**
     * Field - field to store pageLabels.
     */
    private ResourceBundle pageLabels = ResourceBundle.getBundle("localization.pagecontent_generalLabels");
    /**
     * Field - field to store generalLabels.
     */
    private ResourceBundle generalLabels = ResourceBundle.getBundle("localization.pagecontent_generalLabels");
    /**
     * Field - field to store localeProvider.
     */
    private LocaleProvider localeProvider = LocaleProvider.getInstance();

    /**
     * Get values from resources.
     * @param locale the operand to use get data with this locale.
     * @param localePage the operand to get locale data to specific page.
     * @return singleton object.
     */
    public Map getValue(String locale, String localePage) {
        pageLabels = ResourceBundle.getBundle("localization.pagecontent_" + localePage, localeProvider.getLocale(locale));
        generalLabels = ResourceBundle.getBundle("localization.pagecontent_generalLabels", localeProvider.getLocale(locale));
        Enumeration bundlePageKeys = pageLabels.getKeys();
        Enumeration bundleGeneralKeys = generalLabels.getKeys();
        Map<String, String> result = new HashMap();
        while (bundlePageKeys.hasMoreElements() ) {
            String key = (String) bundlePageKeys.nextElement();
            String value = pageLabels.getString(key);
            result.put(key, value);
        }
        while (bundleGeneralKeys.hasMoreElements() ) {
            String key = (String) bundleGeneralKeys.nextElement();
            String value = generalLabels.getString(key);
            result.put(key, value);
        }
        return result;
    }
}

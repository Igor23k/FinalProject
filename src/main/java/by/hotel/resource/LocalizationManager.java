package by.hotel.resource;

import java.util.*;

public class LocalizationManager {
    private ResourceBundle pageLabels = ResourceBundle.getBundle("localization.pagecontent_generalLabels");
    private ResourceBundle generalLabels = ResourceBundle.getBundle("localization.pagecontent_generalLabels");
    private LocaleProvider localeProvider = LocaleProvider.getInstance();

    public Map getValue(String locale, String localePage) {
        pageLabels = ResourceBundle.getBundle("localization.pagecontent_" + localePage, localeProvider.getCommand(locale));
        generalLabels = ResourceBundle.getBundle("localization.pagecontent_generalLabels", localeProvider.getCommand(locale));
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

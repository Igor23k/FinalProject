package by.hotel.resource;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class LocaleProvider {
    final private static Map<String, java.util.Locale> locales = new HashMap();

    static {
        locales.put("en", new Locale("en"));
        locales.put("ru", new Locale("ru"));
    }

    private static class Holder{
        private final static LocaleProvider INSTANCE = new LocaleProvider();
    }

    public static LocaleProvider getInstance(){
        return LocaleProvider.Holder.INSTANCE;
    }

    public Locale getCommand(String commandName) {
        return locales.get(commandName);
    }

}

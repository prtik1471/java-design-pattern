package org.logProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LoggerFactory {
    private static final Map<String, Supplier<Logger>> registry = new HashMap<>();

    public  static void registerAdapter(String name, Supplier<Logger> provider) {
        registry.put(name, provider);
    }

    public static Logger getLogger(String name) {
        if(!registry.containsKey(name)) {
            throw new IllegalArgumentException("No adapter found for this name " + name);
        }
        return registry.get(name).get();
    }
}

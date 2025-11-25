package org.logger;

public final class Logger {
    // eagerly initialized static instance guarantees thread safety
    private static final Logger INSTANCE = new Logger();
    private Logger() {
        // to prevent instantiating by reflection call
        if(INSTANCE != null) {
            System.out.println("instance not present");
        }
    }
    public static Logger getInstance() {
        return INSTANCE;
    }
}

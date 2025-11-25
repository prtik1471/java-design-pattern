package org.logger;

public final class ThreadSafeLazyLoadedLogger {
    // volatile to ensure atomic access to multiple threads
    private static volatile ThreadSafeLazyLoadedLogger instance;

    private ThreadSafeLazyLoadedLogger() {
        //protect against instantiation using reflection
        if(instance != null) {
            System.out.println("already instantiated");
        }
    }

    public static synchronized ThreadSafeLazyLoadedLogger getInstance() {
        if(instance == null) {
            instance = new ThreadSafeLazyLoadedLogger();
        }
        return instance;
    }


}

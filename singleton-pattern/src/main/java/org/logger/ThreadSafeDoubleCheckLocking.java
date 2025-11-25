package org.logger;

public final class ThreadSafeDoubleCheckLocking {
    //declared as volatile to ensure atomic access by multiple threads
    private static volatile ThreadSafeDoubleCheckLocking instance;

    private ThreadSafeDoubleCheckLocking() {
        if(instance != null) {
            System.out.println("already initialized");
        }
    }

    public static ThreadSafeDoubleCheckLocking getInstance() {
        var result = instance;

        //check if instance is initialized
        if(result == null) {

            //lock the object for mutual exclusion
            synchronized (ThreadSafeDoubleCheckLocking.class) {
                result = instance;
                //check again if instance is initialized while obtaining the lock
                if(result == null) {
                    result = new ThreadSafeDoubleCheckLocking();
                    instance = result;
                }
            }
        }
        return result;
    }

}

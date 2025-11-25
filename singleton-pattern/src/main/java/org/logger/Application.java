package org.logger;

public class Application {
    public static void main(String[] args) {
        //eager initialized
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();
        System.out.println(logger1);
        System.out.println(logger2);

        //lazily initialized
        ThreadSafeLazyLoadedLogger threadSafeLazyLoadedLogger1 = ThreadSafeLazyLoadedLogger.getInstance();
        ThreadSafeLazyLoadedLogger threadSafeLazyLoadedLogger2 = ThreadSafeLazyLoadedLogger.getInstance();
        System.out.println(threadSafeLazyLoadedLogger1);
        System.out.println(threadSafeLazyLoadedLogger2);

        //enum singleton
        EnumLogger enumLogger1 = EnumLogger.INSTANCE;
        EnumLogger enumLogger2 = EnumLogger.INSTANCE;
        System.out.println(enumLogger1);
        System.out.println(enumLogger2);

        //double-checked locking
        ThreadSafeDoubleCheckLocking threadSafeDoubleCheckLocking1 = ThreadSafeDoubleCheckLocking.getInstance();
        ThreadSafeDoubleCheckLocking threadSafeDoubleCheckLocking2 = ThreadSafeDoubleCheckLocking.getInstance();
        System.out.println(threadSafeDoubleCheckLocking1);
        System.out.println(threadSafeDoubleCheckLocking2);

        //initialize on demand holder idiom
        InitializingOnDemandHolderIdiom initializingOnDemandHolderIdiom1 = InitializingOnDemandHolderIdiom.getInstance();
        InitializingOnDemandHolderIdiom initializingOnDemandHolderIdiom2 = InitializingOnDemandHolderIdiom.getInstance();
        System.out.println(initializingOnDemandHolderIdiom1);
        System.out.println(initializingOnDemandHolderIdiom2);

    }
}

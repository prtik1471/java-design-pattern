package org.logger;

public class InitializingOnDemandHolderIdiom {

    //provides lazy loaded singleton class instance
    //Bill pugh implementation
    private static class HelperHolder {
        private static final InitializingOnDemandHolderIdiom INSTANCE = new InitializingOnDemandHolderIdiom();
    }

    private InitializingOnDemandHolderIdiom() {
        // precent instantiating using reflection
        if(HelperHolder.INSTANCE != null) {
            System.out.println("already initialized");
        }
    }

    public static InitializingOnDemandHolderIdiom getInstance() {
        return HelperHolder.INSTANCE;
    }
}

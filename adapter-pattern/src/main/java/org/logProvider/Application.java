package org.logProvider;

public class Application {
    public static void main(String[] args) {
        LoggerFactory.registerAdapter("console" , () -> new ConsoleAdapter(new ConsoleLogger()));
        LoggerFactory.registerAdapter("log4j" , () -> new Log4jAdapter(new Log4jLogger()));

        Logger logger = LoggerFactory.getLogger("console");
        logger.debug("logging for debug level");
        logger.log(Logger.LogLevel.ERROR, "log for error level");

        logger = LoggerFactory.getLogger("log4j");
        logger.debug("log4j logs for warning level");
    }
}

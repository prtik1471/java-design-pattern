package org.logProvider;

public class Log4jAdapter implements Logger {

    private final Log4jLogger log4j;

    public Log4jAdapter(Log4jLogger log4j) {
        this.log4j = log4j;
    }

    @Override
    public void info(String msg) {
        log4j.logInfo(msg);
    }

    @Override
    public void warn(String msg) {
        log4j.logWarn(msg);
    }

    @Override
    public void error(String msg) {
        log4j.logError(msg);
    }

    @Override
    public void debug(String msg) {
        log4j.logDebug(msg);
    }

    @Override
    public void log(LogLevel level, String msg) {
        switch (level) {
            case INFO -> log4j.logInfo(msg);
            case WARN -> log4j.logWarn(msg);
            case ERROR -> log4j.logError(msg);
            case DEBUG -> log4j.logDebug(msg);
        }
    }
}

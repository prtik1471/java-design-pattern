package org.logProvider;

public interface Logger {
    void info(String msg);
    void warn(String msg);
    void error(String msg);
    void debug(String msg);
    void log(LogLevel level, String msg);

    public enum LogLevel {
        DEBUG, WARN, ERROR, INFO
    }
}

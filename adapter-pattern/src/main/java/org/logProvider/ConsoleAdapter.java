package org.logProvider;

public class ConsoleAdapter implements Logger{
    // adapter needs to implement Target
    // and needs 1 instance of the adaptee
    private final ConsoleLogger consoleLogger;

    public ConsoleAdapter(ConsoleLogger consoleLogger) {
        this.consoleLogger = consoleLogger;
    }

    @Override
    public void info(String msg) {
        consoleLogger.print("[Info]: " + msg);
    }
    @Override
    public void error(String msg) {
        consoleLogger.print("[Error]: " + msg);
    }
    @Override
    public void debug(String msg) {
        consoleLogger.print("[Debug]: " + msg);
    }
    @Override
    public void warn(String msg) {
        consoleLogger.print("[Warn]: " + msg);
    }
    @Override
    public void log(LogLevel level, String msg) {
        consoleLogger.print("[" + level + "]: " + msg);
    }
}

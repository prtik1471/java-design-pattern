package org.logProvider;

public class ConsoleLogger {
    // adaptee
    // this has method print but client needs info, warn, error, debug levels
    // so we need to create an adapter to utilise this
    public void print(String msg) {
        System.out.println(msg);
    }
}

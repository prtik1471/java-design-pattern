package org.uiFactory;

public class FactoryMaker {
    public enum FactoryType {
        WINDOWS,
        LINUX,
        MAC
    }

    public static UIFactory makeFactory(FactoryType type) {
        return switch(type) {
            case WINDOWS -> new WindowsFactory();
            case MAC -> new MacFactory();
            case LINUX -> new LinuxFactory();
        };
    }
}

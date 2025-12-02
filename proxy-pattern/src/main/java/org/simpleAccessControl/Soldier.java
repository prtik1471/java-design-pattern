package org.simpleAccessControl;

public class Soldier {
    private final String name;

    public Soldier(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

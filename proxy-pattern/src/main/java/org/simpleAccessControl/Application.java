package org.simpleAccessControl;

public class Application {
    public static void main(String[] args) {
        Castle proxy = new CastleProxy(new ConcreteCastle());
        proxy.enter(new Soldier("infantry"));
        proxy.enter(new Soldier("archer"));
        proxy.enter(new Soldier("cavalry"));
        proxy.enter(new Soldier("bomber"));
    }
}

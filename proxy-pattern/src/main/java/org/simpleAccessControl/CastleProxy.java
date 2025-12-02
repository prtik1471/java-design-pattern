package org.simpleAccessControl;

public class CastleProxy implements Castle{
    private Castle concreteCastle;
    private int numSoldiers = 0;
    private static final int SOLDIERS_ALLOWED = 2;

    public CastleProxy(Castle castle) {
        this.concreteCastle = castle;
    }

    @Override
    public void enter(Soldier soldier) {
        if(numSoldiers < SOLDIERS_ALLOWED) {
            concreteCastle.enter(soldier);
            numSoldiers++;
        } else {
            System.out.println(soldier + " is not allowed to enter");
        }

    }
}

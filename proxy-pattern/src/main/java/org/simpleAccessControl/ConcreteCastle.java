package org.simpleAccessControl;

public class ConcreteCastle implements Castle{

    @Override
    public void enter(Soldier soldier) {
        System.out.println(soldier.toString() + " enters castle");
    }
}

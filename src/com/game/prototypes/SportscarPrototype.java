package com.game.prototypes;

public class SportscarPrototype extends CarPrototype{

    public SportscarPrototype() {

    }

    public SportscarPrototype(SportscarPrototype target) {
            super(target);
            if (target != null) {
            }
    }

    @Override
    public CarPrototype clone() {
        return new SportscarPrototype(this);
    }
}

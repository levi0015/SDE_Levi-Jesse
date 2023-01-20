package com.game.prototypes;

public class SUVPrototype extends CarPrototype {

    public SUVPrototype(SUVPrototype target) {
        super(target);
        if (target != null) {
        }
    }

    @Override
    public CarPrototype clone() {
        return new SUVPrototype(this);
    }
}

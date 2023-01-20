package com.game.prototypes;

public class LimousinePrototype extends CarPrototype {

    public LimousinePrototype(LimousinePrototype target) {
        super(target);
        if (target != null) {
        }
    }

    @Override
    public CarPrototype clone() {
        return new LimousinePrototype(this);
    }
}

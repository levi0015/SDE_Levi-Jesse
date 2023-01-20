package com.game.prototypes;

abstract public class CarPrototype {
    public int seats;
    public int hp;
    public String doorhandles;

    public CarPrototype() {

    }

    public CarPrototype(CarPrototype target) {
        if (target != null) {
            this.seats = target.seats;
            this.hp = target.hp;
            this.doorhandles = target.doorhandles;
        }
    }

    public abstract CarPrototype clone();
}

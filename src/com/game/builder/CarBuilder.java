package com.game.builder;

import java.util.ArrayList;

public class CarBuilder implements Builder{

    private Car car;

    public void CarBuilder(){
        this.reset();
    }

    @Override
    public void reset() {
        this.car = new Car();
    }

    @Override
    public void setSeats(int seats) {
        this.car.seats = seats;
    }

    @Override
    public void setEngine(int hp) {
        this.car.hp = hp;
    }

    @Override
    public void setDoorhandles(String doorhandles) {
        this.car.doorhandles = doorhandles;
    }

    @Override
    public void setColor(String color) {
        this.car.color = color;
    }

    @Override
    public void setAccessories(ArrayList<String> accessories) {
        this.car.accessories = accessories;
    }

    public Car getProduct() {
        Car product = this.car;
        this.reset();
        return product;
    }
}

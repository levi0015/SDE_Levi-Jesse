package com.game.builder;

import java.util.ArrayList;

public class Director {
    public void constructSportsCarBuilder(Builder builder, int seats, int hp, String doorhandles, String color, ArrayList<String> accessories) {
        builder.reset();
        builder.setSeats(seats);
        builder.setEngine(hp);
        builder.setDoorhandles(doorhandles);
        builder.setColor(color);
        builder.setAccessories(accessories);
    }

    public void constructSUVBuilder(Builder builder, int seats, int hp, String doorhandles, String color, ArrayList<String> accessories) {
        builder.reset();
        builder.setSeats(seats);
        builder.setEngine(hp);
        builder.setDoorhandles(doorhandles);
        builder.setColor(color);
        builder.setAccessories(accessories);
    }

    public void constructLimousineBuilder(Builder builder, int seats, int hp, String doorhandles, String color, ArrayList<String> accessories) {
        builder.reset();
        builder.setSeats(seats);
        builder.setEngine(hp);
        builder.setDoorhandles(doorhandles);
        builder.setColor(color);
        builder.setAccessories(accessories);
    }
}

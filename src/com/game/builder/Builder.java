package com.game.builder;

import java.util.ArrayList;

public interface Builder {
    void reset();
    void setSeats(int seats);
    void setEngine(int hp);
    void setDoorhandles(String doorhandles);
    void setColor(String color);
    void setAccessories(ArrayList<String> accessories);
}

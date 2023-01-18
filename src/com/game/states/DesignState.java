package com.game.states;

import com.game.CarState;
import com.game.CarFacade;
import com.game.console.ConsoleReader;
import com.game.console.ConsoleWriter;
import java.util.ArrayList;

public class DesignState implements CarState {
    private ArrayList<String> design = new ArrayList<>();
    CarFacade carFacade;
    ConsoleWriter writer;
    ConsoleReader reader;

    public DesignState (CarFacade carFacade, ConsoleReader reader, ConsoleWriter writer) {
        this.carFacade = carFacade;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void makeChoice() {
        this.writer.write("Starting the designState");
        System.exit(1);
        this.designDone();
    }

    private void designDone() {
        this.carFacade.showcaseState(this.design);
    }
}

package com.game.states;

import com.game.CarState;
import com.game.CarFacade;
import com.game.console.ConsoleReader;
import com.game.console.ConsoleWriter;

import java.util.ArrayList;

public class ShowcaseState implements CarState {
    ArrayList<String> blueprint;
    ArrayList<String> design;

    CarFacade carFacade;
    ConsoleWriter writer;
    ConsoleReader reader;

    public ShowcaseState (CarFacade carFacade, ConsoleReader reader, ConsoleWriter writer, ArrayList<String> blueprint, ArrayList<String> design) {
        this.carFacade = carFacade;
        this.reader = reader;
        this.writer = writer;
        this.blueprint = blueprint;
        this.design = design;
    }

    @Override
    public void makeChoice() {

    }
}

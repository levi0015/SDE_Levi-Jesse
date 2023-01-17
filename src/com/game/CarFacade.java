package com.game;

import com.game.console.ConsoleReader;
import com.game.console.ConsoleWriter;
import com.game.states.BlueprintState;
import com.game.states.DesignState;
import com.game.states.ShowcaseState;

import java.util.ArrayList;

public class CarFacade {

    CarState state;

    ConsoleWriter writer = new ConsoleWriter();
    ConsoleReader reader = new ConsoleReader();

    ArrayList<String> blueprint;
    ArrayList<String> design;

    public void blueprintState() {
        this.state = new BlueprintState(this, this.reader, this.writer);
        this.state.makeChoice();
    }

    public void designState(ArrayList<String> blueprint) {
        this.blueprint = blueprint;
        this.state = new DesignState(this, this.reader, this.writer);
        this.state.makeChoice();
    }

    public void showcaseState(ArrayList<String> design) {
        this.design = design;
        this.state = new ShowcaseState(this, this.reader, this.writer, this.blueprint, this.design);
        this.state.makeChoice();
    }
}

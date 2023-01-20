package com.game;

import com.game.console.ASCIIArtGenerator;
import com.game.console.ConsoleReader;
import com.game.console.ConsoleWriter;
import com.game.states.BlueprintState;
import com.game.states.DesignState;
import com.game.states.ShowcaseState;
import java.util.ArrayList;

public class CarFacade {
    private ASCIIArtGenerator creator = new ASCIIArtGenerator();
    private CarState state;

    private ConsoleWriter writer = new ConsoleWriter();
    private ConsoleReader reader = new ConsoleReader();

    private ArrayList<String> blueprint;
    private ArrayList<String> design;

    protected void blueprintState() {
        this.creator.printTextArt("W E L C O M E", ASCIIArtGenerator.ART_SIZE_MEDIUM);
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
        this.state = new ShowcaseState(this.blueprint, this.design, this.reader, this.writer, this);
        this.state.makeChoice();
    }
}

package com.game.states;

import com.game.CarState;
import com.game.CarFacade;
import com.game.console.ConsoleReader;
import com.game.console.ConsoleWriter;
import com.game.manual.LimousineManual;
import com.game.manual.ManualTemplate;
import com.game.manual.SUVManual;
import com.game.manual.SportscarManual;

import java.util.ArrayList;

public class ShowcaseState implements CarState {
    private ArrayList<String> blueprint;
    private ArrayList<String> design;

    private final ConsoleReader reader;
    private final ConsoleWriter writer;

    private final CarFacade carFacade;
    private final ManualTemplate manual;

    public ShowcaseState (ArrayList<String> blueprint, ArrayList<String> design, ConsoleReader reader, ConsoleWriter writer, CarFacade carFacade) {
        this.blueprint = blueprint;
        this.design = design;
        this.reader = reader;
        this.writer = writer;
        this.carFacade = carFacade;
        this.manual = this.createManual(this.blueprint.get(0));
    }

    @Override
    public void makeChoice() {
//        this.writer.write("Start showcase.");
        this.writer.write(this.manual.intro());
        this.writer.write(this.manual.carSpecs());
        this.writer.write(this.manual.carDesignSpecs());

        System.exit(1);
    }

    private ManualTemplate createManual(String car) {
        return switch (car) {
            case "sportscar" -> new SportscarManual(this.blueprint, this.design);
            case "suv" -> new SUVManual(this.blueprint, this.design);
            case "limousine" -> new LimousineManual(this.blueprint, this.design);
            default -> null;
        };
    }
}

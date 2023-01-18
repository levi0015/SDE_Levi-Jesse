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
    ArrayList<String> blueprint;
    ArrayList<String> design;

    CarFacade carFacade;
    ConsoleWriter writer;
    ConsoleReader reader;
    ManualTemplate manual;

    public ShowcaseState (CarFacade carFacade, ConsoleReader reader, ConsoleWriter writer, ArrayList<String> blueprint, ArrayList<String> design) {
        this.carFacade = carFacade;
        this.reader = reader;
        this.writer = writer;
        this.blueprint = blueprint;
        this.design = design;
        this.manual = createManual(this.blueprint.get(0));
    }

    @Override
    public void makeChoice() {
//        this.writer.write("Start showcase.");
        this.writer.write(this.manual.introduction());
        this.writer.write(this.manual.carSpecifications());

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

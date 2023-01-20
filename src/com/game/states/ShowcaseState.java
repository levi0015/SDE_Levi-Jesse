package com.game.states;

import com.game.CarState;
import com.game.CarFacade;
import com.game.builder.Car;
import com.game.builder.CarBuilder;
import com.game.builder.Director;
import com.game.console.ConsoleReader;
import com.game.console.ConsoleWriter;
import com.game.manual.LimousineManual;
import com.game.manual.ManualTemplate;
import com.game.manual.SUVManual;
import com.game.manual.SportscarManual;
import com.game.prototypes.CarPrototype;
import com.game.prototypes.SportscarPrototype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

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
        this.writer.write(this.manual.intro());
        this.writer.write(this.manual.carSpecs());
        this.writer.write(this.manual.carDesignSpecs() + "\n\n");
        this.writer.write("Would you like to build your car?");
//        Car car;
//        CarPrototype sportscarPrototype;
        label:
        while (true) {
            String builder = this.reader.readLine().toLowerCase().replaceAll("\\s","");
            switch (builder) {
                case "yes" :
                    this.makeCar();
                    break label;
                case "no":
                    this.writer.write("Error, pls say yes.");
                    break;
                default:
                    this.writer.write("That is not specifically what I asked, only yes or no answers will do.");
                    break;
            }
        }

//        switch (this.blueprint.get(0)){
//            case "sportscar" :
//                sportscarPrototype = new SportscarPrototype(sportscarPrototype);
//                sportscarPrototype.seats = car.seats;
//                sportscarPrototype.hp = car.hp;
//                sportscarPrototype.doorhandles = car.doorhandles;
//        }
//        this.writer.write("How many of these cars do you like? 1 or 2?");
//        label:
//        while (true) {
//            int carAmount = Integer.parseInt(this.reader.readLine().toLowerCase().replaceAll("\\s",""));
//            switch (carAmount) {
//                case 1 :
//                    break label;
//                case 2:
//                    CarPrototype newSportsCar = sportscarPrototype.clone();
//                    break;
//                default:
//                    this.writer.write("That is not specifically what I asked, only yes or no answers will do.");
//                    break;
//            }
//        }

        System.exit(1);
    }

    private Car makeCar() {
        Director director = new Director();
        CarBuilder builder = new CarBuilder();
        String carType = this.blueprint.get(0);
        int seats = Integer.parseInt(this.blueprint.get(1));
        int hp = Integer.parseInt(this.blueprint.get(2));
        String doorhandles = this.blueprint.get(3).equals("true") ? "automatic" : "manual";
        String color = this.design.get(0);
        ArrayList<String> accessories = this.design;
        switch (carType) {
            case "sportscar" -> director.constructSportsCarBuilder(builder, seats, hp, doorhandles, color, accessories);
            case "suv" -> director.constructSUVBuilder(builder, seats, hp, doorhandles, color, accessories);
            case "limousine" -> director.constructLimousineBuilder(builder, seats, hp, doorhandles, color, accessories);
        };
        Car car = builder.getProduct();
        StringBuilder buildMessage = new StringBuilder("Your " + car.color + " colored " + carType + " with " + car.seats + " seats, " + car.hp + "hp and " +
                car.doorhandles + " doorhandles, has now been build with the following extra's:\n");
        if (car.accessories.size() == 1) {
            buildMessage.append("None");
        } else {
            for (String s : car.accessories) {
                if (!Objects.equals(s, car.accessories.get(0))) {
                    buildMessage.append(s).append(", ");
                }
            }
            buildMessage.delete(buildMessage.length() - 2, buildMessage.length());
        }
        buildMessage.append(".");
        this.writer.write(buildMessage.toString());
        return car;
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

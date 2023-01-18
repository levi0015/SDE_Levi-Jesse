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
        this.writer.write("We will ask a few questions about the design of the car.");
        this.writer.write("Which colour would you prefer your car to have? We have:");
        this.writer.write("Red, Black, White, Blue, Green and Pink.");
        label:
        while (true) {
            String colour = this.reader.readLine().toLowerCase().replaceAll("\\s","");
            switch (colour) {
                case "red", "black", "white", "blue", "green", "pink":
                    this.writer.write("Great choice, we will make your car " + colour + ".");
                    this.design.add(colour);
                    break label;
                case "rainbow":
                    this.writer.write("Great, you have unlocked our easter-egg coloured car.");
                    break label;
                default:
                    this.writer.write("That is not specifically what I asked, only yes or no answers will do.");
                    break;
            }
        }

        this.chooseAccessories();
    }

    private void chooseAccessories() {
        this.writer.write("Let's continue with accessories. Care for a spoiler?");
        label:
        while (true) {
            String spoiler = this.reader.readLine().toLowerCase().replaceAll("\\s","");
            switch (spoiler) {
                case "yes":
                    this.writer.write("spoiler added.");
                    this.design.add("spoiler");
                    break label;
                case "no":
                    this.writer.write("Alright we won't add those.");
                    break label;
                default:
                    this.writer.write("That is not specifically what I asked, only yes or no answers will do.");
                    break;
            }
        }
        this.writer.write("Do you want tinted windows?");
        label:
        while (true) {
            String windows = this.reader.readLine().toLowerCase().replaceAll("\\s","");
            switch (windows) {
                case "yes":
                    this.writer.write("Tinted windows added.");
                    this.design.add("tinted windows");
                    break label;
                case "no":
                    this.writer.write("Alright we won't add those.");
                    break label;
                default:
                    this.writer.write("That is not specifically what I asked, only yes or no answers will do.");
                    break;
            }
        }
        this.writer.write("Do you like roof box?");
        label:
        while (true) {
            String roof = this.reader.readLine().toLowerCase().replaceAll("\\s","");
            switch (roof) {
                case "yes":
                    this.writer.write("roof box added.");
                    this.design.add("roof box");
                    break label;
                case "no":
                    this.writer.write("Alright we won't add those.");
                    break label;
                default:
                    this.writer.write("That is not specifically what I asked, only yes or no answers will do.");
                    break;
            }
        }

        this.designDone();
    }

    private void designDone() {
        this.writer.write("You have selected the following option(s):");
        for (String s : this.design) {
            this.writer.write(s);
        }
        this.writer.write("Are you happy with this/these option(s)?");
        label:
        while (true) {
            String acceptation = this.reader.readLine().toLowerCase().replaceAll("\\s","");
            switch (acceptation) {
                case "yes":
                    this.writer.write("Great, now we can go on with the showcase of the car.\n");
                    this.carFacade.showcaseState(this.design);
                    break label;
                case "no":
                    this.writer.write("ooh no, now lets restart our procedure.");
                    this.design.clear();
                    this.makeChoice();
                    break label;
                default:
                    this.writer.write("That is not specifically what I asked, only yes or no answers will do.");
                    break;
            }
        }
    }
}

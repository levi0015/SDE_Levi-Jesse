package com.game.states;

import com.game.CarState;
import com.game.CarFacade;
import com.game.console.ConsoleReader;
import com.game.console.ConsoleWriter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BlueprintState implements CarState {
    private ArrayList<String> blueprint = new ArrayList<>();
    CarFacade carFacade;
    ConsoleWriter writer;
    ConsoleReader reader;

    public BlueprintState (CarFacade carFacade, ConsoleReader reader, ConsoleWriter writer) {
        this.carFacade = carFacade;
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void makeChoice() {
        this.writer.write("Thank you for choosing our CAR Dealership.");
        this.writer.write("We have three types of cars available, which one do you prefer:");
        while (true) {
            this.writer.write("A sports car, a SUV or a Limousine?");
            String answerOne = this.reader.readLine().toLowerCase().replaceAll("\\s","");

            if (answerOne.equals("sportscar")) {
                this.writer.write("Great, a nice sports car.");
                this.blueprint.add("sportscar");
                this.bpSportsCar();
            } else if (answerOne.equals("suv")) {
                this.writer.write("Great choice, a big family car.");
                this.blueprint.add("suv");
                this.bpSUV();
            } else if (answerOne.equals("limousine")) {
                this.writer.write("Oehhhh, this one has a looooooottt of space... if you'd like it big!");
                this.blueprint.add("limousine");
                this.bpLimousine();
            } else {
                this.writer.write("Euhm... That type of car isn't available at the moment, try one which is!");
            }
        }
    }

    private void bpSportsCar() {
        this.writer.write("How many seats would you like?");
        this.writer.write("This must be at least 2, but a max of 4.");
        while (true) {
            int seats = Integer.parseInt(this.reader.readLine());
            if (seats >= 2 && seats <= 4) {
                this.writer.write("Okay great, " + seats + " seats it is.");
                this.blueprint.add(Integer.toString(seats));
                break;
            } else {
                this.writer.write("That amount of seats is unavailable.");
                this.writer.write("Like I said: This must be at least 2, but a max of 4.");
            }
        }

        // next question;
    }

    private void bpSUV() {
    }

    private void bpLimousine() {
    }

    public void blueprintDone()
    {
        this.carFacade.designState(this.blueprint);
    }
}

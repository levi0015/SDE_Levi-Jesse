package com.game.states;

import com.game.CarState;
import com.game.CarFacade;
import com.game.console.ConsoleReader;
import com.game.console.ConsoleWriter;
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
            String car = this.reader.readLine().toLowerCase().replaceAll("\\s","");

            if (car.equals("sportscar")) {
                this.writer.write("Great, a nice sports car.");
                this.blueprint.add("sportscar");
                this.bpSportsCar();
            } else if (car.equals("suv")) {
                this.writer.write("Great choice, a big family car.");
                this.blueprint.add("suv");
                this.bpSUV();
            } else if (car.equals("limousine")) {
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
            int seats = Integer.parseInt(this.reader.readLine().replaceAll("\\s",""));
            if (seats >= 2 && seats <= 4) {
                this.writer.write("Okay great, " + seats + " seats it is.");
                this.blueprint.add(Integer.toString(seats));
                break;
            } else {
                this.writer.write("That amount of seats is unavailable for this car.");
                this.writer.write("Like I said: This must be at least 2, but a max of 4.");
            }
        }

        this.writer.write("Now the fun part... THE ENGINE. How many horse power would you like?");
        this.writer.write("This must be at least 400 hp of course, but 1000 or more is a bit too much.");
        this.writer.write("Just type in the number");
        while (true) {
            int hp = Integer.parseInt(this.reader.readLine().replaceAll("\\s",""));
            if (hp >= 400 && hp < 1000) {
                this.writer.write("Nice, " + hp + " hp will do nicely.");
                this.blueprint.add(String.valueOf(hp));
                break;
            } else if (hp >= 0 && hp < 400) {
                this.writer.write("Yeah, so that is too little hp");
                this.writer.write("You need a minimum of 400");
            } else if (hp >= 1000 && hp < 2147483647 /** Largest int value*/) {
                this.writer.write("That is too much, like I said 1000 or more is already too much");
            } else {
                this.writer.write("Is this even a number?");
                this.writer.write("Again, just type in a number between 400 and 1000 (but 1000 is too much)");
            }
        }

        this.writer.write("Next up, last question, do you want doorhandles, or do you want automatically opening doors");
        this.writer.write("These doors will open when you walk up to them, it scans you key when in range");
        this.writer.write("If you'd like this, please say Yes, if not, say No");
        while (true) {
            String doorHandles = this.reader.readLine().toLowerCase().replaceAll("\\s","");
            if (doorHandles.equals("yes")) {
                this.writer.write("Good choice, the automatic doors. We will add it to the car.");
                this.blueprint.add("true");
                break;
            } else if (doorHandles.equals("no")) {
                this.writer.write("Ah yes, just the old-school doorhandles. I like that too, no worries.");
                this.blueprint.add("false");
                break;
            } else {
                this.writer.write("That is not specifically what I asked, only yes or no answers will do.");
            }
        }

        this.blueprintDone();
    }

    private void bpSUV() {
        this.writer.write("How many seats would you like?");
        this.writer.write("This must be at least 2, but a max of 6.");
        while (true) {
            int seats = Integer.parseInt(this.reader.readLine().replaceAll("\\s",""));
            if (seats >= 2 && seats <= 6) {
                this.writer.write("Okay great, " + seats + " seats it is.");
                this.blueprint.add(Integer.toString(seats));
                break;
            } else {
                this.writer.write("That amount of seats is unavailable for this car.");
                this.writer.write("Like I said: This must be at least 2, but a max of 6.");
            }
        }

        this.writer.write("Now the engine. A SUV has most likely horse power between 150 and 400");
        this.writer.write("So choose wisely what you want/need. Only type in the number.");
        while (true) {
            int hp = Integer.parseInt(this.reader.readLine().replaceAll("\\s",""));
            if (hp >= 150 && hp <= 400) {
                this.writer.write("Nice, " + hp + " hp will do nicely.");
                this.blueprint.add(String.valueOf(hp));
                break;
            } else if (hp >= 0 && hp < 150) {
                this.writer.write("Yeah, so that is too little hp for these big cars");
                this.writer.write("You need a minimum of 150");
            } else if (hp > 400 && hp < 2147483647 /** Largest int value*/) {
                this.writer.write("That is too much, like I said more than 400 is too much");
            } else {
                this.writer.write("Is this even a number?");
                this.writer.write("Again, just type in a number between 150 and 400");
            }
        }

        this.writer.write("Next up, last question, do you want doorhandles, or do you want automatically opening doors");
        this.writer.write("These doors will open when you walk up to them, it scans you key when in range");
        this.writer.write("If you'd like this, please say Yes, if not, say No");
        while (true) {
            String doorHandles = this.reader.readLine().toLowerCase().replaceAll("\\s","");
            if (doorHandles.equals("yes")) {
                this.writer.write("Good choice, the automatic doors. We will add it to the car.");
                this.blueprint.add("true");
                break;
            } else if (doorHandles.equals("no")) {
                this.writer.write("Ah yes, just the old-school doorhandles. I like that too, no worries.");
                this.blueprint.add("false");
                break;
            } else {
                this.writer.write("That is not specifically what I asked, only yes or no answers will do.");
            }
        }

        this.blueprintDone();
    }

    private void bpLimousine() {
        this.writer.write("So... a lot of space you have, but how many seats do you want?");
        this.writer.write("This must be at least 8, but a max of 20.");
        while (true) {
            int seats = Integer.parseInt(this.reader.readLine().replaceAll("\\s",""));
            if (seats >= 8 && seats <= 20) {
                this.writer.write("Okay cool, " + seats + " seats it is.");
                this.blueprint.add(Integer.toString(seats));
                break;
            } else {
                this.writer.write("That amount of seats is unavailable for this car.");
                this.writer.write("Like I said: This must be at least 8, but a max of 20.");
            }
        }

        this.writer.write("Now the engine. Limousine isn't about power, so you just have a choice between 2 engines.");
        this.writer.write("The one with 100 hp or the with 200 hp, which one do you want?");
        this.writer.write("Just type in the number of the hp");
        while (true) {
            int hp = Integer.parseInt(this.reader.readLine().replaceAll("\\s",""));
            if (hp == 100 || hp == 200) {
                this.writer.write("Nice, " + hp + " hp will do the job.");
                this.blueprint.add(String.valueOf(hp));
                break;
            } else if (hp < 100) {
                this.writer.write("Yeah, so that is not one of the options unfortunately");
                this.writer.write("You need to choose between a 100 hp engine or 200 hp engine");
            } else if (hp > 200 && hp < 2147483647 /** Largest int value*/) {
                this.writer.write("That is not possible, the engines only have 100 or 200 hp");
            } else if (hp < 200){
                this.writer.write("Okay fine, if you'd really like " + hp + " hp, we will make you that engine.");
                this.blueprint.add(String.valueOf(hp));
                break;
            } else {
                this.writer.write("Is this even a number?");
                this.writer.write("Again, just type in a number between 150 and 400");
            }
        }

        this.writer.write("Next up, last question, do you want doorhandles, or do you want automatically opening doors");
        this.writer.write("These doors will open when your chauffeur sees you coming. It will open the doors for all your passengers");
        this.writer.write("If you'd like this, please say Yes, if not, say No");
        while (true) {
            String doorHandles = this.reader.readLine().toLowerCase().replaceAll("\\s","");
            if (doorHandles.equals("yes")) {
                this.writer.write("Good choice, the automatic doors. We will add it to the car.");
                this.blueprint.add("true");
                break;
            } else if (doorHandles.equals("no")) {
                this.writer.write("Ah yes, just the old-school doorhandles. I like that too, no worries.");
                this.blueprint.add("false");
                break;
            } else {
                this.writer.write("That is not specifically what I asked, only yes or no answers will do.");
            }
        }

        this.blueprintDone();
    }

    public void blueprintDone()
    {
        this.carFacade.designState(this.blueprint);
    }
}

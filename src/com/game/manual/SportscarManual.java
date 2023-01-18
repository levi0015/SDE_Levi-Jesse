package com.game.manual;

import java.util.ArrayList;

public class SportscarManual extends ManualTemplate {

    public SportscarManual(ArrayList<String> blueprint, ArrayList<String> design) {
        super(blueprint, design);
    }

    @Override
    public String carSpecifications() {
        String doors = this.blueprint.get(3).equals("true") ? "automatic" : "manual";
        return "This " + this.blueprint.get(0) + " has " + this.blueprint.get(1) + " seats. " +
                "These seats won't be heated. They do however have an option to incline.\n" +
                "The engine will have approximately " + this.blueprint.get(2) + "hp. " +
                "The engine is guaranteed to last for about 4 years.\n" +
                "This design will have " + doors + " doors.";
    }
}

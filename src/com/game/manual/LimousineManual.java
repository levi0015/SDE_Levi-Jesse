package com.game.manual;

import java.util.ArrayList;

public class LimousineManual extends ManualTemplate{
    public LimousineManual(ArrayList<String> blueprint, ArrayList<String> design) {
        super(blueprint, design);
    }

    @Override
    public String carSpecifications() {
        String doors = this.blueprint.get(3).equals("true") ? "automatic" : "manual";
        return "This " + this.blueprint.get(0) + " has " + this.blueprint.get(1) + " seats. The seats in the back are placed together as a couch.\n" +
                "These seats won't be heated. They also don't have an option to incline.\n" +
                "The engine will have approximately " + this.blueprint.get(2) + "hp. Which means this car is not suited for rough terrain. " +
                "The engine is guaranteed to last for about 9 years.\n" +
                "This design will have " + doors + " doors. The doors will be located at the back of the " + this.blueprint.get(0) + ".";
    }
}

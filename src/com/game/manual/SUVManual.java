package com.game.manual;

import java.util.ArrayList;

public class SUVManual extends ManualTemplate{
    public SUVManual(ArrayList<String> blueprint, ArrayList<String> design) {
        super(blueprint, design);
    }

    @Override
    public String carSpecifications() {
        String doors = this.blueprint.get(3).equals("true") ? "automatic" : "manual";
        return "This " + this.blueprint.get(0) + " has " + this.blueprint.get(1) + " seats. " +
                "These seats will be heated. They also have an option to incline. There is an extra seat located in the trunk.\n" +
                "The engine will have approximately " + this.blueprint.get(2) + "hp. " +
                "The engine is guaranteed to last for about 5 years. This car is suitable for every type of terrain.\n" +
                "This design will have " + doors + " doors. The trunk will have a volume of approximately 500L or at least 5 dead bodies.";
    }
}

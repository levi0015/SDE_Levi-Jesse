package com.game.manual;

import java.util.ArrayList;

public class SUVManual extends ManualTemplate{
    public SUVManual(ArrayList<String> blueprint, ArrayList<String> design) {
        super(blueprint, design);
    }

    @Override
    public String carSpecs() {
        String doors = this.blueprint.get(3).equals("true") ? "automatic" : "manual";
        return "This SUV has " + this.blueprint.get(1) + " seats. " +
                "These seats will be heated. They also have an option to incline. There is an extra seat located in the trunk.\n" +
                "The engine will have approximately " + this.blueprint.get(2) + "hp. " +
                "The engine is guaranteed to last for about 5 years. This car is suitable for every type of terrain.\n" +
                "This design will have " + doors + " doors. The trunk will have a volume of approximately 550L or at least 5 dead bodies.\n";
    }

    @Override
    public String carDesignSpecs() {
        StringBuilder designSpecs = new StringBuilder();
        designSpecs.append("For the design of your SUV are the following things important to know:\n")
                .append("The color of your car will be ").append(this.design.get(0))
                .append(" and this will have be a matte color. This will look clean and cool on your car.\n")
                .append("As for the extra's, you need the following information:\n");
        boolean hasAccessories = false;
        Integer countAccessories = 1;
        for (String d : this.design) {
            switch (d) {
                case "spoiler" -> {
                    designSpecs.append(countAccessories).append(". You have chosen a spoiler, This will be a 'Small Roof Spoiler'.\n")
                            .append("This spoiler will add a bit of downforce to your car, which will become helpful on some tough terrain.\n");
                    hasAccessories = true;
                    countAccessories++;
                }
                case "tinted windows" -> {
                    designSpecs.append(countAccessories).append(". You have chosen the tinted windows. These windows will have the max legal limit of tinting.\n")
                            .append("This will mean that the back windows (side and rear) will allow 0% of light through there.")
                            .append("The front windows (side and windscreen) will allow 75% light through there.\n")
                            .append("With these windows you can drive around like a bad-ass SUV driver.\n");
                    hasAccessories = true;
                    countAccessories++;
                }
                case "roof box" -> {
                    designSpecs.append(countAccessories).append(". You have chosen the roof box. This is perfect for long vacations for example.\n")
                            .append("The roof box will have a volume of 450L, which is almost the same as your trunk. Combined this will be approximately 1000L\n")
                            .append("TIP: IF you put the dead bodies in here, your car won't smell that bad for a week.\n");
                    hasAccessories = true;
                    countAccessories++;
                }
            }
        }
        if (!hasAccessories) {
            designSpecs.append("Hmmm... You didn't choose any extra's? Ah well, you can add it later if you change your mind.\n");
        }
        return designSpecs.toString();
    }
}

package com.game.manual;

import java.util.ArrayList;

public class SportscarManual extends ManualTemplate {

    public SportscarManual(ArrayList<String> blueprint, ArrayList<String> design) {
        super(blueprint, design);
    }

    @Override
    public String carSpecs() {
        String doors = this.blueprint.get(3).equals("true") ? "automatic" : "manual";
        return "This Sports car has " + this.blueprint.get(1) + " seats. " +
                "These seats won't be heated. They do however have an option to incline.\n" +
                "The engine will have approximately " + this.blueprint.get(2) + "hp. " +
                "The engine is guaranteed to last for about 4 years.\n" +
                "This design will have " + doors + " doors.\n";
    }

    @Override
    public String carDesignSpecs() {
        StringBuilder designSpecs = new StringBuilder();
        designSpecs.append("For the design of your Sports car are the following things important to know:\n")
                .append("The color of your car will be ").append(this.design.get(0))
                .append(" and this will have a thin safety coat on top, so little scratches won't take of the paint.\n")
                .append("As for the extra's, you need the following information:\n");

        if (this.design.size() == 1) {
            designSpecs.append("Euhm... No extra's I see. That's okay, a Sports car already looks really cool.\n");
        } else {
            int countAccessories = 1;
            for (String d : this.design) {
                switch (d) {
                    case "spoiler" -> {
                        designSpecs.append(countAccessories).append(". You have chosen a spoiler, This will be a 'Medium GT Spoiler'.\n")
                                .append("This spoiler has the feature of 'speed braking', this means the spoiler will turn itself up\n")
                                .append("when you brake, which will help you brake faster. This will only happen with a speed above 150 km/h\n");
                        countAccessories++;
                    }
                    case "tinted windows" -> {
                        designSpecs.append(countAccessories).append(". You have chosen the tinted windows. These windows will have the max legal limit of tinting.\n")
                                .append("This will mean that the back windows (side and rear) will allow 0% of light through there.")
                                .append("The front windows (side and windscreen) will allow 75% light through there.\n")
                                .append("With these windows your car will be a lot cooler than it already is.\n");
                        countAccessories++;
                    }
                    case "roof box" -> {
                        designSpecs.append(countAccessories).append(". You have chosen the roof box. That's a bit weird for a sports car, but it's up to you.\n")
                                .append("The roof box will have a volume of 350L so you can put all your luck-age in there.\n")
                                .append("WARNING: Your tipping point will be higher with more weight in it. Watch out with fast corner speed!\n");
                        countAccessories++;
                    }
                }
            }
        }

        return designSpecs.toString();
    }
}

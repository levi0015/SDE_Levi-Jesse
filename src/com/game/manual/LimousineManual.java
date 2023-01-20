package com.game.manual;

import java.util.ArrayList;

public class LimousineManual extends ManualTemplate {

    public LimousineManual(ArrayList<String> blueprint, ArrayList<String> design) {
        super(blueprint, design);
    }

    @Override
    public String carSpecs() {
        String doors = this.blueprint.get(3).equals("true") ? "automatic" : "manual";
        return "This limousine has " + this.blueprint.get(1) + " seats. The seats in the back are placed together as a couch.\n" +
                "These seats won't be heated. They also don't have an option to incline.\n" +
                "The engine will have approximately " + this.blueprint.get(2) + "hp. Which means this car is not suited for rough terrain. " +
                "The engine is guaranteed to last for about 9 years.\n" +
                "This design will have " + doors + " doors. The doors will be located at the back of the limousine.\n";
    }

    @Override
    public String carDesignSpecs() {
        StringBuilder designSpecs = new StringBuilder();
        designSpecs.append("For the design of your limousine are the following things important to know:\n")
                .append("The color of your limousine will be ").append(this.design.get(0))
                .append(" and this will have be a metallic color. This will look pretty and it will sure get the attention of everyone.\n")
                .append("As for the extra's, you need the following information:\n");

        boolean hasAccessories = false;
        int countAccessories = 1;
        for (String d : this.design) {
            switch (d) {
                case "spoiler" -> {
                    designSpecs.append(countAccessories).append(". You have chosen a spoiler, This will be a 'Small Roof Spoiler'.\n")
                            .append("This spoiler won't be helpful for anything, but for sure will look nice on your long limousine.\n");
                    hasAccessories = true;
                    countAccessories++;
                }
                case "tinted windows" -> {
                    designSpecs.append(countAccessories).append(". You have chosen the tinted windows. This will be all fully tinted.\n")
                            .append("This will mean that the back windows (side and rear) will allow 0% of light through there.")
                            .append("The front windows however will allow 75% light through there, so your chauffeur can see a bit better.\n")
                            .append("With these windows no-one can see you inside your limousine and you have the ultimate privacy!\n");
                    hasAccessories = true;
                    countAccessories++;
                }
                case "roof box" -> {
                    designSpecs.append(countAccessories).append(". You have chosen the roof box. This is perfect for a long vehicle.\n")
                            .append("The roof box will have a insane volume of 2.000L, which is incredibly high for roof boxes.\n")
                            .append("TIP: You can take all your friends and family on a vacation with this space.\n");
                    hasAccessories = true;
                }
            }
        }

        if (!hasAccessories) {
            designSpecs.append("Oh... I see you didn't choose any extra's. No worries, your limousine will still be nice.\n");
        }

        return designSpecs.toString();
    }
}

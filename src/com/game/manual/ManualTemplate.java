package com.game.manual;

import java.util.ArrayList;

abstract public class ManualTemplate {
    ArrayList<String> blueprint;
    ArrayList<String> design;

    public ManualTemplate(ArrayList<String> blueprint, ArrayList<String> design){
        this.blueprint = blueprint;
        this.design = design;
    }

    public String introduction() {
        return "Thank you for choosing one of our " + this.blueprint.get(0) + "'s. We are happy to have you be a customer of our services.\n" +
                "We would like you to know that our " + this.blueprint.get(0) + " collection is spreading globally and we are expending our services across the world.\n" +
                "Now let's give a bit of information about your " + this.blueprint.get(0) + ":\n";
    };

    abstract public String carSpecifications();
}

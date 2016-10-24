package com.step.automata;

import com.google.gson.JsonElement;

public class Presenter {
    private final JsonElement pass_cases;
    private final JsonElement fail_cases;

    public Presenter(JsonElement pass_cases, JsonElement fail_cases) {

        this.pass_cases = pass_cases;
        this.fail_cases = fail_cases;
    }

    public void present(DFAMachine machine, String name) {
        System.out.println(name + ":-\n");
        System.out.println("============= pass_cases================\n");
        for (int i = 0; i < pass_cases.getAsJsonArray().size(); i++) {
            if (machine.isRecognizes(pass_cases.getAsJsonArray().get(i).getAsString()))
                System.out.println(pass_cases.getAsJsonArray().get(i).getAsString());
        }

        System.out.println("============= fail_cases================\n");
        for (int i = 0; i < fail_cases.getAsJsonArray().size(); i++) {
            if (!machine.isRecognizes(fail_cases.getAsJsonArray().get(i).getAsString()))
                System.out.println(fail_cases.getAsJsonArray().get(i).getAsString());
        }
    }
}

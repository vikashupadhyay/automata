package com.step.automata;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class MachineBuilder {
    private final String name;
    private final String type;
    private final JsonElement tuple;
    private final JsonElement pass_cases;
    private final JsonElement fail_cases;

    public MachineBuilder(String name, String type, JsonElement tuple, JsonElement pass_cases, JsonElement fail_cases) {
        this.name = name;
        this.type = type;
        this.tuple = tuple;
        this.pass_cases = pass_cases;
        this.fail_cases = fail_cases;
    }

    public void createDfa() {
        Tuple tuple = parseTuple();
        TransitionFunction transitionFunction = tuple.getTransitionFunction();
        DFAMachine machine = tuple.createMachine(transitionFunction);
        Presenter presenter = new Presenter(pass_cases, fail_cases);
        presenter.present(machine, name);


    }

    public Tuple parseTuple() {
        String startingState = tuple.getAsJsonObject().get("start-state").getAsString();
        JsonArray finalStates = tuple.getAsJsonObject().get("final-states").getAsJsonArray();
        JsonArray allStates = tuple.getAsJsonObject().get("states").getAsJsonArray();
        JsonObject delta = tuple.getAsJsonObject().get("delta").getAsJsonObject();
        JsonArray alphabets = tuple.getAsJsonObject().get("alphabets").getAsJsonArray();
        return new Tuple(startingState, finalStates, allStates, delta, alphabets);
    }
}

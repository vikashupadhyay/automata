package com.step.automata.utils;

import java.util.HashSet;
import java.util.Objects;

public class JsonParser {
    private final String name;
    private final String type;
    private final TupleParser tuple;
    private final HashSet<String> pass_cases;
    private final HashSet<String> fail_cases;


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "JsonParser{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", tuple=" + tuple +
                ", pass_cases=" + pass_cases +
                ", fail_cases=" + fail_cases +
                '}';
    }

    public JsonParser(String name, String type, TupleParser tuple, HashSet<String> pass_cases, HashSet<String> fail_cases) {
        this.name = name;
        this.type = type;
        this.tuple = tuple;
        this.pass_cases = pass_cases;
        this.fail_cases = fail_cases;
    }

    public States parseAllStates() {
        return tuple.parseStates();
    }

    public TransitionTable parseTransitionTable() {
        if (Objects.equals(type, "dfa"))
            return tuple.parseDFATransitionTable();
        else
            return tuple.parseNFATransitionTable();
    }


    public State parseStartStates() {
        return tuple.parseStartState();
    }

    public States parseFinalStates() {
        return tuple.parseFinalStates();
    }

    public HashSet<String> getPassCases() {
        return pass_cases;
    }

    public HashSet<String> getFailCases() {
        return fail_cases;
    }


    public HashSet<Character> parseAlphabets() {
        return tuple.parseAlphabets();
    }
}

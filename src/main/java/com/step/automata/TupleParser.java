package com.step.automata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class TupleParser {
    private final ArrayList<String> alphabets;
    private final String start_state;
    private final ArrayList<String> final_states;
    private final ArrayList<String> states;
    private HashMap<String, HashMap<String, String>> delta;

    public TupleParser(ArrayList<String> states, ArrayList<String> alphabets, HashMap<String, HashMap<String, String>> delta, String start_state, ArrayList<String> final_states) {
        this.states = states;
        this.alphabets = alphabets;
        this.delta = delta;
        this.start_state = start_state;
        this.final_states = final_states;
    }

    public HashSet<State> parseStates() {
        HashSet<State> newStates = new HashSet<>();
        for (String state : states) {
            newStates.add(new State(state));
        }
        return newStates;
    }

    public HashSet<State> parseFinalStates() {
        HashSet<State> newStates = new HashSet<>();
        for (String state : final_states) {
            newStates.add(new State(state));
        }
        return newStates;
    }

    public TransitionFunction parseTransitionTable() {
        TransitionFunction transitionFunction = new TransitionFunction();
        delta.forEach((x, y) -> {
            y.forEach((a, b) -> {
                transitionFunction.setTransition(new State(x), new State(b), a.charAt(0));
            });
        });
        return transitionFunction;
    }

    public State parseStartState(){
        return new State(start_state);
    }

    public HashSet<Character> parseAlphabets() {
        HashSet<Character> allAlphabets = new HashSet<>();
        Iterator<String> iterator = alphabets.iterator();
        while (iterator.hasNext()){
            allAlphabets.add(iterator.next().charAt(0));
        }
        return allAlphabets;

    }
}

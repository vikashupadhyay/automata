package com.step.automata.utils;

import com.step.automata.dfa.DFATransitionFunction;

import java.util.*;

public class TupleParser{
    private final Set<String> alphabets;
    private final String start_state;
    private final Set<String> final_states;
    private final Set<String> states;

    private HashMap<String, HashMap<String, String>> delta;

    public TupleParser(Set<String> states, Set<String> alphabets, HashMap<String, HashMap<String, String>> delta, String start_state, Set<String> final_states) {
        this.states = states;
        this.alphabets = alphabets;
        this.delta = delta;
        this.start_state = start_state;
        this.final_states = final_states;
    }

    public States parseStates() {
        States newStates = new States();
        for (String state : states) {
            newStates.add(new State(state));
        }
        return newStates;
    }

    public States parseFinalStates() {
        States newStates = new States();
        for (String state : final_states) {
            newStates.add(new State(state));
        }
        return newStates;
    }

    public DFATransitionFunction parseTransitionTable() {
        DFATransitionFunction transitionFunction = new DFATransitionFunction();
        delta.forEach((x, y) -> {
            y.forEach((a, b) -> {
                transitionFunction.addTransition(new State(x), new State(b), a.charAt(0));
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

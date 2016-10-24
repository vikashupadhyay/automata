package com.step.automata;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.HashSet;
import java.util.Objects;

public class Tuple {

    private final String startingState;
    private final JsonArray finalStates;
    private final JsonArray allStates;
    private final JsonObject delta;
    private final JsonArray alphabets;


    private final HashSet<State> states = new HashSet<>();
    private final HashSet<State> finalState = new HashSet<>();
    private final HashSet<Character> alphabet = new HashSet<>();
    private State initialState;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tuple tuple = (Tuple) o;

        if (startingState != null ? !startingState.equals(tuple.startingState) : tuple.startingState != null)
            return false;
        if (finalStates != null ? !finalStates.equals(tuple.finalStates) : tuple.finalStates != null) return false;
        if (allStates != null ? !allStates.equals(tuple.allStates) : tuple.allStates != null) return false;
        if (delta != null ? !delta.equals(tuple.delta) : tuple.delta != null) return false;
        if (alphabets != null ? !alphabets.equals(tuple.alphabets) : tuple.alphabets != null) return false;
        if (states != null ? !states.equals(tuple.states) : tuple.states != null) return false;
        if (finalState != null ? !finalState.equals(tuple.finalState) : tuple.finalState != null) return false;
        if (alphabet != null ? !alphabet.equals(tuple.alphabet) : tuple.alphabet != null) return false;
        return initialState != null ? initialState.equals(tuple.initialState) : tuple.initialState == null;

    }


    @Override
    public int hashCode() {
        int result = startingState != null ? startingState.hashCode() : 0;
        result = 31 * result + (finalStates != null ? finalStates.hashCode() : 0);
        result = 31 * result + (allStates != null ? allStates.hashCode() : 0);
        result = 31 * result + (delta != null ? delta.hashCode() : 0);
        result = 31 * result + (alphabets != null ? alphabets.hashCode() : 0);
        result = 31 * result + (states != null ? states.hashCode() : 0);
        result = 31 * result + (finalState != null ? finalState.hashCode() : 0);
        result = 31 * result + (alphabet != null ? alphabet.hashCode() : 0);
        result = 31 * result + (initialState != null ? initialState.hashCode() : 0);
        return result;
    }

    public Tuple(String startingState, JsonArray finalStates, JsonArray allStates, JsonObject delta, JsonArray alphabets) {
        this.startingState = startingState;
        this.finalStates = finalStates;
        this.allStates = allStates;
        this.delta = delta;
        this.alphabets = alphabets;
    }

    public TransitionFunction getTransitionFunction() {
        TransitionFunction transitionFunction = new TransitionFunction();
        for (int i = 0; i < allStates.size(); i++) {
            for (int j = alphabets.size() - 1; j >= 0; j--) {
                State currentState = new State(allStates.get(i).getAsString());
                if (Objects.equals(currentState.getState(), startingState)) {
                    initialState = currentState;
                }
                for (int k = 0; k < finalStates.size(); k++) {
                    if (Objects.equals(finalStates.get(k).getAsString(), currentState.getState()))
                        finalState.add(currentState);
                }
                states.add(currentState);
                char asCharacter = alphabets.get(j).getAsCharacter();
                alphabet.add(asCharacter);
                State nextState = new State(delta.get(allStates.get(i).getAsString()).getAsJsonObject().get(alphabets.get(j).getAsString()).getAsString());
                states.add(nextState);
                for (int k = 0; k < finalStates.size(); k++) {
                    if (Objects.equals(finalStates.get(k).getAsString(), nextState.getState()))
                        finalState.add(nextState);
                }
                transitionFunction.setTransition(currentState, nextState, asCharacter);
            }

        }
        return transitionFunction;
    }

    public DFAMachine createMachine(TransitionFunction transitionFunction) {
        return new DFAMachine(transitionFunction, initialState, finalState, states, alphabet);
    }

}

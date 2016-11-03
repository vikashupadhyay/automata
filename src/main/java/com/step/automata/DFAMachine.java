package com.step.automata;

import java.util.HashSet;
import java.util.Set;

public class DFAMachine {
    private final TransitionFunction transitionFunction;
    private final State initialState;
    private final HashSet<State> states;
    private final HashSet<State> finalStates;
    private final HashSet<Character> alphabets;


    public DFAMachine(TransitionFunction transitionFunction, State initialState, HashSet<State> finalStates, HashSet<State> states, HashSet<Character> alphabets) {
        this.transitionFunction = transitionFunction;
        this.initialState = initialState;
        this.states = states;
        this.finalStates = finalStates;
        this.alphabets = alphabets;
    }

    public boolean isRecognizes(String pattern) {
        State currentState = initialState;
        validateState(currentState);
        validateAllStates(transitionFunction.getAllState());
        for (char transition : pattern.toCharArray()) {
            validateTransition(transition);
            currentState = transitionFunction.getNextState(currentState, transition);
        }
        return finalStates.contains(currentState);
    }

    private void validateAllStates(Set<State> allState) {
        if (!states.containsAll(allState))
            throw new RuntimeException("state is invalid: " + allState);
    }

    private void validateTransition(char transition) {
        if (!alphabets.contains(transition))
            throw new RuntimeException("transition is invalid: " + transition);
    }

    private void validateState(State state) {
        if (!states.contains(state))
            throw new RuntimeException("state is invalid: " + state);
    }
}

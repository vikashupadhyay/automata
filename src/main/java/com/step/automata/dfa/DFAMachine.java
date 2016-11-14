package com.step.automata.dfa;

import com.step.automata.utils.State;
import com.step.automata.utils.States;
import com.step.automata.utils.TransitionTable;

import java.util.HashSet;
import java.util.Set;

public class DFAMachine {
    private final DFATransitionFunction transitionFunction;
    private final State initialState;
    private final States states;
    private final States finalStates;
    private final HashSet<Character> alphabets;


    public DFAMachine(TransitionTable transitionFunction, State initialState, States finalStates, States states, HashSet<Character> alphabets) {
        this.transitionFunction = (DFATransitionFunction) transitionFunction;
        this.initialState = initialState;
        this.states = states;
        this.finalStates = finalStates;
        this.alphabets = alphabets;
    }

    public boolean isRecognizes(String alphabets) {
        State currentState = initialState;
        validateState(currentState);
        validateAllStates(transitionFunction.getAllState());
        for (char transition : alphabets.toCharArray()) {
            validateTransition(transition);
            currentState = transitionFunction.nextState(currentState, transition);
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

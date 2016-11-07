package com.step.automata.nfa;

import com.step.automata.utils.States;
import com.step.automata.utils.State;

import java.util.HashSet;

public class NFAMachine {
    private final NFATransitionFunction transitionFunction;
    private final State state;
    private final States finalStates;
    private final States allStates;
    private final HashSet<Character> alphabets;

    public NFAMachine(NFATransitionFunction transitionFunction, State state, States finalStates, States allStates, HashSet<Character> alphabets) {

        this.transitionFunction = transitionFunction;
        this.state = state;
        this.finalStates = finalStates;
        this.allStates = allStates;
        this.alphabets = alphabets;
    }

    public boolean isRecognizes(String alphabets) {
        States currentState = new States();
        currentState.add(state);
        for (char alphabet : alphabets.toCharArray()) {
            currentState = transitionFunction.nextState(currentState, alphabet);

        }

        return finalStates.hasIntersection(currentState);
    }
}

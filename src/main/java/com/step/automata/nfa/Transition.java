package com.step.automata.nfa;

import com.step.automata.utils.States;

import java.util.HashMap;

public class Transition {

    private HashMap<Character, States> transition;
    private Character EPSILON = 'e';

    public Transition() {
        this.transition = new HashMap<>();
    }

    public void putIfAbsent(char alphabet, States states) {
        transition.putIfAbsent(alphabet, states);

    }

    public States get(char alphabet) {
        if(transition.get(alphabet)==null) return new States();
        return transition.get(alphabet);
    }

    public boolean hasEpsilon() {
        return transition.containsKey(EPSILON);
    }

    public int size() {
        return transition.size();
    }

    @Override
    public String toString() {
        return transition.toString();
    }

    public HashMap<Character, States> getTransition() {
        return transition;
    }

    public States getEpsilonStates() {
        if(transition.get(EPSILON)==null) return new States();
        return transition.get(EPSILON);
    }
}

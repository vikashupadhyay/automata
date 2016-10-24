package com.step.automata;

import java.util.HashMap;
import java.util.Set;

public class TransitionFunction {

    private HashMap<State, HashMap<Character, State>> transitionFunc;

    public TransitionFunction() {
        this.transitionFunc = new HashMap<>();
    }

    public void setTransition(State previousState, State nextSate, char transition) {
        transitionFunc.putIfAbsent(previousState, new HashMap<>());
        transitionFunc.get(previousState).put(transition, nextSate);
    }

    public State getNextState(State currentState, char transition) {
        return transitionFunc.get(currentState).get(transition);
    }

    public Set<State> getAllState(){
        return transitionFunc.keySet();
    }
    @Override
    public String toString() {
        return transitionFunc.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransitionFunction that = (TransitionFunction) o;

        return transitionFunc != null ? transitionFunc.equals(that.transitionFunc) : that.transitionFunc == null;

    }

    @Override
    public int hashCode() {
        return transitionFunc != null ? transitionFunc.hashCode() : 0;
    }
}

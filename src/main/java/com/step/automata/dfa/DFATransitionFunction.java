package com.step.automata.dfa;

import com.step.automata.utils.State;
import com.step.automata.utils.TransitionTable;

import java.util.HashMap;
import java.util.Set;

public class DFATransitionFunction implements TransitionTable<State> {

    private HashMap<State, HashMap<Character, State>> transitionTable;

    public DFATransitionFunction() {
        this.transitionTable = new HashMap<>();
    }


    public Set<State> getAllState() {
        return transitionTable.keySet();
    }

    @Override
    public String toString() {
        return transitionTable.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DFATransitionFunction that = (DFATransitionFunction) o;

        return transitionTable != null ? transitionTable.equals(that.transitionTable) : that.transitionTable == null;

    }

    @Override
    public int hashCode() {
        return transitionTable != null ? transitionTable.hashCode() : 0;
    }

    @Override
    public void addTransition(State previousState, State nextState, char alphabet) {
        transitionTable.putIfAbsent(previousState, new HashMap<>());
        transitionTable.get(previousState).put(alphabet, nextState);
    }

    @Override
    public State nextState(State currentState, char alphabet) {
        return transitionTable.get(currentState).get(alphabet);
    }
}

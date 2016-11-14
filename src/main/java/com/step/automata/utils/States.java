package com.step.automata.utils;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class States {
    private HashSet<State> states;

    public States() {
        this.states = new HashSet<>();
    }

    public void add(State state) {
        states.add(state);
    }

    public boolean hasIntersection(States anotherState) {
        Iterator<State> iterator = anotherState.iterator();
        while (iterator.hasNext()) {
            if (states.contains(iterator.next())) return true;
        }
        return false;
    }

    public boolean contains(State anotherState) {
        return states.contains(anotherState);
    }

    public boolean containsAll(Set<State> allState) {
        return states.containsAll(allState);
    }

    public int size() {
        return states.size();
    }

    public Iterator<State> iterator() {
        return states.iterator();
    }

    public boolean isEmpty() {
        return states.isEmpty();
    }


    @Override
    public String toString() {
        return states.toString();
    }

    public HashSet<State> getStates() {
        return states;
    }

    public void addAll(States anotherStates) {
        HashSet<State> setOfStates = anotherStates.getStates();
        states.addAll(setOfStates);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        States states1 = (States) o;

        return states != null ? states.equals(states1.states) : states1.states == null;

    }

    @Override
    public int hashCode() {
        return states != null ? states.hashCode() : 0;
    }
}

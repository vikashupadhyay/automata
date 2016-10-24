package com.step.automata;

public class State {
    private final String state;


    public String getState() {
        return state;
    }

    public State(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        State state1 = (State) o;

        return state != null ? state.equals(state1.state) : state1.state == null;

    }

    @Override
    public int hashCode() {
        return state != null ? state.hashCode() : 0;
    }

    @Override
    public String toString() {
        return state;
    }
}

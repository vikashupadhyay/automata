package com.step.automata.utils;

public interface TransitionTable<T> {
    public void addTransition(State previousState, T nextState, char alphabet);

    public T nextState(T previousState, char alphabet);
}

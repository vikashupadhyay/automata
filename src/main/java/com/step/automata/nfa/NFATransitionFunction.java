package com.step.automata.nfa;

import com.step.automata.utils.State;
import com.step.automata.utils.States;
import com.step.automata.utils.TransitionTable;

import java.util.HashMap;
import java.util.Iterator;

public class NFATransitionFunction implements TransitionTable<States> {

    private HashMap<State, HashMap<Character, States>> transitionTable;
    private Character EPSILON = 'e';

    public NFATransitionFunction() {
        this.transitionTable = new HashMap<>();
    }

    public void addTransition(State previousState, States nextState, char alphabet) {
        transitionTable.putIfAbsent(previousState, new HashMap<>());
        transitionTable.get(previousState).put(alphabet, nextState);

    }


    public States getNextStateOnGivenState(State state, char alphabet) {
        HashMap<Character, States> characterStatesHashMap = transitionTable.get(state);

        if (!characterStatesHashMap.containsKey(EPSILON))
            return characterStatesHashMap.get(alphabet) == null ? new States() : characterStatesHashMap.get(alphabet);

        States currentStates = new States();
        States states = epsilonClosure(state);
        Iterator<State> iterator = states.iterator();
        while (iterator.hasNext()) {
            State next = iterator.next();
            States states1 = transitionTable.get(next).get(alphabet) == null ? new States() : transitionTable.get(next).get(alphabet);
            currentStates.addAll(states1);
        }

        return currentStates;
    }


    private States epsilonClosure(State state) {
        HashMap<Character, States> characterStatesHashMap = transitionTable.get(state);

        States states = new States();
        if (characterStatesHashMap == null) return states;
        States epsilonStates = characterStatesHashMap.get(EPSILON) == null ? new States() : characterStatesHashMap.get(EPSILON);
        Iterator<State> iterator = epsilonStates.iterator();
        while (iterator.hasNext()) {
            State next = iterator.next();
            States epsilonClosure = epsilonClosure(next);
            states.addAll(epsilonClosure);
            states.add(state);
            states.add(next);
        }
        return states;
    }

    public States nextState(States states, char alphabet) {
        States allCurrentStates = new States();
        Iterator<State> iterator = states.iterator();
        while (iterator.hasNext()) {
            States nextState = getNextStateOnGivenState(iterator.next(), alphabet);
            allCurrentStates.addAll(nextState);
        }
        return allCurrentStates;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NFATransitionFunction that = (NFATransitionFunction) o;

        if (transitionTable != null ? !transitionTable.equals(that.transitionTable) : that.transitionTable != null)
            return false;
        return EPSILON != null ? EPSILON.equals(that.EPSILON) : that.EPSILON == null;

    }

    @Override
    public int hashCode() {
        int result = transitionTable != null ? transitionTable.hashCode() : 0;
        result = 31 * result + (EPSILON != null ? EPSILON.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "" +
                transitionTable;

    }
}

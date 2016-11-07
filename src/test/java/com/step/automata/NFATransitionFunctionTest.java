package com.step.automata;

import com.step.automata.nfa.NFATransitionFunction;
import com.step.automata.utils.State;
import com.step.automata.utils.States;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NFATransitionFunctionTest {
    @Test
    public void shouldReturnAllCurrentStates() throws Exception {
        NFATransitionFunction nfaTransitionFunction = new NFATransitionFunction();
        State q1 = new State("q1");
        State q2 = new State("q2");
        State q3 = new State("q3");

        States stateForQ1 = new States();
        stateForQ1.add(q2);


        States stateForQ1OnOne = new States();
        stateForQ1OnOne.add(q3);

        States stateForQ2 = new States();
        stateForQ2.add(q3);

        States stateForQ3 = new States();
        stateForQ3.add(q3);

        nfaTransitionFunction.addTransition(q1, stateForQ1, '0');
        nfaTransitionFunction.addTransition(q1, stateForQ1OnOne, '1');
        nfaTransitionFunction.addTransition(q2, stateForQ2, '1');
        nfaTransitionFunction.addTransition(q3, stateForQ3, '1');
        States states = new States();
        states.add(q3);
        assertEquals(nfaTransitionFunction.getNextStateOnGivenState(q1, '1'), states);
        assertEquals(nfaTransitionFunction.getNextStateOnGivenState(q3, '1'), states);

    }


    @Test
    public void shouldReturnAllStatesWhichAreConnectedToEpsilon() throws Exception {
        NFATransitionFunction nfaTransitionFunction = new NFATransitionFunction();
        State q1 = new State("q1");
        State q2 = new State("q2");
        State q4 = new State("q4");

        States stateForQ1OnEpsilon = new States();
        stateForQ1OnEpsilon.add(q2);

        States stateForQ2 = new States();
        stateForQ2.add(q4);

        nfaTransitionFunction.addTransition(q1, stateForQ1OnEpsilon, 'e');
        nfaTransitionFunction.addTransition(q2, stateForQ2, '1');
        States epsilonStates = nfaTransitionFunction.getNextStateOnGivenState(q1,'1');

        States expectedStates = new States();
        expectedStates.add(q4);
        Assert.assertEquals(expectedStates, epsilonStates);

    }
}
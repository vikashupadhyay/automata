package com.step.automata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransitionFunctionTest {
    @Test
    public void shouldCreateTransitionFunction() throws Exception {
        State q0State = new State("q0");
        State q1State = new State("q1");
        TransitionFunction transitionFunction = new TransitionFunction();
        transitionFunction.setTransition(q0State, q1State, '0');
        assertEquals(transitionFunction.getNextState(q0State, '0'), q1State);
        assertEquals(transitionFunction.getNextState(q0State, '1'), null);

    }
}
package com.step.automata;

import com.step.automata.dfa.DFATransitionFunction;
import com.step.automata.utils.State;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransitionFunctionTest {
    @Test
    public void shouldCreateTransitionFunction() throws Exception {
        State q0State = new State("q0");
        State q1State = new State("q1");
        DFATransitionFunction transitionFunction = new DFATransitionFunction();
        transitionFunction.addTransition(q0State, q1State, '0');
        assertEquals(transitionFunction.nextState(q0State, '0'), q1State);
        assertEquals(transitionFunction.nextState(q0State, '1'), null);

    }
}
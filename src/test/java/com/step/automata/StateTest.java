package com.step.automata;

import com.step.automata.utils.State;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StateTest {
    @Test
    public void shouldEqualsTwoStates() throws Exception {
        State q0 = new State("q0");
        assertTrue(q0.equals(new State("q0")));
    }
}
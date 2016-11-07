package com.step.automata.utils;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StatesTest {

    @Test
    public void shouldReturnInterSectionOFToSet() throws Exception {
        State q1 = new State("q1");
        State q2 = new State("q2");

        States finalStates = new States();
        finalStates.add(q1);
        finalStates.add(q2);

        States currentStates = new States();
        currentStates.add(q2);

        assertTrue(finalStates.hasIntersection(currentStates));
        assertTrue(currentStates.hasIntersection(finalStates));

    }
}
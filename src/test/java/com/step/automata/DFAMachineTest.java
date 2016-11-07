package com.step.automata;

import com.step.automata.dfa.DFAMachine;
import com.step.automata.dfa.DFATransitionFunction;
import com.step.automata.utils.State;
import com.step.automata.utils.States;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DFAMachineTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldRecognizeAllStringWhichAllElementAreOnes() throws Exception {
        State q0State = new State("q0");
        State q1State = new State("q1");
        States finalStates = new States();
        finalStates.add(q0State);

        States allStates = new States();
        allStates.add(q0State);
        allStates.add(q1State);
        DFATransitionFunction transitionFunction = new DFATransitionFunction();
        transitionFunction.addTransition(q0State, q0State, '1');
        transitionFunction.addTransition(q0State, q1State, '0');
        transitionFunction.addTransition(q1State, q1State, '1');
        transitionFunction.addTransition(q1State, q1State, '0');
        HashSet<Character> alphabets = new HashSet<>();
        alphabets.add('0');
        alphabets.add('1');
        DFAMachine machine = new DFAMachine(transitionFunction, q0State, finalStates, allStates, alphabets);
        assertTrue(machine.isRecognizes("1111"));
        assertFalse(machine.isRecognizes("1111110"));
        assertFalse(machine.isRecognizes("011110"));


    }

    @Test
    public void shouldRecognizeStringWhichIsStartWithZeroAndZeroAndOnesShouldBeInAlternatePosition() throws Exception {
        State q1 = new State("q1");
        State q2 = new State("q2");
        State q3 = new State("q3");
        State q4 = new State("q4");
        States finalStates = new States();
        finalStates.add(q2);
        finalStates.add(q3);

        States states = new States();
        states.add(q1);
        states.add(q2);
        states.add(q3);
        states.add(q4);

        HashSet<Character> alphabets = new HashSet<>();
        alphabets.add('0');
        alphabets.add('1');

        DFATransitionFunction transitionFunction = new DFATransitionFunction();
        transitionFunction.addTransition(q1, q2, '0');
        transitionFunction.addTransition(q1, q4, '1');
        transitionFunction.addTransition(q2, q4, '0');
        transitionFunction.addTransition(q2, q3, '1');
        transitionFunction.addTransition(q3, q2, '0');
        transitionFunction.addTransition(q3, q4, '1');
        transitionFunction.addTransition(q4, q4, '0');
        transitionFunction.addTransition(q4, q4, '1');
        DFAMachine machine = new DFAMachine(transitionFunction, q1, finalStates, states, alphabets);

        assertTrue(machine.isRecognizes("01"));
        assertTrue(machine.isRecognizes("010"));
        assertTrue(machine.isRecognizes("0101"));
        assertTrue(machine.isRecognizes("0101010"));
        assertFalse(machine.isRecognizes("010100"));
        assertFalse(machine.isRecognizes("0100"));
        assertTrue(machine.isRecognizes("0"));
        assertFalse(machine.isRecognizes("1"));
    }


    @Test
    public void shouldThrowExceptionIfStateIsInValid() throws Exception {
        State q0State = new State("q0");
        State q1State = new State("q1");
        States finalStates = new States();
        finalStates.add(q0State);

        States allStates = new States();
        allStates.add(q0State);

        DFATransitionFunction transitionFunction = new DFATransitionFunction();
        transitionFunction.addTransition(q0State, q0State, '1');
        transitionFunction.addTransition(q0State, q1State, '0');
        transitionFunction.addTransition(q1State, q1State, '1');
        transitionFunction.addTransition(q1State, q1State, '0');
        HashSet<Character> alphabets = new HashSet<>();
        alphabets.add('0');
        alphabets.add('1');
        DFAMachine machine = new DFAMachine(transitionFunction, q0State, finalStates, allStates, alphabets);
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("state is invalid");
        machine.isRecognizes("1111");

    }

    @Test
    public void shouldThrowExceptionIfTransitionIsInValid() throws Exception {
        State q0State = new State("q0");
        State q1State = new State("q1");
        States finalStates = new States();
        finalStates.add(q0State);

        States allStates = new States();
        allStates.add(q0State);
        allStates.add(q1State);
        DFATransitionFunction transitionFunction = new DFATransitionFunction();
        transitionFunction.addTransition(q0State, q0State, '1');
        transitionFunction.addTransition(q0State, q1State, '0');
        transitionFunction.addTransition(q1State, q1State, '1');
        transitionFunction.addTransition(q1State, q1State, '0');
        HashSet<Character> alphabets = new HashSet<>();
        alphabets.add('0');
        DFAMachine machine = new DFAMachine(transitionFunction, q0State, finalStates, allStates, alphabets);
        thrown.expect(RuntimeException.class);
        thrown.expectMessage("transition is invalid");
        machine.isRecognizes("1111");

    }
}

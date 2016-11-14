package com.step.automata;

import com.step.automata.nfa.NFAMachine;
import com.step.automata.nfa.NFATransitionFunction;
import com.step.automata.utils.State;
import com.step.automata.utils.States;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NFAMachineTest {
    @Test
    public void shouldPassAlternateCharactersBeginningAndendingWithSameLetter() throws Exception {
        State q1State = new State("q1");
        State q2State = new State("q2");
        State q3State = new State("q3");
        State q4State = new State("q4");
        State q5State = new State("q5");
        State q6State = new State("q6");
        State q7State = new State("q7");

        States finalStates = new States();
        finalStates.add(q3State);
        finalStates.add(q6State);


        States allStates = new States();
        allStates.add(q1State);
        allStates.add(q2State);
        allStates.add(q3State);
        allStates.add(q4State);
        allStates.add(q5State);
        allStates.add(q6State);
        allStates.add(q7State);

        States statesForQ1OnEpsilon = new States();
        statesForQ1OnEpsilon.add(q2State);
        statesForQ1OnEpsilon.add(q5State);

        States statesForQ2OnZero = new States();
        statesForQ2OnZero.add(q3State);

        States statesForQ3OnOne = new States();
        statesForQ3OnOne.add(q4State);

        States statesForQ4OnZero = new States();
        statesForQ4OnZero.add(q3State);

        States statesForQ5OnOne = new States();
        statesForQ5OnOne.add(q6State);

        States statesForQ6OnZero = new States();
        statesForQ6OnZero.add(q7State);

        States statesForQ7OnOne = new States();
        statesForQ2OnZero.add(q6State);

        NFATransitionFunction transitionFunction = new NFATransitionFunction();
        transitionFunction.addTransition(q1State, statesForQ1OnEpsilon, 'e');
        transitionFunction.addTransition(q2State, statesForQ2OnZero, '0');
        transitionFunction.addTransition(q3State, statesForQ3OnOne, '1');
        transitionFunction.addTransition(q4State, statesForQ4OnZero, '0');
        transitionFunction.addTransition(q5State, statesForQ5OnOne, '1');
        transitionFunction.addTransition(q6State, statesForQ6OnZero, '0');
        transitionFunction.addTransition(q7State, statesForQ7OnOne, '1');

        HashSet<Character> alphabets = new HashSet<>();
        alphabets.add('0');
        alphabets.add('1');
        NFAMachine nfaMachine = new NFAMachine(transitionFunction, new State("q1"), finalStates, allStates, alphabets);
        assertTrue(nfaMachine.isRecognizes("010"));
        assertTrue(nfaMachine.isRecognizes("0"));
        assertTrue(nfaMachine.isRecognizes("1"));
        assertFalse(nfaMachine.isRecognizes("0101"));

    }
}

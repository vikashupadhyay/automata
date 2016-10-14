package machine;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DFAMachineTest {
    @Test
    public void shouldRecognizeAllStringWhichAllElementAreOnes() throws Exception {
        State q0State = new State("q0");
        q0State.setFinalState();
        q0State.setInitialState();
        State q1State = new State("q1");

        TransitionFunction transitionFunction = new TransitionFunction();
        transitionFunction.setTransition(q0State, q0State, '1');
        transitionFunction.setTransition(q0State, q1State, '0');
        transitionFunction.setTransition(q1State, q1State, '1');
        transitionFunction.setTransition(q1State, q1State, '0');

        DFAMachine machine = new DFAMachine(transitionFunction, q0State);

        assertTrue(machine.isRecognizes("1111"));
        assertFalse(machine.isRecognizes("1111110"));
        assertFalse(machine.isRecognizes("011110"));


    }

    @Test
    public void shouldRecognizeStringWhichIsStartWithZeroAndZeroAndOnesShouldBeInAlternatePosition() throws Exception {
        State q1 = new State("q1");
        q1.setInitialState();
        State q2 = new State("q2");
        q2.setFinalState();
        State q3 = new State("q3");
        q3.setFinalState();
        State q4 = new State("q4");

        TransitionFunction transitionFunction = new TransitionFunction();
        transitionFunction.setTransition(q1, q2, '0');
        transitionFunction.setTransition(q1, q4, '1');
        transitionFunction.setTransition(q2, q4, '0');
        transitionFunction.setTransition(q2, q3, '1');
        transitionFunction.setTransition(q3, q2, '0');
        transitionFunction.setTransition(q3, q4, '1');
        transitionFunction.setTransition(q4, q4, '0');
        transitionFunction.setTransition(q4, q4, '1');
        DFAMachine machine = new DFAMachine(transitionFunction, q1);

        assertTrue(machine.isRecognizes("01"));
        assertTrue(machine.isRecognizes("010"));
        assertTrue(machine.isRecognizes("0101"));
        assertTrue(machine.isRecognizes("0101010"));
        assertFalse(machine.isRecognizes("010100"));
        assertFalse(machine.isRecognizes("0100"));
        assertTrue(machine.isRecognizes("0"));
        assertFalse(machine.isRecognizes("1"));
    }
}

package machine;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
}

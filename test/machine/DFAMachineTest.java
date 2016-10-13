package machine;

import machine.DFAMachine;
import machine.States;
import machine.TransitionFunction;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DFAMachineTest {
    @Test
    public void shouldRecognizeAllStringWhichAllElementAreOnes() throws Exception {
        States states = new States();
        states.add("q0");
        states.add("q1");
        states.setFinalState("q0");
        states.setInitialState("q0");
        String initialState = states.getInitialState();
        TransitionFunction transitionFunction = new TransitionFunction();
        transitionFunction.setTransition("q0","q0",'1');
        transitionFunction.setTransition("q0","q1",'0');
        transitionFunction.setTransition("q1","q1",'1');
        transitionFunction.setTransition("q1","q1",'0');
        DFAMachine machine = new DFAMachine(states,transitionFunction,initialState);
        
        assertTrue(machine.isRecognizes("1111"));
        assertFalse(machine.isRecognizes("11011"));


    }
}

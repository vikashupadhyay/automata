import machine.Alphabet;
import machine.States;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MachineTest {
    @Test
    public void shouldCreateMachine() throws Exception {
        States states = new States();
        states.add("q0");
        states.add("q1");
        states.setFinalState("q0");
        states.setInitialState("q1");
        String initialState = states.getInitialState();
        Alphabet alphabet = new Alphabet();
        alphabet.add("0");
        alphabet.add("1");
        DeltaFun deltaFunc = new DeltaFun(states,"0");
        DFAMachine machine = new DFAMachine(states, alphabet,deltaFunc,initialState);
        
        assertTrue(machine.isRecognizes("101"));

    }
}

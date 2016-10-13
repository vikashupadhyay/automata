package machine;

import org.junit.Test;

import static org.junit.Assert.*;

public class TransitionFunctionTest {
    @Test
    public void shouldCreateTransitionFunction() throws Exception {
        TransitionFunction transitionFunction = new TransitionFunction();
        transitionFunction.setTransition("q0","q1",'0');
        assertEquals(transitionFunction.process("q0",'0'),"q1");
        assertEquals(transitionFunction.process("q0",'1'),null);

    }
}
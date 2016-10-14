package machine;

import org.junit.Test;

import static org.junit.Assert.*;

public class StateTest {
    @Test
    public void setState() throws Exception {
        State q0 = new State("q0");
        q0.setFinalState();
        q0.setInitialState();
        assertTrue(q0.isFinalState());
        assertTrue(q0.isInitialState());
    }
}
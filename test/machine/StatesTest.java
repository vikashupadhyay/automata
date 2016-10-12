package machine;

import org.junit.Test;

import static org.junit.Assert.*;

public class StatesTest {
    @Test
    public void shouldCreateSetOfStates() throws Exception {
        States states = new States();
        states.add("q0");
        states.add("q1");
        assertEquals(states.size(),2);

    }

    @Test
    public void shouldSetInitialState() throws Exception {
        States states = new States();
        states.add("q0");
        states.add("q1");
        states.setInitialState("q0");
        assertTrue(states.isInitialState("q0"));
        assertFalse(states.isInitialState("q1"));
        assertEquals(states.size(),2);
    }

    @Test
    public void shouldSetFinalState() throws Exception {
        States states = new States();
        states.add("q0");
        states.add("q1");
        states.add("q2");
        states.setFinalState("q1");
        states.setFinalState("q2");
        assertTrue(states.isFinalState("q1"));
        assertTrue(states.isFinalState("q2"));
        assertFalse(states.isFinalState("q0"));
        assertEquals(states.size(),3);

    }
}
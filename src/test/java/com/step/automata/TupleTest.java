package com.step.automata;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TupleTest {
    @Test
    public void shouldSetTransition() throws Exception {
        JsonParser jsonParser = new JsonParser();
        JsonArray states = (JsonArray) jsonParser.parse("[q1,q2]");
        JsonArray finalStates = (JsonArray)jsonParser.parse("[q2]");
        JsonObject delta = (JsonObject) jsonParser.parse("{q1:{0:q2,1:q1},q2:{0:q1,1:q2}}");
        JsonArray alphabets = (JsonArray) jsonParser.parse("[1,0]");
        Tuple tuple = new Tuple("q1", finalStates, states, delta, alphabets);

        TransitionFunction dummyTransition = new TransitionFunction();
        State q1 = new State("q1");
        State q2 = new State("q2");
        dummyTransition.setTransition(q1,q2,'0');
        dummyTransition.setTransition(q1,q1,'1');
        dummyTransition.setTransition(q2,q1,'0');
        dummyTransition.setTransition(q2,q2,'1');
        TransitionFunction transitionFunction = tuple.getTransitionFunction();
        assertEquals(dummyTransition,transitionFunction);

    }
}
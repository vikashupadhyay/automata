package com.step.automata;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class TupleParserTest {
    private ArrayList<String> states;
    private ArrayList<String> alphabets;
    private HashMap<String, HashMap<String, String>> deltaFun;
    private ArrayList<String> finalStates;
    private String startState;

    @Before
    public void setUp() throws Exception {
        startState = "q1";
        states = new ArrayList<String>();
        states.add("q1");
        states.add("q2");


        alphabets = new ArrayList<String>();
        alphabets.add("0");
        alphabets.add("1");


        HashMap<String, String> transitionForQ1 = new HashMap<>();
        transitionForQ1.put("0", "q2");
        transitionForQ1.put("1", "q1");

        HashMap<String, String> transitionForQ2 = new HashMap<>();
        transitionForQ2.put("0", "q1");
        transitionForQ2.put("1", "q2");

        deltaFun = new HashMap<>();
        deltaFun.put("q1", transitionForQ1);
        deltaFun.put("q2", transitionForQ2);

        finalStates = new ArrayList<>();
        finalStates.add("q2");

    }

    @Test
    public void shouldParseAllStates() throws Exception {
        TupleParser parse = new TupleParser(states, alphabets, deltaFun, "q1", finalStates);
        HashSet<State> expectedAllStates = new HashSet<>();
        expectedAllStates.add(new State("q1"));
        expectedAllStates.add(new State("q2"));
        assertEquals(parse.parseStates(), expectedAllStates);
        assertEquals(parse.parseStates().size(), 2);

    }

    @Test
    public void shouldParseFinalStates() throws Exception {
        TupleParser parse = new TupleParser(states, alphabets, deltaFun, "q1", finalStates);
        HashSet<State> expectedFinalStates = new HashSet<>();
        expectedFinalStates.add(new State("q2"));
        assertEquals(parse.parseFinalStates(), expectedFinalStates);
        assertEquals(parse.parseFinalStates().size(), 1);

    }

    @Test
    public void shouldParseStartState() throws Exception {
        TupleParser parse = new TupleParser(states, alphabets, deltaFun, "q1", finalStates);
        assertEquals(parse.parseStartState(), new State("q1"));

    }

    @Test
    public void shouldParseTransitionTable() throws Exception {
        TupleParser tupleParser = new TupleParser(states, alphabets, deltaFun, "q1", finalStates);

        TransitionFunction transitionFunction = tupleParser.parseTransitionTable();

        TransitionFunction expected = new TransitionFunction();
        State q1 = new State("q1");
        State q2 = new State("q2");
        expected.setTransition(q1, q2, '0');
        expected.setTransition(q1, q1, '1');
        expected.setTransition(q2, q1, '0');
        expected.setTransition(q2, q2, '1');

        assertEquals(expected, transitionFunction);


    }

    @Test
    public void shouldParseAlphabets() throws Exception {
        HashSet<Character> expectedAlphabets = new HashSet<>();
        expectedAlphabets.add('0');
        expectedAlphabets.add('1');
        TupleParser tupleParser = new TupleParser(states, alphabets, deltaFun, "q1", finalStates);

        assertEquals(tupleParser.parseAlphabets(), expectedAlphabets);
    }
}
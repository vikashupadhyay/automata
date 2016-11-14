package com.step.automata;

import com.step.automata.dfa.DFATransitionFunction;
import com.step.automata.nfa.NFATransitionFunction;
import com.step.automata.utils.State;
import com.step.automata.utils.States;
import com.step.automata.utils.TupleParser;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class TupleParserTest {
    private Set<String> states;
    private Set<String> alphabets;
    private HashMap<String, HashMap<String, Object>> deltaFunForDfa;
    private Set<String> finalStates;
    private String startState;

    @Before
    public void setUp() throws Exception {
        startState = "q1";
        states = new HashSet<>();
        states.add("q1");
        states.add("q2");


        alphabets = new HashSet<>();
        alphabets.add("0");
        alphabets.add("1");

        finalStates = new HashSet<>();
        finalStates.add("q2");

    }

    @Test
    public void shouldParseAllStates() throws Exception {
        TupleParser parse = new TupleParser(states, alphabets, deltaFunForDfa, "q1", finalStates);
        States expectedAllStates = new States();
        expectedAllStates.add(new State("q1"));
        expectedAllStates.add(new State("q2"));
        assertEquals(parse.parseStates(), expectedAllStates);
        assertEquals(parse.parseStates().size(), 2);

    }

    @Test
    public void shouldParseFinalStates() throws Exception {
        TupleParser parse = new TupleParser(states, alphabets, deltaFunForDfa, "q1", finalStates);
        States expectedFinalStates = new States();
        expectedFinalStates.add(new State("q2"));
        assertEquals(parse.parseFinalStates(), expectedFinalStates);
        assertEquals(parse.parseFinalStates().size(), 1);

    }

    @Test
    public void shouldParseStartState() throws Exception {
        TupleParser parse = new TupleParser(states, alphabets, deltaFunForDfa, "q1", finalStates);
        assertEquals(parse.parseStartState(), new State("q1"));

    }

    @Test
    public void shouldParseDfaTransitionTable() throws Exception {
        HashMap<String, Object> transitionForQ1 = new HashMap<>();
        transitionForQ1.put("0", "q2");
        transitionForQ1.put("1", "q1");

        HashMap<String, Object> transitionForQ2 = new HashMap<>();
        transitionForQ2.put("0", "q1");
        transitionForQ2.put("1", "q2");

        deltaFunForDfa = new HashMap<>();
        deltaFunForDfa.put("q1", transitionForQ1);
        deltaFunForDfa.put("q2", transitionForQ2);
        TupleParser tupleParser = new TupleParser(states, alphabets, deltaFunForDfa, "q1", finalStates);

        DFATransitionFunction transitionFunction = tupleParser.parseDFATransitionTable();

        DFATransitionFunction expected = new DFATransitionFunction();
        State q1 = new State("q1");
        State q2 = new State("q2");
        expected.addTransition(q1, q2, '0');
        expected.addTransition(q1, q1, '1');
        expected.addTransition(q2, q1, '0');
        expected.addTransition(q2, q2, '1');

        assertEquals(expected, transitionFunction);


    }

    @Test
    public void shouldParseNfaTransitionTable() throws Exception {
        HashMap<String, Object> transitionForQ1 = new HashMap<>();
        ArrayList<String> pathForQ1 = new ArrayList<>();
        pathForQ1.add("q1");

        ArrayList<String> pathForQ2 = new ArrayList<>();
        pathForQ2.add("q2");

        transitionForQ1.put("0", pathForQ1);

        HashMap<String, Object> transitionForQ2 = new HashMap<>();
        transitionForQ2.put("1", pathForQ2);

        HashMap<String, HashMap<String, Object>> deltaFunForNfa = new HashMap<>();
        deltaFunForNfa.put("q1", transitionForQ1);
        deltaFunForNfa.put("q2", transitionForQ2);

        TupleParser tupleParser = new TupleParser(states, alphabets, deltaFunForNfa, "q1", finalStates);

        NFATransitionFunction transitionFunction = tupleParser.parseNFATransitionTable();

        NFATransitionFunction expected = new NFATransitionFunction();
        State q1 = new State("q1");
        State q2 = new State("q2");
        States statesForQ1 = new States();
        statesForQ1.add(q1);

        States statesForQ2 = new States();
        statesForQ2.add(q2);
        expected.addTransition(q1, statesForQ1, '0');
        expected.addTransition(q2, statesForQ2, '1');

        assertEquals(expected, transitionFunction);


    }

    @Test
    public void shouldParseAlphabets() throws Exception {
        HashSet<Character> expectedAlphabets = new HashSet<>();
        expectedAlphabets.add('0');
        expectedAlphabets.add('1');
        TupleParser tupleParser = new TupleParser(states, alphabets, deltaFunForDfa, "q1", finalStates);

        assertEquals(tupleParser.parseAlphabets(), expectedAlphabets);
    }
}
package com.step.automata;

import com.google.gson.JsonArray;
import com.step.automata.utils.JsonParser;
import com.step.automata.utils.JsonReader;
import com.step.automata.utils.State;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataParserTest {
    @Test
    public void shouldParseJsonFile() throws Exception {
        JsonReader dataParser = new JsonReader();
        JsonArray parse = dataParser.parse("/Users/kvikas/step2Sem/automata/data/sample.json");
        assertEquals(parse.size(), 1);


    }

    @Test
    public void shouldReplacereplaceDashsWithUnderscoreFromJsonStringKeys() throws Exception {
        JsonReader dataParser = new JsonReader();
        String jsonString = "[{\"name\":\"odd number of zeroes\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q1\"},\"q2\":{\"0\":\"q1\",\"1\":\"q2\"}},\"start-state\":\"q1\",\"final-states\":[\"q2\"]},\"pass-cases\":[\"0\",\"000\",\"00000\",\"10\",\"101010\",\"010101\"],\"fail-cases\":[\"00\",\"0000\",\"1001\",\"1010\",\"001100\"]}]";
        String string = dataParser.replaceDashsWithUnderscore(jsonString);
        String expectation = "[{\"name\":\"odd number of zeroes\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q1\"},\"q2\":{\"0\":\"q1\",\"1\":\"q2\"}},\"start_state\":\"q1\",\"final_states\":[\"q2\"]},\"pass_cases\":[\"0\",\"000\",\"00000\",\"10\",\"101010\",\"010101\"],\"fail_cases\":[\"00\",\"0000\",\"1001\",\"1010\",\"001100\"]}]";
        assertEquals(string, expectation);
    }

    @Test
    public void shouldParseJsonForDfaMachine() throws Exception {
        JsonReader jsonReader = new JsonReader();
        String json = "{\"name\":\"odd number of zeroes\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q1\"},\"q2\":{\"0\":\"q1\",\"1\":\"q2\"}},\"start_state\":\"q1\",\"final_states\":[\"q2\"]},\"pass_cases\":[\"0\",\"000\",\"00000\",\"10\",\"101010\",\"010101\"],\"fail_cases\":[\"00\",\"0000\",\"1001\",\"1010\",\"001100\"]}";

        JsonParser parser = jsonReader.parseJson(json);


        assertEquals(parser.parseAllStates().size(),2);
        assertEquals(parser.parseFinalStates().size(),1);
        assertEquals(parser.parseAllStates().size(),2);
        assertEquals(parser.getFailCases().size(),5);
        assertEquals(parser.getPassCases().size(),6);

    }

    @Test
    public void shouldParseJsonForNfaMachine() throws Exception {
        JsonReader jsonReader = new JsonReader();


        String json = "{\"name\":\"alternate characters beginning and ending with same letter\",\"type\":\"nfa\",\"tuple\":{\"states\":[\"q1\",\"q3\",\"q7\",\"q2\",\"q5\",\"q6\",\"q4\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"e\":[\"q2\",\"q5\"]},\"q2\":{\"0\":[\"q3\"]},\"q3\":{\"1\":[\"q4\"]},\"q4\":{\"0\":[\"q3\"]},\"q5\":{\"1\":[\"q6\"]},\"q6\":{\"0\":[\"q7\"]},\"q7\":{\"1\":[\"q6\"]}},\"start_state\":\"q1\",\"final_states\":[\"q3\",\"q6\"]},\"pass_cases\":[\"0\",\"010\",\"01010\",\"1\",\"101\",\"10101\"],\"fail_cases\":[\"\",\"10\",\"01\",\"11\",\"00\",\"001\",\"100\",\"1100\"]}";

        JsonParser parser = jsonReader.parseJson(json);

        assertEquals(parser.parseStartStates(),new State("q1"));
        assertEquals(parser.parseFinalStates().size(),2);
        assertEquals(parser.parseAllStates().size(),7);
        assertEquals(parser.getFailCases().size(),8);
        assertEquals(parser.getPassCases().size(),6);

    }
}
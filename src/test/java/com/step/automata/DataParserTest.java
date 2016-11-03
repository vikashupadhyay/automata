package com.step.automata;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataParserTest {
    @Test
    public void shouldParseJsonFile() throws Exception {
        DataParser dataParser = new DataParser();
        JsonArray parse = dataParser.parse("/Users/kvikas/step2Sem/automata/data/sample.json");
        assertEquals(parse.size(), 1);


    }

    @Test
    public void shouldReplacereplaceDashsWithUnderscoreFromJsonStringKeys() throws Exception {
        DataParser dataParser = new DataParser();
        String jsonString = "[{\"name\":\"odd number of zeroes\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q1\"},\"q2\":{\"0\":\"q1\",\"1\":\"q2\"}},\"start-state\":\"q1\",\"final-states\":[\"q2\"]},\"pass-cases\":[\"0\",\"000\",\"00000\",\"10\",\"101010\",\"010101\"],\"fail-cases\":[\"00\",\"0000\",\"1001\",\"1010\",\"001100\"]}]";
        String string = dataParser.replaceDashsWithUnderscore(jsonString);
        String expectation = "[{\"name\":\"odd number of zeroes\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q1\"},\"q2\":{\"0\":\"q1\",\"1\":\"q2\"}},\"start_state\":\"q1\",\"final_states\":[\"q2\"]},\"pass_cases\":[\"0\",\"000\",\"00000\",\"10\",\"101010\",\"010101\"],\"fail_cases\":[\"00\",\"0000\",\"1001\",\"1010\",\"001100\"]}]";
        assertEquals(string, expectation);
    }

    @Test
    public void shouldCreateMachine() throws Exception {
        DataParser dataParser = new DataParser();
        String json = "{\"name\":\"odd number of zeroes\",\"type\":\"dfa\",\"tuple\":{\"states\":[\"q1\",\"q2\"],\"alphabets\":[\"1\",\"0\"],\"delta\":{\"q1\":{\"0\":\"q2\",\"1\":\"q1\"},\"q2\":{\"0\":\"q1\",\"1\":\"q2\"}},\"start_state\":\"q1\",\"final_states\":[\"q2\"]},\"pass_cases\":[\"0\",\"000\",\"00000\",\"10\",\"101010\",\"010101\"],\"fail_cases\":[\"00\",\"0000\",\"1001\",\"1010\",\"001100\"]}";
        JsonParser parser = dataParser.parseJson(json);
        assertEquals(parser.parseFinalStates().size(),1);
        assertEquals(parser.parseAllStates().size(),2);
        assertEquals(parser.getFailCases().size(),5);
        assertEquals(parser.getPassCases().size(),6);

    }
}
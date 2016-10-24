package com.step.automata;

import org.junit.Test;

public class DataParserTest {
    @Test
    public void shouldParseJsonFile() throws Exception {
        DataParser dataParser = new DataParser();
        String parse = dataParser.parse("/Users/kvikas/step2Sem/automata/data/examples.json");
        dataParser.parseJsonString(parse);

    }
}
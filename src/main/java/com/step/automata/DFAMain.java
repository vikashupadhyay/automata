package com.step.automata;

import com.google.gson.JsonArray;

import java.io.IOException;

public class DFAMain {
    public static void main(String[] args) {
        DataParser dataParser = new DataParser();
        try {
            JsonArray parse = dataParser.parse("/Users/kvikas/step2Sem/automata/data/examples.json");
            for (int i = 0; i < parse.size(); i++) {
                JsonParser parser = dataParser.parseJson(parse.get(i).toString());
                DFAMachine dfaMachine = new DFAMachine(parser.parseTransitionTable(),
                        parser.parseStartStates(),
                        parser.parseFinalStates(),
                        parser.parseAllStates(),
                        parser.parseAlphabets());
                Presenter presenter = new Presenter(parser.getPassCases(), parser.getFailCases());
                presenter.present(dfaMachine,parser.getName(),parser.getType());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

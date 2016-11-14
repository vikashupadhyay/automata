package com.step.automata.dfa;

import com.google.gson.JsonArray;
import com.step.automata.nfa.NFAMachine;
import com.step.automata.utils.JsonParser;
import com.step.automata.utils.JsonReader;

import java.io.IOException;
import java.util.Objects;

public class DFAMain {
    public static void main(String[] args) {
        JsonReader dataParser = new JsonReader();
        try {
            JsonArray parse = dataParser.parse("/Users/kvikas/step2Sem/automata/data/nfaExample.json");
            for (int i = 0; i < parse.size(); i++) {
                JsonParser parser = dataParser.parseJson(parse.get(i).toString());
                if (Objects.equals(parser.getType(), "dfa")) {
                    DFAMachine dfaMachine = new DFAMachine(parser.parseTransitionTable(),
                            parser.parseStartStates(),
                            parser.parseFinalStates(),
                            parser.parseAllStates(),
                            parser.parseAlphabets());
                    Presenter presenter = new Presenter(parser.getPassCases(), parser.getFailCases());
                    presenter.presentDfa(dfaMachine, parser.getName(), parser.getType());
                }

                if (Objects.equals(parser.getType(), "nfa")) {
                    NFAMachine nfaMachine = new NFAMachine(parser.parseTransitionTable(),
                            parser.parseStartStates(),
                            parser.parseFinalStates(),
                            parser.parseAllStates(),
                            parser.parseAlphabets());
                    Presenter presenter = new Presenter(parser.getPassCases(), parser.getFailCases());
                    presenter.presentNfa(nfaMachine, parser.getName(), parser.getType());
                }


            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

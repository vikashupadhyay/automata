package com.step.automata;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

public class DataParser {
    public String parse(String path) throws IOException {
        JsonParser jsonParser = new JsonParser();
        return jsonParser.parse(new FileReader(path)).getAsString();
    }

    public void parseJsonString(String jsonAsString) {
        JsonParser jsonParser = new JsonParser();
        JsonArray jsonArray = (JsonArray) jsonParser.parse(jsonAsString);
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonElement jsonElement = jsonArray.get(i);
            MachineBuilder machineBuilder = new MachineBuilder(jsonElement.getAsJsonObject().get("name").getAsString(),
                    jsonElement.getAsJsonObject().get("type").getAsString(),
                    jsonElement.getAsJsonObject().get("tuple"),
                    jsonElement.getAsJsonObject().get("pass-cases"),
                    jsonElement.getAsJsonObject().get("fail-cases"));
            machineBuilder.createDfa();
        }

    }

}

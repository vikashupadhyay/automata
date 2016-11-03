package com.step.automata;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.IOException;

public class DataParser {
    public JsonArray parse(String path) throws IOException {
        com.google.gson.JsonParser jsonParser = new com.google.gson.JsonParser();
        String string = jsonParser.parse(new FileReader(path)).getAsString();
        String replaceUnderscore = replaceDashsWithUnderscore(string);
        return jsonParser.parse(replaceUnderscore.substring(0, string.length())).getAsJsonArray();

    }

    public String replaceDashsWithUnderscore(String jsonString) {
        return jsonString.replaceAll("-", "_");
    }

    public JsonParser parseJson(String string) {
        Gson gson = new Gson();
        com.google.gson.JsonParser jsonParser = new com.google.gson.JsonParser();
        JsonObject parse = (JsonObject) jsonParser.parse(string);
        JsonParser parser = gson.fromJson(parse, JsonParser.class);
        return parser;
    }
}

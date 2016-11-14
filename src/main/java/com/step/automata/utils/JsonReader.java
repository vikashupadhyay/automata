package com.step.automata.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    public JsonArray parse(String path) throws IOException {
        com.google.gson.JsonParser jsonParser = new com.google.gson.JsonParser();
        String string = jsonParser.parse(new FileReader(path)).getAsString();
        String replaceUnderscore = replaceDashsWithUnderscore(string);
        return jsonParser.parse(replaceUnderscore.substring(0, string.length())).getAsJsonArray();

    }

    public String replaceDashsWithUnderscore(String jsonString) {
        return jsonString.replaceAll("-", "_");
    }

    public JsonParser parseJson(String string) throws IOException {
        Gson gson = new Gson();
        return gson.fromJson(string, JsonParser.class);
    }
}

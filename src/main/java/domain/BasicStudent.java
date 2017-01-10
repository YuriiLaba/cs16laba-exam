package domain;

import json.*;

/**
 * Created by Andrii_Rodionov on 1/5/2017.
 */
public class BasicStudent implements Jsonable {

    protected String name;
    protected String surname;
    protected Integer year;

    public BasicStudent() {
    }

    public BasicStudent(String name, String surname, Integer year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonString jsonString = new JsonString(name);
        JsonPair jsonPair = new JsonPair("name", jsonString);
        JsonString jsonString1 = new JsonString(surname);
        JsonPair jsonPair1 = new JsonPair("surname", jsonString1);
        JsonNumber jsonNumber = new JsonNumber(this.year);
        JsonPair jsonPair2 = new JsonPair("year", jsonNumber);
        return new JsonObject(jsonPair, jsonPair1, jsonPair2);
    }
}

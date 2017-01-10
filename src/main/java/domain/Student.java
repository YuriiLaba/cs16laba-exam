package domain;

import json.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {

    final JsonObject passedExams = new JsonObject();
    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {

        }

    @Override
    public JsonObject toJsonObject() {
        // ToDo
        return null;
    }
}
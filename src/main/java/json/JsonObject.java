package json;

import java.util.ArrayList;

import java.util.Objects;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {

    private ArrayList<JsonPair> jsonList = new ArrayList<>();

    public JsonObject(JsonPair... jsonPairs) {
        for(JsonPair jsonPair: jsonPairs){
            this.add(jsonPair);
        }
    }

    @Override
    public String toJson() {

        if (jsonList.size() == 0){
            return "{}";
        }
        else {
        String result = "{";

        for(int i = 0; i < jsonList.size(); i++ ){
            if(jsonList.indexOf(jsonList.get(i)) == jsonList.size()-1 ){
                result += jsonList.get(i).key + " : " +  jsonList.get(i).value.toJson();
            }else{
            result += jsonList.get(i).key + " : " +  jsonList.get(i).value.toJson() + " , ";}


        }
        result += "}";
        return result;
    }}

    public void add(JsonPair jsonPair) {
        for(int i = 0; i < jsonList.size(); i++){
            if(Objects.equals(jsonList.get(i).key, jsonPair.key)){
                jsonList.remove(i);
                //jsonList.add(i, jsonPair);
            }
        }jsonList.add(jsonPair);



    }
    public boolean contains(String name){
        for(JsonPair jsonPair: jsonList){
            return jsonPair.key.equals(name);
        }return false;
    }



    public Json find(String name) {
        for (JsonPair aJsonList : jsonList) {
            if (Objects.equals(aJsonList.key, name)) {
                return aJsonList.value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject result = new JsonObject();
        for(int i = 0; i < jsonList.size(); i++ ){
            for(String name: names){
                if(jsonList.get(i).key.contains(name)){
                    result.add(jsonList.get(i));
                }
            }
        }
        return result;
    }
}

package proiectdiz.Storage.Helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import proiectdiz.Storage.Log.Log;
import proiectdiz.Storage.Model.QuantecKey;
import proiectdiz.Storage.Service.KeyHolder;

import java.util.Optional;

public class JsonHandler {

    public JsonHandler(){};
    public static JsonNode StringToJson(String message){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(message);
        } catch(Exception e){
            Log.ErrorLog("Error at converting to json: "+e.getMessage());
            return null;
        }

    }
    public static String JsonToString(JsonNode request) throws JsonProcessingException {
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(request);
        }
        catch(Exception e){
            Log.ErrorLog("Error at converting to json:"+e.getMessage());
            return null;
        }

    }

    public static Optional<String> CreateRequest(String _keyID){

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode rootNode = objectMapper.createObjectNode();
        ArrayNode keyIDsArray = objectMapper.createArrayNode();
        ObjectNode keyIDObject = objectMapper.createObjectNode();
        keyIDObject.put("key_ID", _keyID);
        keyIDsArray.add(keyIDObject);
        rootNode.set("key_IDs", keyIDsArray);
        try {
            String jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);
            return Optional.of(jsonString);

        } catch (Exception e) {
            Log.ErrorLog(e.getMessage());
            return Optional.empty();
        }


    }

     public static String getKeyFromJson(String response){

            JsonNode respJSON=StringToJson(response);


         JsonNode keysNode = respJSON.get("keys").get(0);

         String key = keysNode.get("key").asText();
            return key;

     }


    public static String getKeyIDFromJson(String response){
        JsonNode respJSON=StringToJson(response);
        JsonNode keysNode = respJSON.get("keys").get(0);
        String keyId = keysNode.get("key_ID").asText();
        return keyId;

    }






}

package proiectdiz.Storage.Helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import proiectdiz.Storage.Log.Log;
import proiectdiz.Storage.Model.QuantecKey;
import proiectdiz.Storage.Model.ShareObject;
import proiectdiz.Storage.Service.KeyHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JsonHandler {

    public JsonHandler() {
    }

    ;

    public static JsonNode StringToJson(String message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(message);
        } catch (Exception e) {
            Log.ErrorLog("Error at converting to json: " + e.getMessage());
            return null;
        }

    }

    public static String JsonToString(JsonNode request) throws JsonProcessingException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(request);
        } catch (Exception e) {
            Log.ErrorLog("Error at converting to json:" + e.getMessage());
            return null;
        }

    }

    public static Optional<String> CreateGetKeyByIdRequest(String _keyID) {

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
    public static Optional<String> CreateGetKeyRequest(){
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode node = JsonNodeFactory.instance.objectNode();
        node.put("number", "1");
        node.put("size", 1024);


        try {
            String jsonString = node.toPrettyString();
            return Optional.of(jsonString);

        } catch (Exception e) {
            Log.ErrorLog(e.getMessage());
            return Optional.empty();
        }
    }

    public static String getKeyFromJson(String response) {

        JsonNode respJSON = StringToJson(response);


        JsonNode keysNode = respJSON.get("keys").get(0);

        String key = keysNode.get("key").asText();
        return key;

    }


    public static String getKeyIDFromJson(String response) {
        JsonNode respJSON = StringToJson(response);
        JsonNode keysNode = respJSON.get("keys").get(0);
        String keyId = keysNode.get("key_ID").asText();
        return keyId;

    }


    public static List<ShareObject> getSharesFromPile(String pile) {
        List<ShareObject> shares = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            JsonNode rootNode = objectMapper.readTree(pile);
            JsonNode sharesNode = rootNode.get("Shares");
            if (sharesNode.isArray()) {
                for (JsonNode shareNode : sharesNode) {
                    String guid = shareNode.get("GUID").asText();
                    String x = shareNode.get("X").asText();
                    String y = shareNode.get("Y").asText();
                    ShareObject share = new ShareObject(x, y, guid);
                    shares.add(share);


                }
            }
            return shares;
        } catch (Exception e) {
            Log.ErrorLog(e.getMessage());
            return null;
        }

    }

    public static List<String> getUUID_List_FromPile(JsonNode pile) {
        List<String> shares = new ArrayList<>();
        try {



            JsonNode sharesNode = pile.get("GUIDs");
            if (sharesNode.isArray()) {
                for (JsonNode shareNode : sharesNode) {

                    String guid = shareNode.get("GUID").asText();
                    if(guid.charAt(0)==' '){
                       guid= guid.substring(1,guid.length());
                    }
                    //guid="'"+guid+"'";

                   // ShareObject share = new ShareObject(guid);
                    shares.add(guid);


                }
            }
            return shares;
        } catch (Exception e) {
            Log.ErrorLog(e.getMessage());
            return null;
        }

    }



    public static String CreateSHARESJsonToSend(List<ShareObject> shares, String serverNumber){

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode rootNode = objectMapper.createObjectNode();
        ArrayNode SharesArray = objectMapper.createArrayNode();
        for(ShareObject obj:shares){
            ObjectNode share_obj = objectMapper.createObjectNode();
            share_obj.put("GUID",obj.getGUID());
            share_obj.put("X",obj.getX());
            share_obj.put("Y",obj.getY());
            SharesArray.add(share_obj);

        }
        rootNode.set("Shares",SharesArray);
        rootNode.put("Server",serverNumber);
        return rootNode.toString();


    }



}

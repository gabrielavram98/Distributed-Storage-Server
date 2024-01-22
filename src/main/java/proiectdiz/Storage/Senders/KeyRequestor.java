package proiectdiz.Storage.Senders;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import proiectdiz.Storage.Config.WebClientConfig;
import proiectdiz.Storage.Helpers.JsonHandler;
import proiectdiz.Storage.Helpers.Properties;
import proiectdiz.Storage.Helpers.ValidationCheck;
import proiectdiz.Storage.Log.Log;
import proiectdiz.Storage.Model.Master_Slave.SAE_Masters;
import proiectdiz.Storage.Model.Master_Slave.SAE_Slaves;
import proiectdiz.Storage.Helpers.JsonHandler;
import proiectdiz.Storage.Model.QuantecKey;

import java.util.Optional;
import java.util.UUID;



public class KeyRequestor extends Thread{
    private QuantecKey key;
    private int iterator;
    public KeyRequestor( int i){

        this.iterator=i;
    }
    public void run(){



        WebClientConfig keySenderWebConfig = new WebClientConfig();
        KeyRequestService _keyRequestService = new KeyRequestService(keySenderWebConfig.webClientBuilder());
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode node = JsonNodeFactory.instance.objectNode();
        node.put("number", "1");
        node.put("size", 1024);


        String json = node.toPrettyString();


        String response=_keyRequestService.getKey(json, "/" + SAE_Masters.values()[iterator] + "/" + "/api/v1/keys/" + SAE_Slaves.values()[iterator] + "/enc_keys");


        try {
            ValidationCheck.Validate(JsonHandler.StringToJson(response), "src\\\\main\\\\resources\\\\KeyFormatContainerSchema.json");
            this.key=ExtractKeyEelements(response);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }



    }

    private QuantecKey ExtractKeyEelements( String response) throws Exception {
        JsonNode responseJSON= JsonHandler.StringToJson(response);

        if(responseJSON!=null){

            JsonNode keys=responseJSON.get("keys");

            JsonNode key=keys.get(0);
            String key_ID=key.get("key_ID").asText();
            String key_=key.get("key").asText();
            String key_ID_extension=key.get("key_ID_extension").asText();
            String key_container_extension= responseJSON.get("key_container_extension").asText();
           return new QuantecKey(key_ID,key_,key_ID_extension,key_container_extension);



        }
        else{

            throw new Exception("Response Json is null in getting new key to send back shares.");
        }





    }

    public QuantecKey getKey() {
        return key;
    }
}

package proiectdiz.Storage.Service;

import com.fasterxml.jackson.databind.JsonNode;
import proiectdiz.Storage.Helpers.JsonHandler;
import proiectdiz.Storage.Log.Log;
import proiectdiz.Storage.Senders.AES;
import proiectdiz.Storage.Senders.KeyRequestorById;

import java.nio.charset.StandardCharsets;

public class ProcessShare {

    public ProcessShare(){}
    public void Process(JsonNode share) throws InterruptedException {

        System.out.println(share);
        String key_ID=share.get("key_ID").asText();
        String encrypted_share=share.get("share").asText();
        String resp="";
        try{
            KeyRequestorById requestor= new KeyRequestorById(key_ID);
            requestor.start();
            requestor.join();
            resp=requestor.getResponse();
            String key= JsonHandler.getKeyFromJson(resp);
            AES aes= new AES(key,encrypted_share);
            String sharePlainText=new String (aes.Decrypt(), StandardCharsets.UTF_8);
            System.out.println(sharePlainText);

        }catch (Exception e){
            Log.ErrorLog(e.getMessage());

        }





    }
}

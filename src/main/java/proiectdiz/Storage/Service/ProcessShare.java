package proiectdiz.Storage.Service;

import com.fasterxml.jackson.databind.JsonNode;
import proiectdiz.Storage.Log.Log;
import proiectdiz.Storage.Senders.KeyRequestorById;

public class ProcessShare {

    public ProcessShare(){}
    public void Process(JsonNode share) throws InterruptedException {

        System.out.println(share);
        String key_ID=share.get("key_ID").asText();
        String encrypted_share=share.get("share").asText();
        try{
            KeyRequestorById requestor= new KeyRequestorById(key_ID);
            requestor.start();
            requestor.join();
        }catch (Exception e){
            Log.ErrorLog(e.getMessage());

        }





    }
}

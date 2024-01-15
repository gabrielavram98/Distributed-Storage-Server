package proiectdiz.Storage.Service;

import com.fasterxml.jackson.databind.JsonNode;
import proiectdiz.Storage.Database.DatabaseHandler;
import proiectdiz.Storage.Helpers.JsonHandler;
import proiectdiz.Storage.Log.Log;
import proiectdiz.Storage.Model.ShareObject;
import proiectdiz.Storage.Senders.AES;
import proiectdiz.Storage.Senders.KeyRequestorById;

import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;
import java.util.List;

public class ProcessShare {

    public ProcessShare(){}
    public void Process(JsonNode share) throws InterruptedException {

        System.out.println(share);
        String key_ID=share.get("key_ID").asText();
        String encrypted_share=share.get("share").asText();
        String IV=share.get("IV").asText();
        byte[] ivBytes = Base64.getDecoder().decode(IV);
        String resp="";
        try{
            KeyRequestorById requestor= new KeyRequestorById(key_ID);

            requestor.start();

            requestor.join();
            resp=requestor.getResponse();
            String key= JsonHandler.getKeyFromJson(resp);
            AES aes= new AES(key,encrypted_share);
            aes.setIv(new IvParameterSpec(ivBytes));
            String sharePlainText=aes.Decrypt();
            List<ShareObject> shares= JsonHandler.getSharesFromPile(sharePlainText);
            //System.out.println("I come from thread that handles share number:"+key_ID.charAt(key_ID.length()-1)+": "+sharePlainText);

        }catch (Exception e){
            Log.ErrorLog(e.getMessage());

        }





    }

    public void Gather(JsonNode request ){
        DatabaseHandler db_handler= new DatabaseHandler();
            List<ShareObject> empty_shares=JsonHandler.getUUID_List_FromPile(request);
            List<ShareObject> populated_shares= db_handler.populate_with_shares(empty_shares);
            //  gergrgergerg

    }

}

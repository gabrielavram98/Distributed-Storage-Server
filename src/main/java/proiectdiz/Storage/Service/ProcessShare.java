package proiectdiz.Storage.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.fasterxml.jackson.databind.node.ObjectNode;
import proiectdiz.Storage.Database.DatabaseHandler;
import proiectdiz.Storage.Helpers.JsonHandler;
import proiectdiz.Storage.Helpers.Properties;
import proiectdiz.Storage.Log.Log;
import proiectdiz.Storage.Model.QuantecKey;
import proiectdiz.Storage.Model.ShareObject;
import proiectdiz.Storage.Senders.AES;
import proiectdiz.Storage.Senders.KeyRequestor;
import proiectdiz.Storage.Senders.KeyRequestorById;

import javax.crypto.spec.IvParameterSpec;
import java.sql.SQLException;
import java.util.*;

public class ProcessShare {

    public ProcessShare(){}
    public JsonNode DecryptShares(JsonNode share) throws InterruptedException {

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
            return JsonHandler.StringToJson(sharePlainText);
        }catch (Exception e){
            Log.ErrorLog(e.getMessage());
            return null;
        }





    }

    public String EncryptShares(String server_shares, String servernumber) throws Exception {
       try{
           KeyRequestor requestor= new KeyRequestor(Integer.parseInt(servernumber));
           requestor.start();
           requestor.join();
           QuantecKey key=requestor.getKey();
           AES aes= new AES(key.getKey(),server_shares);
           String encrypted_shares= aes.Encrypt();
           ObjectMapper objectMapper = new ObjectMapper();
           ObjectNode rootNode = objectMapper.createObjectNode();
           rootNode.put("key_ID",key.get_keyId());
           rootNode.put("Shares",encrypted_shares);
           rootNode.put("IV",aes.getIv());
           rootNode.put("Server",servernumber);
           return rootNode.toPrettyString();




       }catch(Exception e){
           Log.ErrorLog(e.getMessage());
           throw new Exception(e.getMessage());
       }

    }








}

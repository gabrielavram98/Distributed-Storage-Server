package proiectdiz.Storage.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import proiectdiz.Storage.Database.DatabaseHandler;
import proiectdiz.Storage.Helpers.JsonHandler;
import proiectdiz.Storage.Helpers.Properties;
import proiectdiz.Storage.Log.Log;
import proiectdiz.Storage.Model.ShareObject;
import proiectdiz.Storage.Senders.AES;
import proiectdiz.Storage.Senders.KeyRequestorById;

import javax.crypto.spec.IvParameterSpec;
import java.sql.SQLException;
import java.util.*;

public class ProcessShare {

    public ProcessShare(){}
    public JsonNode Process(JsonNode share) throws InterruptedException {

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
            //List<ShareObject> shares= JsonHandler.getSharesFromPile(sharePlainText);
            return JsonHandler.StringToJson(sharePlainText);
            //System.out.println("I come from thread that handles share number:"+key_ID.charAt(key_ID.length()-1)+": "+sharePlainText);

        }catch (Exception e){
            Log.ErrorLog(e.getMessage());
            return null;
        }





    }

    public void Gather(JsonNode guid_list_json , String servernumber) throws SQLException {
        DatabaseHandler db_handler= new DatabaseHandler(Properties.getUsername(),Properties.getPassword(),Properties.getConnectionString(),servernumber);
            List<String> guid_string_list=JsonHandler.getUUID_List_FromPile(guid_list_json);
            String guid_string=  String.join(",",guid_string_list);
            List<String>params= new ArrayList<>();
            params.add(guid_string);
            Map<String,String> results= db_handler.ExecuteStoredProcedure(Properties.getReturnProc(),params);

           // List<ShareObject> populated_shares= db_handler.populate_with_shares(empty_shares);


    }
    public List<ShareObject> populate_with_shares(List<ShareObject> empty_list){
        List<ShareObject> populated_list= new ArrayList<>();
        //todo: populate list
        return populated_list;
    }

}

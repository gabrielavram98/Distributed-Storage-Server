package proiectdiz.Storage.Model;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpStatus;
import proiectdiz.Storage.Database.DatabaseHandler;
import proiectdiz.Storage.Helpers.JsonHandler;
import proiectdiz.Storage.Helpers.Properties;
import proiectdiz.Storage.Helpers.ValidationCheck;
import proiectdiz.Storage.Senders.ShareSender;
import proiectdiz.Storage.Service.ProcessShare;
import proiectdiz.Storage.Service.ShareMerge;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RequestHandler {

    public RequestHandler(){}

    public  HttpStatus HandleStoreRequest(String requestBody, String servernumber) throws Exception {
        JsonNode requestBodyJSON= JsonHandler.StringToJson(requestBody);
        if(ValidationCheck.Validate(requestBodyJSON,"src\\main\\resources\\Share_format.json")!=0){

            throw new Exception("Error in Validating the request: "+requestBody);
        }
        ProcessShare processShare = new ProcessShare();
        JsonNode shares_json=processShare.DecryptShares(requestBodyJSON);
        List<ShareObject> shares= JsonHandler.getSharesFromPile(JsonHandler.JsonToString(shares_json));
        DatabaseHandler db_handler= new DatabaseHandler(Properties.getUsername(),Properties.getPassword(),Properties.getConnectionString(),servernumber);
        for(ShareObject obj:shares){
            List<String> params= new ArrayList<>();
            params.add(obj.getGUID());
            params.add(obj.getX());
            params.add(obj.getY());
            List<ShareObject> results=db_handler.ExecuteStoredProcedure(Properties.getInsertShareProc(),params);
            System.out.println("OK");



        }




        return HttpStatus.ACCEPTED;

    }

    public HttpStatus HandleGetRequest(String requestBody,String servernumber) throws Exception{
        JsonNode requestBodyJSON= JsonHandler.StringToJson(requestBody);
        if(ValidationCheck.Validate(requestBodyJSON,"src\\main\\resources\\RequestSchema.json")!=0){

            throw new Exception("Error in Validating the request: "+requestBody);
        }
        ProcessShare processShare = new ProcessShare();
        JsonNode guid_list_json = processShare.DecryptShares(requestBodyJSON);
        String tosend=ShareMerge.Gather(guid_list_json,servernumber);
        String encrypted_share_to_send=processShare.EncryptShares(tosend,servernumber);
        ShareSender sender= new ShareSender(encrypted_share_to_send);
        sender.start();
        sender.join();
        System.out.println(requestBody);
        return HttpStatus.ACCEPTED;

    }




}
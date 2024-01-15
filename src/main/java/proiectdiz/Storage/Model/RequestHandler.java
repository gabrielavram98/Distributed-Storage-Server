package proiectdiz.Storage.Model;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpStatus;
import proiectdiz.Storage.Helpers.JsonHandler;
import proiectdiz.Storage.Helpers.ValidationCheck;
import proiectdiz.Storage.Service.ProcessShare;

import java.nio.charset.StandardCharsets;

public class RequestHandler {

    public RequestHandler(){}

    public  HttpStatus HandleStoreRequest(String requestBody) throws Exception {
        JsonNode requestBodyJSON= JsonHandler.StringToJson(requestBody);
        if(ValidationCheck.Validate(requestBodyJSON)!=0){

            throw new Exception("Error in Validating the request: "+requestBody);
        }
        ProcessShare processShare = new ProcessShare();
        processShare.Process(requestBodyJSON);




        return HttpStatus.ACCEPTED;

    }

    public HttpStatus HandleGetRequest(String requestBody) throws Exception{

        //TODO: Validate uuid array
        return HttpStatus.ACCEPTED;

    }




}
package proiectdiz.Storage.Model;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpStatus;
import proiectdiz.Storage.Helpers.JsonHandler;
import proiectdiz.Storage.Helpers.ValidationCheck;

import java.nio.charset.StandardCharsets;

public class RequestHandler {

    public static HttpStatus Handle(String requestBody) throws Exception {
        JsonNode requestBodyJSON= JsonHandler.StringToJson(requestBody);
        if(ValidationCheck.Validate(requestBodyJSON)!=0){

            throw new Exception("Error in Validating the request: "+requestBody);
        }


        return HttpStatus.ACCEPTED;

    }




}
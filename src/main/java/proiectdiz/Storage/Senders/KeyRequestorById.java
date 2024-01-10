package proiectdiz.Storage.Senders;

import proiectdiz.Storage.Config.WebClientConfig;
import proiectdiz.Storage.Helpers.JsonHandler;
import proiectdiz.Storage.Helpers.Properties;
import proiectdiz.Storage.Log.Log;

import java.util.Optional;
import java.util.UUID;

public class KeyRequestorById extends Thread {

    private String key_uuid;
    private int iterator;
    public KeyRequestorById(String uuid){
        this.key_uuid=uuid;

    }
    private String response;
    public void start(){
        WebClientConfig keySenderWebConfig = new WebClientConfig();
        KeyRequestByIdService _keyRequestorById= new KeyRequestByIdService( keySenderWebConfig.webClientBuilder());
        Optional<String> request=JsonHandler.CreateRequest(key_uuid);

        if(request.isPresent()){
            String uuid= UUID.randomUUID().toString();
            response=_keyRequestorById.getKey(request.get(), Properties.getDestination(key_uuid.charAt(key_uuid.length()-1)));

            Log.InfoLog(response);

        }





    }
    public String getResponse(){
        return response;
    }


}

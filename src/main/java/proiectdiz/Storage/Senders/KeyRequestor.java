package proiectdiz.Storage.Senders;

import proiectdiz.Storage.Config.WebClientConfig;
import proiectdiz.Storage.Helpers.JsonHandler;
import proiectdiz.Storage.Helpers.Properties;
import proiectdiz.Storage.Log.Log;

import java.util.Optional;
import java.util.UUID;

public class KeyRequestor extends Thread{
private String uuid;
private String response;

public KeyRequestor(String key){
    this.uuid=key;
}
    public void start(){
        WebClientConfig keySenderWebConfig = new WebClientConfig();
        KeyRequestService _keyRequestor= new KeyRequestService( keySenderWebConfig.webClientBuilder());
        Optional<String> request= JsonHandler.CreateGetKeyRequest();

        if(request.isPresent()){
           // String uuid= UUID.randomUUID().toString();
            response=_keyRequestor.getKey(request.get(), Properties.getDestination_(uuid.charAt(uuid.length()-1)));

            Log.InfoLog(response);

        }





    }
}

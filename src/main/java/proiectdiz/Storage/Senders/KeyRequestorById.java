package proiectdiz.Storage.Senders;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.reactive.function.client.WebClient;
import proiectdiz.Storage.Config.WebClientConfig;
import proiectdiz.Storage.Helpers.JsonHandler;
import proiectdiz.Storage.Helpers.Properties;
import proiectdiz.Storage.Log.Log;

import java.util.Optional;

public class KeyRequestorById extends Thread {

    private String key_uuid;
    private int iterator;
    public KeyRequestorById(String uuid){
        this.key_uuid=uuid;

    }

    public void run(){
        WebClientConfig keySenderWebConfig = new WebClientConfig();
        KeyRequestByIdService _keyRequestorById= new KeyRequestByIdService( keySenderWebConfig.webClientBuilder());
        Optional<String> request=JsonHandler.CreateRequest(key_uuid);
        String response="";
        if(request.isPresent()){
            response=_keyRequestorById.getKey(request.get(), Properties.getDestination());
            Log.InfoLog(response);

        }




    }


}

package proiectdiz.Storage.Service;

import proiectdiz.Storage.Model.QuantecKey;

import java.util.*;

public class KeyHolder {
    private static List<QuantecKey> KeyList= new ArrayList<QuantecKey>();
    private static Map<String,String> keyMapper= new HashMap<>();
    public static QuantecKey getKey(String guid){
        QuantecKey key = null;
        for(QuantecKey keyFound:KeyList){
            if(keyFound.get_keyId().equals(guid)){
                key= keyFound;
                break;

            }
        }
        return key;


    }









}

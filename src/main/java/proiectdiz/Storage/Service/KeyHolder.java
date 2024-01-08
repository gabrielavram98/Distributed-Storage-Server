package proiectdiz.Storage.Service;

import proiectdiz.Storage.Log.Log;
import proiectdiz.Storage.Model.QuantecKey;
import proiectdiz.Storage.Senders.KeyRequestorById;

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

    public static QuantecKey  getKeyByUUID(String uuid){
        QuantecKey key=null;
        for(Map.Entry<String,String> entry: keyMapper.entrySet()){
            if(entry.getKey().equals(uuid)){
                key=getKey(entry.getValue());
                break;
            }
        }
        return key;
    }


    public static void AddKey(QuantecKey key, String uuid){
        KeyList.add(key);
        keyMapper.put(uuid,key.get_keyId());

    }






}

package proiectdiz.Storage.Model;

public class QuantecKey {
    private String _keyId;
    private String key;
    private String _key_extenstion;
    private String key_container_extension;


    public QuantecKey(String _keyId,String key,String _key_extenstion, String key_container_extension){
        this._key_extenstion=_key_extenstion;
        this.key=key;
        this.key_container_extension=key_container_extension;
        this._keyId=_keyId;

    }

    public QuantecKey(){};

    public String get_keyId() {
        return _keyId;
    }

    public String getKey() {
        return key;
    }
}
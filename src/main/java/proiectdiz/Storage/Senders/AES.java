package proiectdiz.Storage.Senders;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;

public class AES {

    private byte[] key;
    private byte[] Text;


    public AES(String key, String Text ){
        this.key=key.getBytes(StandardCharsets.UTF_8);
        this.Text=Text.getBytes(StandardCharsets.UTF_8);
    }
    public byte[] Encrypt() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        Cipher cipher = Cipher.getInstance("AES");
        SecretKey secret_key= convertBytesToSecretKey(key);
        cipher.init(Cipher.ENCRYPT_MODE, secret_key);
        return cipher.doFinal(Text);


    }

    public byte[] Decrypt() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        Cipher cipher = Cipher.getInstance("AES");
        SecretKey secret_key= convertBytesToSecretKey(key);
        cipher.init(Cipher.DECRYPT_MODE, secret_key);
        return cipher.doFinal(Text);

    }
    private static SecretKey convertBytesToSecretKey(byte[] keyBytes) {
        // Create a SecretKey using SecretKeySpec
        return new SecretKeySpec(keyBytes, 0, keyBytes.length, "AES");
    }
}

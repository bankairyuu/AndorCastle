package andorcastle.services.model;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

abstract class EmbeddedProfile {
    private String username;
    private String password;
    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String encrypt(String keyString, String clearString) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        String strData;
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyString.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encrypted = cipher.doFinal(clearString.getBytes());
        strData = new String(encrypted);
        return strData;
    }

    private String decrypt( String keyString, String encryptedString) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        String strData;
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyString.getBytes(), "Blowfish");
        Cipher cipher = Cipher.getInstance("Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decrypted = cipher.doFinal(encryptedString.getBytes());
        strData = new String(decrypted);
        return strData;
    }


    private void encryptAll(String keyString) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        setUsername(encrypt(keyString, getUsername()));
        setEmail(encrypt(keyString, getEmail()));
        setPassword(encrypt(keyString, getPassword()));
    }

    private void decryptAll(String keyString) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        setUsername(decrypt(keyString, getUsername()));
        setEmail(decrypt(keyString, getEmail()));
        setPassword(decrypt(keyString, getPassword()));
    }
}

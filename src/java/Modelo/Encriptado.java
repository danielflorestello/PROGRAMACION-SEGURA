package Modelo;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encriptado {
    
    public static String getMD5(String input) {
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] encBytes = md.digest(input.getBytes());
            BigInteger number = new BigInteger(1, encBytes);
            String hashtext = number.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
            
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
}

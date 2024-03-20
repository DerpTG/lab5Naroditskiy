package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SHAFinder {
    private String algorithm;

    // Constructor that takes the algorithm name as an argument
    public SHAFinder(String algorithm) {
        this.algorithm = algorithm;
    }

    public String encrypt(String data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        byte[] hashBytes = digest.digest(data.getBytes());
        return Base64.getEncoder().encodeToString(hashBytes);
    }
}

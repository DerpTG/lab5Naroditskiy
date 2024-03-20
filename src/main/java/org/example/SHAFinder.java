/** Project: Solo Lab 5 Assignment
 * Purpose Details: To Demonstrate Security Features Within Java
 * Course: IST 242
 * Author: Felix Naroditskiy
 * Date Developed: 3/14/2024
 * Last Date Changed: 3/20/2024
 * Rev: 1.0
 */

package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * This class provides functionality to compute the hash of given data and encode it in Base64.
 */
public class SHAFinder {
    /**
     * The name of the hashing algorithm to be used for generating the hash.
     */
    private String algorithm;

    /**
     * Constructs a SHAFinder instance with a specified hashing algorithm.
     *
     * @param algorithm The name of the hashing algorithm (e.g., "SHA-256") to use.
     */
    public SHAFinder(String algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * Encrypts the given data using the specified hashing algorithm and returns a Base64-encoded hash.
     *
     * @param data The input data to be hashed.
     * @return The Base64-encoded hash of the input data.
     * @throws NoSuchAlgorithmException If the specified hashing algorithm is not available.
     */
    public String encrypt(String data) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        byte[] hashBytes = digest.digest(data.getBytes());
        return Base64.getEncoder().encodeToString(hashBytes);
    }
}


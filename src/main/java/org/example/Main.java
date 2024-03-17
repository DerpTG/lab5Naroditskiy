package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for user input
        System.out.println("Enter an English string to encrypt and manipulate:");
        String englishString = scanner.nextLine();

        // Instantiate the classes
        AlphabetCodeConverter alphabetCodeConverter = new AlphabetCodeConverter();
        SHAFinder shafinder = new SHAFinder();


        // Convert to new alphabet and back
        String newAlphabetString = alphabetCodeConverter.decrypt(englishString);
        System.out.println("Converted to new alphabet: " + newAlphabetString);

        String originalString = alphabetCodeConverter.encrypt(newAlphabetString);
        System.out.println("Converted back to English: " + originalString);

        // SHA-256 Hash
        String hashValue = shafinder.findSHA(newAlphabetString);
        System.out.println("SHA-256 hash of new alphabet string: " + hashValue);

        // Caesar Cipher
        System.out.println("How much would you like to shift the text for the Caesar Cipher?: ");
        int shift = scanner.nextInt();
        scanner.nextLine();
        CaeserCipherConverter cipher = new CaeserCipherConverter(shift);
        String cipheredString = cipher.encrypt(newAlphabetString);
        System.out.println("Caesar Cipher: " + cipheredString);

        String decipheredString = cipher.decrypt(cipheredString);
        System.out.println("Decrypted back to original new alphabet string: " + decipheredString);

        // Brute Force
        System.out.println("Now performing brute force: ");
        BruteForce bruteForce = new BruteForce(cipheredString);
        bruteForce.decrypt();

        scanner.close();
    }
}
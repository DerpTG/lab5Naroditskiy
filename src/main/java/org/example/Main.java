package org.example;

import java.util.Scanner;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an English string to encrypt and manipulate:");
        String englishString = scanner.nextLine();

        AlphabetCodeConverter alphabet = new AlphabetCodeConverter(englishString);
        String newAlphabetString = alphabet.encrypt();
        System.out.println("Converted to new alphabet: " + newAlphabetString);

        String originalString = alphabet.decrypt(newAlphabetString);
        System.out.println("Converted back to English: " + originalString);

        while (true) {
            // Display menu
            System.out.println("Please select an operation:");
            System.out.println("1 - Calculate SHA-256 hash of the new Alphabet String");
            System.out.println("2 - Perform Caesar Cipher operations on the new Alphabet String");
            System.out.println("3 - Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                // SHA-256 Hash
                try {
                    SHAFinder shafinder = new SHAFinder("SHA-256");
                    String hashValue = shafinder.encrypt(newAlphabetString);
                    System.out.println("SHA-256 hash of new alphabet string: " + hashValue);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            } else if (choice == 2) {
                // Caesar Cipher encryption
                System.out.println("Enter the shift value for the Caesar Cipher:");
                int shiftValue = scanner.nextInt();
                scanner.nextLine();

                CaeserCipherConverter caesarCipherConverter = new CaeserCipherConverter(shiftValue);
                String cipheredString = caesarCipherConverter.encrypt(newAlphabetString);
                System.out.println("Caesar Cipher (encrypted): " + cipheredString);

                // Nested menu for post-encryption actions
                System.out.println("Select next action for the encrypted string:");
                System.out.println("1 - Decrypt using the known shift value");
                System.out.println("2 - Perform Brute Force decryption");
                System.out.println("3 - Return to main menu");
                int nestedChoice = scanner.nextInt();
                scanner.nextLine();

                if (nestedChoice == 1) {
                    String decryptedString = caesarCipherConverter.decrypt(cipheredString);
                    System.out.println("Decrypted string: " + decryptedString);
                } else if (nestedChoice == 2) {
                    System.out.println("Performing brute force decryption:");
                    BruteForce bruteForce = new BruteForce(0,26);
                    bruteForce.decrypt(cipheredString);
                } else if (nestedChoice == 3) {
                    continue;
                } else {
                    System.out.println("Invalid choice. Returning to main menu.");
                }
            } else if (choice == 3) {
                System.out.println("Exiting program.");
                break;
            } else {
                System.out.println("Invalid option. Please select a valid option.");
            }
        }
        scanner.close();
    }
}

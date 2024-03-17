package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an English string to encrypt and manipulate:");
        String englishString = scanner.nextLine();
        while (true) {
            // Display menu
            System.out.println("Please select an operation:");
            System.out.println("1 - Convert to new alphabet and back to English");
            System.out.println("2 - Calculate SHA-256 hash of the new alphabet string");
            System.out.println("3 - Perform Caesar Cipher operations");
            System.out.println("4 - Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                // Conversion
                AlphabetCodeConverter alphabet = new AlphabetCodeConverter();
                String newAlphabetString = alphabet.decrypt(englishString);
                System.out.println("Converted to new alphabet: " + newAlphabetString);

                String originalString = alphabetCodeConverter.encrypt(newAlphabetString);
                System.out.println("Converted back to English: " + originalString);
            } else if (choice == 2) {
                // SHA-256 Hash
                SHAFinder shafinder = new SHAFinder();
                String hashValue = shafinder.decypt(englishString);
                System.out.println("SHA-256 hash of new alphabet string: " + hashValue);
            } else if (choice == 3) {
                // Caesar Cipher encryption
                System.out.println("Enter the shift value for the Caesar Cipher:");
                int shiftValue = scanner.nextInt();
                scanner.nextLine();

                CaeserCipherConverter caesarCipherConverter = new CaeserCipherConverter(shiftValue);
                String cipheredString = caesarCipherConverter.encrypt(englishString);
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
                    BruteForce bruteForce = new BruteForce(cipheredString);
                    bruteForce.decrypt();
                } else if (nestedChoice == 3) {
                    continue;
                } else {
                    System.out.println("Invalid choice. Returning to main menu.");
                }
            } else if (choice == 4) {
                System.out.println("Exiting program.");
                break;
            } else {
                System.out.println("Invalid option. Please select a valid option.");
            }
        }
        scanner.close();
    }
}

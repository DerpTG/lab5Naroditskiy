/** Project: Solo Lab 5 Assignment
 * Purpose Details: To Demonstrate Security Features Within Java
 * Course: IST 242
 * Author: Felix Naroditskiy
 * Date Developed: 3/14/2024
 * Last Date Changed: 3/20/2024
 * Rev: 1.0
 */

package org.example;

import java.util.Scanner;
import java.security.NoSuchAlgorithmException;

/**
 * The main class for demonstrating encryption and decryption functionalities including
 * a custom alphabet code converter, SHA-256 hashing, and Caesar cipher operations.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an English string to encrypt and manipulate:");
        String englishString = scanner.nextLine();

        /**
         * Conversion using the alphabet mapping.
         *
         * @param newAlphabetString The plaintext encrypted into the new alphabet.
         */
        AlphabetCodeConverter alphabet = new AlphabetCodeConverter(englishString);
        String newAlphabetString = alphabet.encrypt();
        System.out.println("Converted to new alphabet: " + newAlphabetString);

        /**
         * Conversion back to plaintext.
         *
         * @param originalString The new alphabet string converted back to plaintext.
         */
        String originalString = alphabet.decrypt(newAlphabetString);
        System.out.println("Converted back to English: " + originalString);

        while (true) {
            /**
             * The display list for the user to decide which operation to perform.
             *
             * @param choice The user's choice.
             */
            System.out.println("Please select an operation:");
            System.out.println("1 - Calculate SHA-256 hash of the new Alphabet String");
            System.out.println("2 - Perform Caesar Cipher operations on the new Alphabet String");
            System.out.println("3 - Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                /**
                 * Calculates and displays the SHA-256 hash of the new alphabet string.
                 *
                 * @param hashValue The hash value of the encrypted string.
                 */
                try {
                    SHAFinder shafinder = new SHAFinder("SHA-256");
                    String hashValue = shafinder.encrypt(newAlphabetString);
                    System.out.println("SHA-256 hash of new alphabet string: " + hashValue);
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
            } else if (choice == 2) {
                /**
                 * Encrypts the new alphabet string using Caesar Cipher with a user-specified shift value.
                 *
                 * @param cipheredString The encrypted alphabet string.
                 * @param shiftValue The user entered shift value.
                 */
                System.out.println("Enter the shift value for the Caesar Cipher:");
                int shiftValue = scanner.nextInt();
                scanner.nextLine();

                CaeserCipherConverter caesarCipherConverter = new CaeserCipherConverter(shiftValue);
                String cipheredString = caesarCipherConverter.encrypt(newAlphabetString);
                System.out.println("Caesar Cipher (encrypted): " + cipheredString);

                /**
                 * Nested user choice list.
                 *
                 * @param nestedChoice The user's choice when performing Caeser operations.
                 */
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
                /**
                 * Exits the program.
                 */
                System.out.println("Exiting program.");
                break;
            } else {
                System.out.println("Invalid option. Please select a valid option.");
            }
        }
        scanner.close();
    }
}

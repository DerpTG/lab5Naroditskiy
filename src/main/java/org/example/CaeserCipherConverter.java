package org.example;

public class CaeserCipherConverter {
    private int shift;

    public CaeserCipherConverter(int shift) {
        this.shift = shift;
    }

    // Encrypts plaintext with the initialized shift value
    public String encrypt(String plaintext) {
        StringBuilder encryptedText = new StringBuilder();

        for (char character : plaintext.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                int originalAlphabetPosition = character - base;
                int newAlphabetPosition = (originalAlphabetPosition + this.shift) % 26;
                if (newAlphabetPosition < 0) {
                    newAlphabetPosition += 26;
                }
                char newCharacter = (char) (base + newAlphabetPosition);
                encryptedText.append(newCharacter);
            } else {
                encryptedText.append(character);
            }
        }

        return encryptedText.toString();
    }

    // Decrypts text with the initialized shift value
    public String decrypt(String text) {
        StringBuilder decryptedText = new StringBuilder();

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                int originalAlphabetPosition = character - base;
                int newAlphabetPosition = (originalAlphabetPosition - this.shift) % 26;
                if (newAlphabetPosition < 0) {
                    newAlphabetPosition += 26;
                }
                char newCharacter = (char) (base + newAlphabetPosition);
                decryptedText.append(newCharacter);
            } else {
                decryptedText.append(character);
            }
        }

        return decryptedText.toString();
    }
}
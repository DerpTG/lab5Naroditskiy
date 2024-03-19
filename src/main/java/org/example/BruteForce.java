package org.example;

public class BruteForce {
    private int max;
    private int min;

    public BruteForce(int max, int min) {
        this.max = max;
        this.min = min;
    }

    // Method to perform brute force decryption
    public void decrypt(String encryptedText) {
        for (int shift = min; shift < max; shift++) {
            StringBuilder decryptedText = new StringBuilder();

            for (char character : encryptedText.toCharArray()) {
                if (character != ' ' && character != '!' && character != '.' && character != ',') {
                    int originalPosition = character >= 'a' && character <= 'z' ? character - 'a' : character - 'A';
                    int newPosition = (originalPosition - shift) % 26;
                    newPosition = newPosition < 0 ? newPosition + 26 : newPosition;
                    char newCharacter = (char) ((character >= 'a' && character <= 'z') ? 'a' + newPosition : 'A' + newPosition);
                    decryptedText.append(newCharacter);
                } else {
                    decryptedText.append(character);
                }
            }

            System.out.println(shift + ": " + decryptedText);
        }
    }
}

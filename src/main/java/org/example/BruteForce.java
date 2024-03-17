package org.example;

public class BruteForce {
    public void bruteForceDecrypt(String encryptedText) {
        for (int shift = 0; shift < 26; shift++) {
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

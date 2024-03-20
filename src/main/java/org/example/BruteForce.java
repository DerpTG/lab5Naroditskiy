/** Project: Solo Lab 5 Assignment
 * Purpose Details: To Demonstrate Security Features Within Java
 * Course: IST 242
 * Author: Felix Naroditskiy
 * Date Developed: 3/14/2024
 * Last Date Changed: 3/20/2024
 * Rev: 1.0
 */

package org.example;

import java.util.Arrays;
import java.util.List;

/**
 * Implements brute force decryption for text encrypted with a Caesar cipher using a symbol-based encoding.
 */
public class BruteForce {
    /**
     * Maximum shift value to try during the brute force decryption.
     */
    private int max;

    /**
     * Minimum shift value to start with during the brute force decryption.
     */
    private int min;

    /**
     * A predefined list of symbols representing encrypted characters.
     * This list is used to decrypt the encrypted text by shifting symbols within this collection.
     */
    private List<String> symbolList = Arrays.asList(
            "%#", "##?%", "%###?", "#?%%", "?%", "?##%", // Symbols for A-F
            "####%", "%???%", "??%", "?#%%%","##?#", "%?#?%", // Symbols for G-L
            "##%", "%#?", "###%", "?##?%", "##?#%", "%?#", // Symbols for M-R
            "%%%", "#%", "??#%", "%%%#", "%?#?", "#??#%", // Symbols for S-X
            "#?##%", "?##??%", "#?%%%", "##??%", "###%?", "####?", // Symbols for Y-Z
            "#####%", "?####%", "%??###", "???##%", "%???#", "?????%" // Symbols for 0-9
    );

    /**
     * Constructs a BruteForce instance with specified minimum and maximum shift values for decryption.
     *
     * @param min The minimum shift value to try during decryption.
     * @param max The maximum shift value to try during decryption.
     */
    public BruteForce(int min, int max) {
        this.min = min;
        this.max = max;
    }

    /**
     * Attempts to decrypt the given encrypted text by trying all possible shifts within the specified range.
     *
     * @param encryptedText The text to be decrypted, encoded with the symbol list based on a Caesar cipher shift.
     */
    public void decrypt(String encryptedText) {
        String[] encodedSymbols = encryptedText.split(" ");

        for (int shift = min; shift <= max; shift++) {
            StringBuilder decryptedText = new StringBuilder();

            for (String symbol : encodedSymbols) {
                int index = symbolList.indexOf(symbol);
                if (index != -1) {
                    int newIndex = (index - shift + symbolList.size()) % symbolList.size();
                    decryptedText.append(symbolList.get(newIndex)).append(" ");
                } else {
                    decryptedText.append(symbol).append(" ");
                }
            }

            System.out.println("Shift " + shift + ": " + decryptedText.toString().trim());
        }
    }
}


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
 * A class for converting text using a Caesar cipher method with a predefined list of symbols.
 */
public class CaeserCipherConverter {
    /**
     * The shift value used for the Caesar cipher conversion.
     */
    private int shift;

    /**
     * A predefined list of symbols representing encrypted characters.
     */
    private List<String> symbolList = Arrays.asList(
            "%#", "##?%", "%###?", "#?%%", "?%", "?##%", // A-F
            "####%", "%???%", "??%", "?#%%%", "##?#", "%?#?%", // G-L
            "##%", "%#?", "###%", "?##?%", "##?#%", "%?#", // M-N
            "%%%", "#%", "??#%", "%%%#", "%?#?", "#??#%", // O-T
            "#?##%", "?##??%", "#?%%%", "##??%", "###%?", "####?", // U-Z
            "#####%", "?####%", "%??###", "???##%", "%???#", "?????%", // 0-5
            "?####%", "%??###", "???##%", "%???#", "?????%" // 6-9
    );

    /**
     * Creates a CaesarCipherConverter with a specific shift value for encryption and decryption.
     *
     * @param shift The number of positions to shift in the symbol list.
     */
    public CaeserCipherConverter(int shift) {
        this.shift = shift;
    }

    /**
     * Encrypts the given text by shifting each symbol in the text by the shift value.
     *
     * @param encodedText The text encoded with the predefined symbols to be encrypted.
     * @return The encrypted text as a string with each symbol shifted.
     */
    public String encrypt(String encodedText) {
        StringBuilder encryptedText = new StringBuilder();
        String[] encodedSymbols = encodedText.split(" ");

        for (String symbol : encodedSymbols) {
            int index = symbolList.indexOf(symbol);
            if (index != -1) {
                int newIndex = Math.floorMod(index + shift, symbolList.size());
                encryptedText.append(symbolList.get(newIndex)).append(" ");
            } else {
                encryptedText.append(symbol).append(" ");
            }
        }
        return encryptedText.toString().trim();
    }

    /**
     * Decrypts the given text by reversing the shift applied during encryption.
     *
     * @param encryptedText The text that has been encrypted and is to be decrypted.
     * @return The decrypted text as a string with each symbol shifted back to its original position.
     */
    public String decrypt(String encryptedText) {
        StringBuilder result = new StringBuilder();
        String[] encodedSymbols = encryptedText.split(" ");

        for (String symbol : encodedSymbols) {
            int index = symbolList.indexOf(symbol);
            if (index != -1) {
                int newIndex = Math.floorMod(index - shift, symbolList.size());
                result.append(symbolList.get(newIndex)).append(" ");
            } else {
                result.append(symbol).append(" ");
            }
        }
        return result.toString().trim();
    }
}

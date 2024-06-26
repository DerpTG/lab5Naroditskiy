/** Project: Solo Lab 5 Assignment
 * Purpose Details: To Demonstrate Security Features Within Java
 * Course: IST 242
 * Author: Felix Naroditskiy
 * Date Developed: 3/14/2024
 * Last Date Changed: 3/20/2024
 * Rev: 1.0
 */

package org.example;

import java.util.HashMap;

/**
 * A class that performs encryption and decryption using a custom alphabet code.
 */
public class AlphabetCodeConverter {
    /**
     * The text to be encrypted or decrypted.
     */
    private String text;

    /**
     * Constructs an AlphabetCodeConverter with the given text.
     *
     * @param text The text to be processed.
     */
    public AlphabetCodeConverter(String text) {
        this.text = text;
    }

    /**
     * Encrypts the provided text based on a predefined symbol mapping.
     *
     * @return A string representing the encrypted text, where each character is replaced by symbols.
     */
    public String encrypt() {
        HashMap<Character, String> codeMap = new HashMap<>();
        codeMap.put('A', "%#");codeMap.put('B', "##?%");codeMap.put('C', "%###?");
        codeMap.put('D', "#?%%");codeMap.put('E', "?%");codeMap.put('F', "?##%");
        codeMap.put('G', "####%");codeMap.put('H', "%???%");codeMap.put('I', "??%");
        codeMap.put('J', "?#%%%");codeMap.put('K', "#?#%");codeMap.put('L', "%?#?%");
        codeMap.put('M', "##%");codeMap.put('N', "%#?");codeMap.put('O', "###%");
        codeMap.put('P', "?##?%");codeMap.put('Q', "##?#%");codeMap.put('R', "%?#");
        codeMap.put('S', "%%%");codeMap.put('T', "#%");codeMap.put('U', "??#%");
        codeMap.put('V', "%%%#");codeMap.put('W', "%?#?");codeMap.put('X', "#??#%");
        codeMap.put('Y', "#?##%");codeMap.put('Z', "?##??%");codeMap.put('1', "#?%%%");
        codeMap.put('2', "##??%");codeMap.put('3', "###%?");codeMap.put('4', "####?");
        codeMap.put('5', "#####%");codeMap.put('6', "?####%");codeMap.put('7', "%??###");
        codeMap.put('8', "???##%");codeMap.put('9', "%???#");codeMap.put('0', "?????%");

        StringBuilder encryptedTextBuilder = new StringBuilder();
        text = text.toUpperCase();
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                encryptedTextBuilder.append(" ");
            } else if (codeMap.containsKey(c)) {
                encryptedTextBuilder.append(codeMap.get(c)).append(" ");
            }
        }

        return encryptedTextBuilder.toString().trim();
    }

    /**
     * Decrypts the provided symbol-encoded text based on a predefined symbol-to-character mapping.
     *
     * @param newAlphabetString The symbol-encoded text to be decrypted.
     * @return A string representing the decrypted text, where symbols are replaced by their corresponding characters.
     */
    public String decrypt(String newAlphabetString) {
        HashMap<String, Character> reverseCodeMap = new HashMap<>();
        reverseCodeMap.put("%#", 'A');reverseCodeMap.put("##?%", 'B');reverseCodeMap.put("%###?", 'C');
        reverseCodeMap.put("#?%%", 'D');reverseCodeMap.put("?%", 'E');reverseCodeMap.put("?##%", 'F');
        reverseCodeMap.put("####%", 'G');reverseCodeMap.put("%???%", 'H');reverseCodeMap.put("??%", 'I');
        reverseCodeMap.put("?#%%%", 'J');reverseCodeMap.put("#?#%", 'K');reverseCodeMap.put("%?#?%", 'L');
        reverseCodeMap.put("##%", 'M');reverseCodeMap.put("%#?", 'N');reverseCodeMap.put("###%", 'O');
        reverseCodeMap.put("?##?%", 'P');reverseCodeMap.put("##?#%", 'Q');reverseCodeMap.put("%?#", 'R');
        reverseCodeMap.put("%%%", 'S');reverseCodeMap.put("#%", 'T');reverseCodeMap.put("??#%", 'U');
        reverseCodeMap.put("%%%#", 'V');reverseCodeMap.put("%?#?", 'W');reverseCodeMap.put("#??#%", 'X');
        reverseCodeMap.put("#?##%", 'Y');reverseCodeMap.put("?##??%", 'Z');reverseCodeMap.put("#?%%%", '1');
        reverseCodeMap.put("##??%", '2');reverseCodeMap.put("###%?", '3');reverseCodeMap.put("####?", '4');
        reverseCodeMap.put("#####%", '5');reverseCodeMap.put("?####%", '6');reverseCodeMap.put("%??###", '7');
        reverseCodeMap.put("???##%", '8');reverseCodeMap.put("%???#", '9');reverseCodeMap.put("?????%", '0');

        StringBuilder result = new StringBuilder();
        String[] words = newAlphabetString.split(" ");

        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                if (reverseCodeMap.containsKey(letter)) {
                    result.append(reverseCodeMap.get(letter));
                }
                else if (word.isEmpty()) {
                    result.append(" ");
                }
            }
        }

        return result.toString().trim();
    }
}

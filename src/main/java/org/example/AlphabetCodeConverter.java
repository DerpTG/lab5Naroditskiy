package org.example;

import java.util.HashMap;

public class AlphabetCodeConverter {
    private String text;

    public AlphabetCodeConverter(String text) {
        this.text = text;
    }

    public String encrypt() {
        HashMap<Character, String> codeMap = new HashMap<>();
        // Encryption patterns with unique symbols
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

    public String decrypt(String newAlphabetString) {
        HashMap<String, Character> reverseCodeMap = new HashMap<>();
        // Decryption patterns, reverse of encryption
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
            }
            result.append(" ");
        }

        return result.toString().trim();
    }
}

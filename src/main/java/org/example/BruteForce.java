package org.example;

import java.util.Arrays;
import java.util.List;

public class BruteForce {
    private int max;
    private int min;

    private List<String> symbolList = Arrays.asList(
            "%#", "##?%", "%###?", "#?%%", "?%", "?##%", // A-F
            "####%", "%???%", "??%", "?#%%%","##?#", "%?#?%", // G-L
            "##%", "%#?", "###%", "?##?%", "##?#%", "%?#", // M-R
            "%%%", "#%", "??#%", "%%%#", "%?#?", "#??#%", // S-X
            "#?##%", "?##??%", "#?%%%", "##??%", "###%?", "####?", // Y-Z
            "#####%", "?####%", "%??###", "???##%", "%???#", "?????%" // 0-9
    );

    public BruteForce(int min, int max) {
        this.max = max;
        this.min = min;
    }

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

package org.example;

import java.util.Arrays;
import java.util.List;

public class CaeserCipherConverter {
    private int shift;
    private List<String> symbolList = Arrays.asList(
            "%#", "##?%", "%###?", "#?%%", "?%", "?##%", // A-F
            "####%", "%???%", "??%", "?#%%%","##?#", "%?#?%", // G-L
            "##%", "%#?", "###%", "?##?%", "##?#%", "%?#", // M-N
            "%%%", "#%", "??#%", "%%%#", "%?#?", "#??#%", // O-T
            "#?##%", "?##??%", "#?%%%", "##??%", "###%?", "####?", // U-Z
            "#####%", "?####%", "%??###", "???##%", "%???#", "?????%", // 0-5
            "?####%", "%??###", "???##%", "%???#", "?????%" // 6-9
    );

    public CaeserCipherConverter(int shift) {
        this.shift = shift;
    }

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
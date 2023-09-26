package Tasks_Gaudi;

import java.util.Arrays;

public class GaudiMitArraysV2 {
    public static void main(String[] args) {

        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] newAlphabet = new char[alphabet.length];
        int howMuch = -3;
        if (howMuch >= 0) {
            for (int i = 0; i < alphabet.length; i++) {
                int index = alphabet.length - howMuch + i;

                if (index >= alphabet.length) {
                    index =  i - howMuch; // index soll mit dem wert 0 beginnen + i damit sich der wert erhört - howMuch damit sich die jeweilige stelle ergibt.
                }
                newAlphabet[i] = alphabet[index];
                // X
                // Y
                // Z
                // A
                // B
            }
        } else {
            for (int i = 0; i < alphabet.length; i++) {
                int index = -howMuch + i;
                if (index >= alphabet.length) { // i = 25
                    index = i - alphabet.length - howMuch;
                }
                newAlphabet[i] = alphabet[index];
            }
        }
        System.out.println(Arrays.toString(newAlphabet));

    }
}
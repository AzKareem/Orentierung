import java.util.ArrayList;
import java.util.Random;


public class CybersecurityV1 {
    public static void main(String[] args) {

        String alphabet = "ABCabc012!";
        char[] pw = alphabet.toCharArray();
        ArrayList<String> combinations = new ArrayList<>();

        for (int i = 0; i < alphabet.length(); i++) {
            for (int j = 0; j < alphabet.length(); j++) {
                for (int k = 0; k < alphabet.length(); k++) {
                    for (int l = 0; l < alphabet.length(); l++) {
                        String combination = "" + pw[i] + pw[j] + pw[k] + pw[l];
                        combinations.add(combination);
                    }
                }
            }
        }
        Random r = new Random();
        int zufall = r.nextInt(combinations.size());
        String password = combinations.get(zufall);
        System.out.println("Password to find: " + password);
        int versuche = 0;

        ArrayList<Integer> guesses = new ArrayList<>();

            int rounds = 10;

        for (int a = 0; a < rounds; a++) {
            combination:
            {
                for (int i = 0; i < alphabet.length(); i++) {
                    for (int j = 0; j < alphabet.length(); j++) {
                        for (int k = 0; k < alphabet.length(); k++) {
                            for (int l = 0; l < alphabet.length(); l++) {
                                versuche++;
                                String guess = "" + pw[i] + pw[j] + pw[k] + pw[l];
                                if (guess.equals(password)) {
                                    System.out.println("Found it: " + password);
                                    System.out.println("Took " + versuche + " guesses");
                                    zufall = r.nextInt(combinations.size());
                                    password = combinations.get(zufall);
                                    System.out.println("Password to find: " + password);
                                    guesses.add(versuche);
                                    versuche = 0;

                                    break combination;
                                }
                            }
                        }
                    }
                }
            }
        }
        int totalGuesses = 0;
        for (int i = 0; i < guesses.size(); i++){
            totalGuesses += guesses.get(i);
        }
        int average = totalGuesses/rounds;
        System.out.println("On average took " + average + " guesses each time");
    }
}






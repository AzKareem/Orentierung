package Task_RPG;

import java.util.ArrayList;
import java.util.Scanner;

public class RPGV1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[][] choices = {
                // {parentID, ID, choiceTxt, resultTxt, moveToID }
                {"-1", "0", "", "Du stehst in einer Bar."},
                {"0", "1", "Geh in die Wildnis", "Du bist in der Wildnis angekommen."},
                {"0", "2", "Trink ein Getränk", "Du lässt dir ein Getränk schmecken", "0"},
                {"1", "3", "Kämpf gegen das Monster", "Das Monster ist ein harter Gegner, aber du besiegst es.", "1"},
                {"1", "4", "Lauf vor dem Monster davon", "Du läufst wie ein Feigling zurück zur Bar.", "0"}
        };
        ArrayList<Integer> viableChoices = new ArrayList<>();
        int currentChoice = 0;
        System.out.println(choices[0][3]);

        while (true) {
            viableChoices.clear();   // dient dazu um den die des  Arraylist zu löschen
            System.out.println("..............................");

            for (int i = 0; i < choices.length; i++) {
                int parentId = Integer.parseInt(choices[i][0]);
                if (currentChoice == parentId) {    // hier wird in der Konsole ausgegeben welche möglichkeiten ich zur auswahl habe
                    System.out.println(choices[i][1] + " " + choices[i][2]);
                    viableChoices.add(Integer.parseInt(choices[i][1]));
                }
            }
            System.out.println("..............................");
            System.out.println("Was willst du als nächstes tun?.");
            int a = sc.nextInt();

            for (int j = 0; j < choices.length; j++) {
                int id = Integer.parseInt(choices[j][1]);
                if (a == id) {
                    System.out.println(choices[j][3]);
                }
            }
            if (!viableChoices.contains(a)) {    //wird geschaut ob wir die zahl schon eingegeben haben
                System.out.println("Bitte wähle nochmal aus!");
                continue;
            } else {
                currentChoice = a;
            }
            if (choices[currentChoice].length == 5) { // ist die array länge gleich  5 => currentchoice wird den wert von movetoid erhalten
                int moveToId = Integer.parseInt(choices[currentChoice][4]);
                currentChoice = moveToId;
            }
        }
    }
}



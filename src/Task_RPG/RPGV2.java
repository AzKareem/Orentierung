package Task_RPG;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RPGV2 {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        String[][] choices = {
                // {parentID, ID, choiceTxt, resultTxt, moveToID }
                {"-1", "0", "", "Du stehst in einer Bar."},

                {"0", "1", "Geh in die Wildnis auf der Suche nach Abenteuern", "Du bist in der Wildnis angekommen. Du triffst auf ein Monster."},

                {"0", "2", "Trink ein Getränk und raste dich aus", "Du lässt dir ein Getränk schmecken", "0"},

                {"0", "3", "Beeindrucke die Prinzessin mit deinen Schätzen", "Du gibst alles!", "0"},

                {"1", "4", "Kämpf gegen das Monster", "", "6"},

                {"1", "5", "Lauf vor dem Monster davon", "Du läufst wie ein Feigling zurück zur Bar.", "0"},

                {"4", "6", "", ""},

                {"6", "7", "Versuche das Monster mit deinem Schwert zu erwischen", "Du wirfst dich in die Schlacht!", "6"},

                {"6", "8", "Es ist Zeit zu gehen", "Du versuchst zu flüchten, doch das Monster verfolgt dich.", "0"},

                {"-1", "9", "", "Deine Zeit ist leider vorüber. Der Tod erwartet dich schon mit freundlichem Grinsen"}, // TOD

                {"-1", "10", "", "Du bist der größte Held aller Zeiten! Hurra!"}, // SIEG
        };
        int min = 3;
        int max = 20;
        int min1 = 1;
        int lifeMax = 10;
        int pLife = lifeMax;
        int mLife = r.nextInt(min, max);
        int pAttack = r.nextInt(min1,pLife + 1);
        int mAttack = r.nextInt(min1, mLife);
        int pGold = 0;
        int mGold = 0;
        int difference = 0;
        int goldAmountToWin = 1000;
        int healthBar = 0;

        ArrayList<Integer> viableChoices = new ArrayList<>();
        int currentChoice = 0;
        System.out.println(choices[0][3]);
        boolean monsterDeafeated = false;
        boolean gameOver = false;
        boolean win = false;

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
            if (a == 2) {
                if (pGold >= 100) {
                    pGold -= 100;

                    int bonusHealth = 3; //pLife = 5

                    if(pLife + bonusHealth > lifeMax){
                        bonusHealth = lifeMax - pLife;
                    }

                    pLife += bonusHealth;

                    System.out.println(" Du erhälst " + bonusHealth + " Lebenspunkte und hast jetzt ingesamt " + pLife + " Lebenspunkte.");

                }
            }
            if (a == 3) {
                int lifeDifference;
                if (pGold >= 1000 && lifeMax >= 15) {
                    win = true;
                } else {
                    difference = goldAmountToWin - pGold;
                    lifeDifference = 15- lifeMax;
                    System.out.println("Sie müssen noch " + difference + " Gold und " + lifeDifference + " Lebenspunkte Sammeln.");
                }
            }
            if (a == 4) {
                mGold = r.nextInt(min1, mLife * 100);
                System.out.println(" Das Monster hat " + mLife + " Lebenspunkte und einen Damage von " + mAttack + ".");
                System.out.println(" Du hast " + pLife + " Lebenspunkte  und einen Damage von " + pAttack + " .");
                System.out.println(" Besiegst du das Monster erhälst du " + mGold + " gold");
            }

            if (a == 7) {

                mLife -= pAttack;
                if (mLife <= 0) {
                    pGold += mGold;
                    lifeMax++;
                    System.out.println("Du hast das Monster besiegt und erhälst " + mGold + " Gold als Belohnung.");
                    monsterDeafeated = true;
                } else {
                    pLife -= mAttack;
                    System.out.println(" Das Monster hat " + mLife + " Lebenspunkte und einen Damage von " + mAttack + ".");
                    System.out.println(" Du hast " + pLife + " Lebenspunkte  und einen Damage von " + pAttack + " .");
                    System.out.println(" Besiegst du das Monster erhälst du " + mGold + " gold");
                }
                if (pLife <= 0) {
                    System.out.println(" Du hast  0 Lebenskunkte.");
                    gameOver = true;
                }
            }
            if (a == 8) {
                pLife -= mAttack;
                System.out.println("Du bekommst " + mAttack + " an Schaden und hast jetzt " + pLife + " Lebenspunkte.");
                if (pLife <= 0) {
                    gameOver = true;
                }
            }
            if (gameOver) {
                a = 9;
                for (int j = 0; j < choices.length; j++) {
                    int id = Integer.parseInt(choices[j][1]);
                    if (a == id) {
                        System.out.println(choices[j][3]);
                    }
                }
                break;
            }
            if (monsterDeafeated) {
                currentChoice = 0;
                monsterDeafeated = false;
                mLife = r.nextInt(min, max);
                mGold = r.nextInt(min1, mLife * 100);
            }

            if (win) {
                a = 10;
                for (int j = 0; j < choices.length; j++) {
                    int id = Integer.parseInt(choices[j][1]);
                    if (a == id) {
                        System.out.println(choices[j][3]);
                    }
                }
                break;
            }
        }
    }
}







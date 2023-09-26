package Tasks_MuenzeWerfen;

import java.util.Random;
import java.util.Scanner;

public class MuenzeWerfenV3 {
    public static void main(String[] args) {


        Random r = new Random();
        Scanner sc = new Scanner(System.in);


        int muenze;
        int kf = 0;
        int zl = 0;

        do {
            System.out.println("Wie oft soll die Münze geworfen werden?");
            muenze = sc.nextInt();
        } while (muenze >= 10 || muenze < 1 || (muenze % 2 == 0) ) ;

            for (int a = 1; a <= muenze; a++) {
                boolean kopf = r.nextBoolean();

                if (kopf == true) {
                    System.out.println("Werfe Münze… Kopf!");
                    kf++;
                } else {
                    System.out.println("Werfe Münze… Zahl!");
                    zl++;
                }

        }
            System.out.println("Summe Kopf: " + kf);
            System.out.println("Summe Zahl: " + zl);

            if (kf == zl) {
                System.out.println("Unentschieden");
            } else if (kf > zl) {
                System.out.println("Ich bekomme das Ticket.");
            } else {
                System.out.println("Stefan bekommt das Ticket!");
            }

    }
}

package Tasks_Betrunken;

import java.util.Scanner;

public class BetrunkenV2 {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.println("Wie alt bist du?");
        int alter = sc.nextInt();
        System.out.println("hast du deinen Führerschgein dabei?");
        boolean fuehrerschein = sc.nextBoolean();
        System.out.println("Wie viel Bier hast du getrunken?");
        int bier = sc.nextInt();
        System.out.println("Wie viele shots hast du getrunken?");
        int shots = sc.nextInt();


        if(bier + shots <= 0){
            System.out.println("gar nicht betrunken");
        }
        else if(bier + shots <= 2){
            System.out.println("leicht betrunken");
        }
        else if(bier <= 6 && shots <= 0){
            System.out.println("Betrunken");
        }
        else{
            System.out.println("Hoffnungslos betrunken");
        }

        if(alter >= 17 && fuehrerschein == true && (bier + shots <= 0) ){
            System.out.println("Du darfst Auto fahren.");
        }
        else if(alter <= 19 && fuehrerschein == true && (bier + shots <= 2)){
            System.out.println("Du darfst Auto fahren.");
        }
        else{
            System.out.println("Du darfst nicht Auto fahren.");
        }





    }
}

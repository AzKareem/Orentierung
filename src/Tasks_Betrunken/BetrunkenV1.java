package Tasks_Betrunken;

import java.util.Scanner;

public class BetrunkenV1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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




    }
}

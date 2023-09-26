package Tasks_Gaudi;

import java.util.Arrays;


public class GaudiMitStatistikV1 {
    public static void main(String[] args) {

        char[] content = "Unter #Handy finden sich 6 große Anbieter, 2 davon sind aber die besten!".toCharArray();

        int Großbuchstaben = 0;
        int Kleinbuchstaben = 0;
        int Zahlen = 0;
        int SonstigeZeichen = 0;

        for (int i = 0; i < content.length; i++) {
            char c = content[i];
            if(c >= 'A' && c<= 'Z'){
//                Character.isUpperCase(c);
                Großbuchstaben++;
            }
            else if (c >= 'a' && c<= 'z'){
//                Character.isLowerCase(c);
                Kleinbuchstaben++;
            }
            else if (c >= '0' && c<= '9'){
//                Character.isDigit(c);
                Zahlen++;
            }
            else{
                SonstigeZeichen++;
            }
        }

        System.out.println("Grossbuchstaben: " + Großbuchstaben);
        System.out.println("Kleinbuchstaben: " + Kleinbuchstaben);
        System.out.println("Zahlen: " + Zahlen);
        System.out.println("SonstigeZeichen: " + SonstigeZeichen);
    }


}
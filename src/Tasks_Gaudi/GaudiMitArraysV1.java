package Tasks_Gaudi;

import java.util.Arrays;
import java.util.Random;

public class GaudiMitArraysV1 {
    public static void main(String[] args) {

        Random r = new Random();
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] b = new int[100];
        boolean[] c = new boolean[10];

        for (int x = 0; x < b.length; x++) {
            b[x] = r.nextInt(100);
            System.out.println(b[x]);
        }

        for (int i = 0; i < c.length; i++) {
            if (i % 2 == 0) {
                c[i] = true;
            }
        }
        for (int t = 0; t< c.length; t++){
            System.out.println(c[t]);
        }
//        System.out.println(Arrays.toString(c));     WIRD IN EINER ZEILE AUSGEGEBEN
    }
}

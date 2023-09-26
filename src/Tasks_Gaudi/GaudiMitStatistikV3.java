package Tasks_Gaudi;

import java.util.Arrays;

public class GaudiMitStatistikV3 {
    public static void main(String[] args) {


        int[] urliste = {11, 8, 53, 3, 6, 3,};
        int x = urliste.length;
        ;
        Arrays.sort(urliste);
        int summe = 0;


        for (int i = 0; i < urliste.length; i++) {
            summe += urliste[i];
        }
        int middleValue = summe / x;

        System.out.println(middleValue);

        int min = urliste[0];
        int max = urliste[0];
        int span = 0;

        int number = urliste[0];
        for (int j = 0; j < urliste.length; j++) {

            number = urliste[j];
            if (number < min) {
                min = number;
            } else if (number > max) {

                max = number;
            }
        }
        span = max - min;
        System.out.println(span);

        double median;
        median = (double) urliste[urliste.length / 2];

        System.out.println(median);


        int modalWert = 0;
        int modalCount = 1;
        int k = 0;

        for (int i = 0; i < urliste.length; i++) {
            k = 0;

            for (int j = 0; j < urliste.length; j++) {
                if (urliste[i] == urliste[j]) {
                 k++;
                }
                if (k > modalCount){
                    modalWert = urliste[i];
                    modalCount = k;
                }
            }
        }
        System.out.println(modalWert + " " + modalCount);



        double mad = 0;
        int absoluteValue = 0;
        int absoluteValueSum = 0;
        for (int m = 0; m < urliste.length; m++) {

           if (urliste[m] <= 11){
               absoluteValue = urliste[m] - middleValue;
               absoluteValueSum += absoluteValue*(-1);
           }
           else {
               absoluteValue = urliste[m] - middleValue;
               absoluteValueSum += absoluteValue;
           }

        }


        mad = (double) absoluteValueSum / urliste.length;
        System.out.println(mad);



    }
}

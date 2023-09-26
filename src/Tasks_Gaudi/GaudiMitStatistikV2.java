package Tasks_Gaudi;

import java.util.Random;
import java.util.Arrays;

public class GaudiMitStatistikV2 {
    public static void main(String[] args) {
        Random r = new Random();
        int[] array = new int[100];

        for (int x = 0; x < array.length; x++) {
            array[x] = r.nextInt(100);
        }
        //int[] array = {43, 13, 22, 54};
        System.out.println(Arrays.toString(array));

        /*
         * 43 -> 13
         * 13 -> 43 -> 22
         * 22 -> 43
         * 54
         */

        for(int i = 0; i < array.length; i++){
            //i = 0
            //i = 1
            //i = 2
            int number = array[i]; // i = 0 -> 43, i == 1 -> 43
            int indexForLowestNumber = i;// i = 0 -> 0, i == 1 -> 1
            int lowestNumber = number; //i = 0 -> 43, i == 1 -> 43

            for(int x = i + 1; x < array.length; x++){
                //i = 0 -> x = 1
                //i == 0 -> x = 2
                //i == 0 -> x = 3

                //i == 1 -> x = 2
                //i == 1 -> x = 3

                //i == 0 && x = 1 -> 13, i == 0 && x = 2 -> 22, i == 0 && x = 3 -> 54
                //i == 1  && x = 2 -> 22, i == 1  && x = 3 -> 54
                int nextNumber = array[x];

                if(nextNumber < lowestNumber){
                    //i == 0 && x = 1 -> 1
                    //i == 1 && x = 2 -> 2
                    indexForLowestNumber = x;

                    //i == 0 && x = 1 -> 13
                    //i == 0 && x = 2 -> 22
                    lowestNumber = nextNumber;
                }
            }
            //i == 0 -> indexForLowestNumber = 1
            //i == 0 -> lowestNumber = 13

            //i == 1 -> indexForLowestNumber = 2
            //i == 1 -> lowestNumber = 22

            array[indexForLowestNumber] = array[i];
            array[i] = lowestNumber;
        }

        System.out.println("Sorted Array = " + Arrays.toString(array));

    }

}
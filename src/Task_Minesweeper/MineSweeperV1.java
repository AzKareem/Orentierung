package Task_Minesweeper;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MineSweeperV1 {
    public static void main(String[] args) {
        Random r = new Random();
        int[][] mineSweeper = new int[10][10];
        Scanner sc = new Scanner(System.in);
        int mineCount = 0;
        String coordinate = "";
        for (int i = 0; i < mineSweeper.length; i++) {
            for (int j = 0; j < mineSweeper[i].length; j++) {
                int number = r.nextInt(3) * (-1);
                if (number == 0) {
                    mineCount++;
                }
                mineSweeper[i][j] = number;
            }
        }
        ArrayList<int[]> coordinates = new ArrayList<>();

        while (true) {
            System.out.println("Bitte geben Sie die Koordinaten ein :");
            coordinate = sc.next(); // j4

            char pointXChar = coordinate.charAt(0);
            int pointX = 0;
                pointXChar = (char) (pointX - 65);
//            if (pointXChar == 'A') {
//                pointX = 0;
//            } else if (pointXChar == 'B') {
//                pointX = 1;
//            } else if (pointXChar == 'C') {
//                pointX = 2;
//            } else if (pointXChar == 'D') {
//                pointX = 3;
//            } else if (pointXChar == 'E') {
//                pointX = 4;
//            } else if (pointXChar == 'F') {
//                pointX = 5;
//            } else if (pointXChar == 'G') {
//                pointX = 6;
//            } else if (pointXChar == 'H') {
//                pointX = 7;
//            } else if (pointXChar == 'I') {
//                pointX = 8;
//            } else if (pointXChar == 'J') {
//                pointX = 9;
//            }

            //A4 -> 'A' + '4'
            int pointY = Integer.parseInt(coordinate.charAt(1) + ""); //'4' -> '4' + "" -> "4" -> 4
            boolean exists = false; // wir schauen ob diese koordinate schon eingegeben ist

            //pointX = 8, pointY =9

            for (int i = 0; i < coordinates.size(); i++) { //[1,1], [2,3], [4, 7], [8,9]
                int[] intPoint = coordinates.get(i); //[2,3]
                if (intPoint[0] == pointX && intPoint[1] == pointY) {
                    exists = true;
                    System.out.println("Diese Koordinate haben Sie schon eingegeben.");
                    break;
                }
            }
            if (exists) {
                continue;
            }
            int[] point = new int[2];
            point[0] = pointX;
            point[1] = pointY;
            //[8, 9]

            coordinates.add(point);

            for (int i = 0; i < mineSweeper.length; i++) {
                System.out.print("   " + (char) ('A' + i));
            }

            boolean foundBomb = false;

            System.out.println();
            for (int y = 0; y < mineSweeper.length; y++) {
                System.out.print(y + " ");
                for (int x = 0; x < mineSweeper[y].length; x++) {
                    boolean isPoint = false;
                    for (int i = 0; i < coordinates.size(); i++) {
                        int[] point2 = coordinates.get(i);
                        if (point2[0] == x && point2[1] == y) {
                            isPoint = true;
                            if (mineSweeper[y][x] == 0) {
                                System.out.print("[*] ");
                                foundBomb = true;
                            } else {
                                System.out.print("[-] ");
                            }
                        }
                    }
                    if (!isPoint) {
                        System.out.print("[ ] ");
                    }
                }
                System.out.println();
            }
            System.out.println();
            int inputs = coordinates.size();
            int fieldsWithoutBombs = 100 - mineCount;
            float percentage = ((float) inputs / (float) fieldsWithoutBombs) * 100f;
            System.out.println("Du hast " + inputs + "/" + fieldsWithoutBombs + "(" + percentage + "%) des nicht verminten Gebiets auf Minen gecheckt");
            System.out.println("Es bleiben noch " + mineCount + " Minen noch übrig.");
            if (foundBomb) {
                System.out.println("Das... war eine Mine. Du hast leider verloren.");
                break;
            }
        }
    }
}
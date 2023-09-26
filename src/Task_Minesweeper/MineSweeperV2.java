package Task_Minesweeper;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MineSweeperV2 {
    public static void main(String[] args) {
        Random r = new Random();
        int[][] mineSweeper = new int[10][10];
        Scanner sc = new Scanner(System.in);
        int mineCount = 0;
        String coordinate = "";
        for (int i = 0; i < mineSweeper.length; i++) {
            for (int j = 0; j < mineSweeper[i].length; j++) {
                int number = r.nextInt(4) * (-1);
                if (number == 0) {
                    mineCount++;
                }
                mineSweeper[i][j] = number;
            }
        }
        ArrayList<int[]> coordinates = new ArrayList<>();


        boolean gameOver = false;
        while (!gameOver) {
            System.out.println("Wo willst du nach Minen suchen :");
            coordinate = sc.next(); // j4

            char pointXChar = coordinate.charAt(0);
            int pointX = 0;

            if (pointXChar == 'A') {
                pointX = 0;
            } else if (pointXChar == 'B') {
                pointX = 1;
            } else if (pointXChar == 'C') {
                pointX = 2;
            } else if (pointXChar == 'D') {
                pointX = 3;
            } else if (pointXChar == 'E') {
                pointX = 4;
            } else if (pointXChar == 'F') {
                pointX = 5;
            } else if (pointXChar == 'G') {
                pointX = 6;
            } else if (pointXChar == 'H') {
                pointX = 7;
            } else if (pointXChar == 'I') {
                pointX = 8;
            } else if (pointXChar == 'J') {
                pointX = 9;
            }

            int pointY;
            try {               //wenn wir JJ eingeben kommt eine fehlermeldung um dies zu verhindern benutzen wir die Try catch methode
                //da wird geschaut , wenn wir ein fehler haben  dann soll bei catch .... dieser code ausgeführt werden.
                pointY = Integer.parseInt(coordinate.charAt(1) + "");
            } catch (Exception e) {
                System.out.println("Bitte geben Sie eine richtige Koordinate ein!");
                continue;
            }

            if (coordinate.length() > 2) { // dient dazu das wir nicht mehr als 2 zeichen eingeben können
                System.out.println("Bitte geben Sie eine richtige Koordinate ein!");
                continue;
            }

            boolean exists = false; // wir schauen ob diese koordinate schon eingegeben ist

            //pointX = 8, pointY =9

            for (int i = 0; i < coordinates.size() && !exists; i++) { //[1,1], [2,3], [4, 7], [8,9]
                int[] intPoint = coordinates.get(i); //[2,3]
                if (intPoint[0] == pointX && intPoint[1] == pointY) {
                    exists = true;
                    System.out.println("Diese Koordinate haben Sie schon eingegeben.");
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
            int field = mineSweeper[pointY][pointX];
            if (field == 0) {
                mineSweeper[pointY][pointX] = 5;
                foundBomb = true;
            } else if (field == -1) {
                mineSweeper[pointY][pointX] = 6;

            } else if (field == -2) {

                int minX = pointX - 1;
                int maxX = pointX + 1;
                int minY = pointY - 1;
                int maxY = pointY + 1;
                if (minX < 0) {
                    minX = 0;
                }
                if (maxX > mineSweeper[0].length -1) {
                    maxX = mineSweeper[0].length - 1;
                }
                if (minY < 0) {
                    minY = 0;
                }
                if (maxY > mineSweeper.length -1) {
                    maxY = mineSweeper.length - 1;
                }
               // System.out.println(pointX + "/" + pointY + " => " + minX + "/" + minY + "..." + maxX + "/" + maxY);
                for (int nx = minX; nx <= maxX; nx++) {
                    for (int ny = minY; ny <= maxY; ny++) {
                        if (mineSweeper[ny][nx] == 0) {
                            mineSweeper[ny][nx] = 5;
                        } else {
                            mineSweeper[ny][nx] = 6;
                        }
                    }
                }

            }
            else if( field == -3){
                int minX = pointX - 2;
                int maxX = pointX + 2;
                int minY = pointY - 2;
                int maxY = pointY + 2;
                if (minX < 0) {
                    minX = 0;
                }
                if (maxX > mineSweeper[0].length -1) {
                    maxX = mineSweeper[0].length - 1;
                }
                if (minY < 0) {
                    minY = 0;
                }
                if (maxY > mineSweeper.length -1) {
                    maxY = mineSweeper.length - 1;
                }

                for (int nx = minX; nx <= maxX; nx++) {
                    for (int ny = minY; ny <= maxY; ny++) {
                        if (mineSweeper[ny][nx] == 0) {
                            mineSweeper[ny][nx] = 5;
                        } else {
                            mineSweeper[ny][nx] = 6;
                        }

                    }
                }
            }
            System.out.println();
            int discoveredMine = 0;
            int discovered = 0;
            for (int y = 0; y < mineSweeper.length; y++) {
                System.out.print(y + " ");
                for (int x = 0; x < mineSweeper[y].length; x++) {

                    if (mineSweeper[y][x] < 1) {
                        System.out.print("[   ] ");
                    }
                    else if (mineSweeper[y][x] == 5) {
                        System.out.print("[ * ] ");
                       discoveredMine++;
                    }
                    else {
                        System.out.print("[ - ] ");
                        discovered++;
                    }
                }
                System.out.println();
            }
            System.out.println();
            int inputs = coordinates.size();
            int fieldsWithoutBombs = 100 - mineCount;
            float percentage = ((float) discovered / (float) fieldsWithoutBombs) * 100f;
            System.out.println("Du hast " + (discovered) + "/" + fieldsWithoutBombs + "(" + percentage + "%) des nicht verminten Gebiets auf Minen gecheckt");
            System.out.println("Es bleiben noch " + mineCount + " Minen noch übrig.");
            if (discoveredMine == mineCount){
                System.out.println("Glückwunsch! Sie haben das Spiel gewonnen!");
                gameOver = true;
            }
            if (foundBomb) {
                System.out.println("Das... war eine Mine. Du hast leider verloren.");
                gameOver = true;
            }
        }
    }

}

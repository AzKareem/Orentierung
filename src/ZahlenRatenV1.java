import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ZahlenRatenV1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Random r = new Random();

        String[][] gameOptions = {
                {"Lvl", "1"},
                {"Lvl", "2"},
                {"Lvl", "3"}
        };

        ArrayList<Integer> typeNumbers = new ArrayList<>();

        int randomNumber = 0;
        int gameOption;
        int tries = 9;
        int typeNumber = 0;
        int difference = 0;

        for (int i = 0; i < gameOptions.length; i++) {
            String stufe = gameOptions[i][0];
            int gameLevel = Integer.parseInt(gameOptions[i][1]);
            System.out.println(stufe + " " + gameLevel);
        }

        while (true) {

            System.out.println("Welches Level möchtest du Spielen?.");
            gameOption = sc.nextInt();

            if (gameOption == 0) {
                System.out.println("Sie haben das Spiel abgebrochen!.");
                break;
            }


            else if (gameOption == 1) {
                tries = 9;
                randomNumber = r.nextInt(101);
                while (true) {
                    System.out.println("Geben Sie eine Zahl ein um es zu Erraten: ");
                    typeNumber = sc.nextInt();

                    if (typeNumber < randomNumber) {
                        System.out.println("Die Zahl die Sie finden müssen ist größer!.");
                    } else if (typeNumber > randomNumber) {
                        System.out.println("Die Zahl die Sie finden müssen ist kleiner!.");
                    } else {
                        System.out.println("Glückwunsch Sie haben die Zahl Erraten :D.");
                        break;
                    }
                    tries--;

                    if (tries == 0) {
                        System.out.println("Sie haben das Spiel verloren!");
                        break;
                    }
                }
            } else if (gameOption == 2) {
                tries = 9;
                typeNumbers.clear();
                randomNumber = r.nextInt(101);
                System.out.println("randomNumber = " + randomNumber);
                while (true) {
                    System.out.println("Geben Sie eine Zahl ein um es zu Erraten: ");
                    typeNumber = sc.nextInt();
                    typeNumbers.add(typeNumber);

                    for (int i = 0; i < typeNumbers.size(); i++) {
                        System.out.println(typeNumbers.get(i));
                    }

                    if (typeNumber == randomNumber) {
                        System.out.println("Glückwunsch Sie haben die Zahl Erraten :D.");
                        break;
                    }

                    difference = (randomNumber - typeNumber);

                    if (difference < 0) {
                        difference *= -1;
                    }

                    System.out.println("difference = " + difference);
                    if (difference > 20) {
                        System.out.println("Weit Weg, >20 daneben");
                    } else if (difference >= 11) {
                        System.out.println("Nicht ganz so weit weg, zwischen 11 und 20 daneben ");
                    } else if (difference >= 4) {
                        System.out.println("Relativ nahe, zwischen 4 und 10 daneben");
                    } else {
                        System.out.println("Fast da: zwischen 1 und 3 daneben.");
                    }
                    tries--;

                    if (tries == 0) {
                        System.out.println("Sie haben das Spiel verloren!");
                        break;
                    }

                }
            } else if (gameOption == 3) {

                randomNumber = r.nextInt(101);
                int lastNumber = -1;
                typeNumbers.clear();
                boolean myTurn = r.nextBoolean();
                int min = 0;
                int max = 100;
                System.out.println(randomNumber);


                while (true) {
                    System.out.println(min + " " + max);
                    if (myTurn) {
                        System.out.println("Geben Sie eine Zahl ein um es zu Erraten: ");
                        typeNumber = sc.nextInt();
                        lastNumber = typeNumber;
                        typeNumbers.add(typeNumber);

                        if (typeNumber < randomNumber) {
                            System.out.println("Die Zahl die Sie finden müssen ist größer!.");
                            if (typeNumber > min) {
                                min = typeNumber + 1;
                            }
                        } else if (typeNumber > randomNumber) {
                            System.out.println("Die Zahl die Sie finden müssen ist kleiner!.");
                            if (typeNumber < max){
                            max = typeNumber - 1;
                            }
                        } else {
                            System.out.println("Glückwunsch Sie haben die Zahl Erraten :D.");
                            break;
                        }

                        myTurn = false;
                    } else {

                        if (lastNumber == -1) {
                            typeNumber = r.nextInt(101);
                        } else {
                            if (typeNumber > randomNumber) {

                                typeNumber = r.nextInt(min, max);

                            } else {
                                typeNumber = r.nextInt(min, max);
                            }
                        }
                        typeNumbers.add(typeNumber);

                        System.out.println("Computer tippt auf " + typeNumber);

                        if (typeNumber < randomNumber) {
                            System.out.println("[COMPUTER]: Die Zahl die Sie finden müssen ist größer!.");
                            min = typeNumber + 1;
                        } else if (typeNumber > randomNumber) {
                            System.out.println("[COMPUTER]: Die Zahl die Sie finden müssen ist kleiner!.");
                            max = typeNumber - 1;
                        } else {
                            System.out.println("[COMPUTER]: Glückwunsch Sie haben die Zahl Erraten :D.");
                            break;
                        }
                        myTurn = true;
                    }
                    for (int i = 0; i < typeNumbers.size(); i++) {
                        System.out.print(typeNumbers.get(i) + " ");
                    }
                }
            }
        }
    }
}
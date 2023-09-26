package Tasks_Kinoverwaltung;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class KinoVerwaltungV2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        int ticketPrice = 15;
        int wallet;
        int chosenMovie = 0;
        int amountOfTickets = 0;
        int totalPrice;
        int chosenOptions;
        int chosenSnack;
        int amountOfSnacks;
        String name = "";
        double totalPriceSnacks;
        int lottoCost = 5;
        int winPrice = 25;
        boolean gewinnspiel;

        ArrayList<Integer> chosenMovies = new ArrayList<>();
        ArrayList<Integer> chosenSnacks = new ArrayList<>();

        String[][] movies = {
                {"1", "Batman", "20:15", "1", "2"},
                {"2", "Matrix", "22:00", "3", "60"},
                {"3", "Matrix 2", "17:00", "2", "0"}
        };
        String[][] kinoDaten = {
                {"1", "Ticket Kaufen"},
                {"2", "Snacks Kaufen"},
                {"3", "Film ansehen"},
                {"4", "Snacks essen"},
                {"5", "Beim Gweinnspiel mitmachen (kostet 5€)"},
                {"6", "Kino Verlassen"}
        };
        String[][] snacks = {
                {"1", "Popcorn", "1.00", "30"},
                {"2", "Chips", "2.00", "20"},
                {"3", "Schokolade", "3.50", "10"},
        };


        System.out.println("Wie viel Geld hast du mit?");
        wallet = sc.nextInt();

        if (wallet < 15) {
            System.out.println("Sie haben zu wenig Geld!.");
        } else {
            while (true) {
                for (int i = 0; i < kinoDaten.length; i++) {
                    String options = kinoDaten[i][1];
                    int chosenNumber = Integer.parseInt(kinoDaten[i][0]);
                    System.out.println("   " + chosenNumber + "  " + options);
                }
                System.out.println("Was willst du als nächstes tun?.");
                chosenOptions = sc.nextInt();

                if (chosenOptions == 0) {
                    break;
                }
                if (chosenOptions >= kinoDaten.length) {
                    System.out.println("Bitte geben Sie eine gültige Auswahl ein!.");
                    continue;
                }

                if (chosenOptions == 1) {
                    while (true) {
                        System.out.println("Filmnr   Filmname  Uhrzeit   Saal   Restplätze");
                        for (int i = 0; i < movies.length; i++) {
                            name = movies[i][1];
                            int movieNumber = Integer.parseInt(movies[i][0]);
                            String time = movies[i][2];
                            int room = Integer.parseInt(movies[i][3]);
                            int tickets = Integer.parseInt(movies[i][4]);
                            String bookOutText;
                            if (tickets <= 0) {
                                bookOutText = "ausgebucht";
                            } else {
                                bookOutText = "verfügbar";
                            }
                            System.out.println("   " + movieNumber + "     " + name + "     " + time + "     " + room + "     " + bookOutText);
                        }
                        System.out.println("Welchen Film willst du schauen?");
                        chosenMovie = sc.nextInt();

                        if (chosenMovie == 0) {
                            break;
                        }
                        if (chosenMovie >= movies.length || chosenMovie < movies.length) {
                            System.out.println("Dieser Film exestiert nicht!");
                            continue;
                        }

                        String[] movie = movies[chosenMovie - 1];
                        int tickets = Integer.parseInt(movie[4]);

                        if (tickets <= 0) {
                            System.out.println("Dieser Film ist ausgebucht!");
                            continue;
                        }
                        System.out.println("Es sind noch " + tickets + " Tickets um jeweils " + ticketPrice + " dafür verfügbar. Wie viele möchtest du kaufen?");

                        amountOfTickets = sc.nextInt();

                        if (amountOfTickets > tickets) {
                            System.out.println("So viele tickets haben wir nicht.");
                            continue;
                        }

                        totalPrice = amountOfTickets * ticketPrice;
                        if (wallet >= totalPrice) {
                            wallet -= totalPrice;
                            tickets -= amountOfTickets;
                            movie[4] = String.valueOf(tickets);
                            for (int i = 0; i < amountOfTickets; i++) {
                                chosenMovies.add(chosenMovie);
                            }
                            System.out.println("Du kaufst " + amountOfTickets + " Tickets um " + totalPrice + " € und hast jetzt noch " + wallet + " Euro ");
                        } else {
                            System.out.println("Sie haben zu wenig geld!");
                        }
                        break;
                    }
                } else if (chosenOptions == 2) {
                    double snacksPrice = 0.0;

                    while (true) {
                        System.out.println("  Nr        Snack         Preis      Auf Lager");

                        for (int i = 0; i < snacks.length; i++) {
                            String nameSnack = snacks[i][1];
                            int numberSnack = Integer.parseInt(snacks[i][0]);
                            snacksPrice = Double.parseDouble(snacks[i][2]);
                            int aufLagerSnacks = Integer.parseInt(snacks[i][3]);
                            String lager;
                            if (aufLagerSnacks <= 0) {
                                lager = "Lager ist leer";
                            } else {
                                lager = "auf Lager";
                            }
                            System.out.println("   " + numberSnack + "       " + nameSnack + "         " + snacksPrice + "        " + lager);
                        }
                        System.out.println("Welchen  Snack möchtest du kaufen? ");
                        chosenSnack = sc.nextInt();

                        if (chosenSnack == 0) {
                            break;
                        }
                        if (chosenSnack >= snacks.length) {
                            System.out.println("Diesen Snack gibt es nicht!");
                            continue;
                        }

                        String[] nameSnack = snacks[chosenSnack - 1];
                        int aufLagerSnacks = Integer.parseInt(nameSnack[3]);

                        if (aufLagerSnacks <= 0) {
                            System.out.println("Diesen Snack gibts nicht mehr auf Lager!");
                            continue;
                        }
                        System.out.println("Es sind noch " + aufLagerSnacks + " um jeweils " + snacksPrice + " Euro " + " verfügbar. Wie viele möchtest du kaufen?");

                        amountOfSnacks = sc.nextInt();
                        if (amountOfSnacks > aufLagerSnacks) {
                            System.out.println("So viel Snacks haben wir nicht.");
                            continue;
                        }
                        totalPriceSnacks = amountOfSnacks * snacksPrice;
                        if (wallet >= totalPriceSnacks) {
                            wallet -= totalPriceSnacks;
                            aufLagerSnacks -= amountOfSnacks;
                            nameSnack[3] = String.valueOf(aufLagerSnacks);
                            for (int i = 0; i < amountOfSnacks; i++) {
                                chosenSnacks.add(chosenSnack);
                            }
                            System.out.println("Du kaufst " + amountOfSnacks + " um jeweils " + totalPriceSnacks + " Euro und hast jetzt noch " + wallet + " Euro ");
                        } else {
                            System.out.println("Sie haben zu wenig geld!");
                        }
                        break;
                    }
                } else if (chosenOptions == 3) {

                    while (true) {
                        System.out.println("    Nr        Film      ");

                        for (int i = 0; i < chosenMovies.size(); i++) {
                            int numberMovie = chosenMovies.get(i);
                            String movieName = "";
                            for (int x = 0; x < movies.length; x++) {
                                int movieId = Integer.parseInt(movies[x][0]);
                                if (movieId == numberMovie) {
                                    movieName = movies[x][1];
                                }
                            }
                            System.out.println("   " + numberMovie + "      " + movieName);
                        }
                        System.out.println("Welchen Film (für den du noch ein Ticket hast) möchtest du sehen?");
                        int chosenFilm = sc.nextInt();

                        if (chosenFilm == 0) {
                            break;
                        }
                        if (!chosenMovies.contains(chosenFilm)) {
                            System.out.println("Bitte wähle nochmal aus!");
                            continue;
                        }
                        chosenMovies.remove(Integer.valueOf(chosenFilm)); //Integer.valueOf(chosenFilm) weil sonst nimmt er den Index(position) wir wollen Object löschen
                        System.out.println("Du schaust dir den Film " + chosenFilm + " an. Viel Spaß!");
                        break;
                    }
                } else if (chosenOptions == 4) {

                    while (true) {
                        System.out.println("    Nr        Snack      ");

                        for (int i = 0; i < chosenSnacks.size(); i++) {
                            int numberSnack = chosenSnacks.get(i);
                            String nameSnacks = "";

                            for (int j = 0; j < snacks.length; j++) {
                                int snackId = Integer.parseInt(snacks[j][0]);
                                if (snackId == numberSnack) {
                                    nameSnacks = snacks[j][1];
                                }
                            }
                            System.out.println("   " + numberSnack + "      " + nameSnacks);
                        }
                        System.out.println(" Welchen deiner Snacks willst du essen? ");
                        int chosenSnacks1 = sc.nextInt();
                        if (chosenSnacks1 == 0) {
                            break;
                        }
                        if (!chosenSnacks.contains(chosenSnacks1)) {
                            System.out.println("Bitte wähle nochmal aus!");
                            continue;
                        }
                        chosenSnacks.remove(Integer.valueOf(chosenSnacks1));
                        System.out.println("Du verspeist es " + chosenSnacks1 + " mal. Mjam!");
                        break;
                    }
                } else if (chosenOptions == 5) {
                    int a = 1;
                    int b = 1;
                    int c = a + b;

                    System.out.println("Willst du beim Gewinnspiel mit machen?");
                    gewinnspiel = sc.nextBoolean();

                    if (gewinnspiel) {

                        boolean gewonnen = false;

                        int x = ran.nextInt(200) + 1;
                        System.out.println("Du machst beim Gewinnspiel mit!");
                        System.out.println(" Deine Glückzahl ist : " + x);

                        if(x % 10 == 0){
                            gewonnen = true;
                        }

                        if(!gewonnen){
                            for (int i = 0; i < 10; i++) {
                                c = a + b;
                                System.out.println(a + " + " + b + " = " + c);
                                a = b;
                                b = c;
                                if (x == c) {
                                    gewonnen = true;
                                    break;
                                }
                            }
                        }

                        if(gewonnen){
                            wallet -= lottoCost;
                            wallet += winPrice;
                            System.out.println(x + " ist eine Fibonacci-Nummer oder durch 10 teilbar! Du Gewinnst 20 Euro!");
                        }else{
                            wallet -= lottoCost;
                            System.out.println(x + " ist KEINE Fibonacci-Nummer! Leider nicht gewonnen.");
                        }

                    }
                } else if (chosenOptions == 6) {
                    System.out.println("Du verlässt das Kino. Auf wiedersehen!");
                    System.exit(0);
                }
            }
        }
    }
}
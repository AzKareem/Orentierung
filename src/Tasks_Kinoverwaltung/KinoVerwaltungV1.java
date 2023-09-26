package Tasks_Kinoverwaltung;

import java.util.Scanner;

public class KinoVerwaltungV1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int ticketPrice = 15;
        int wallet;
        int chosenMovie;
        int amountOfTickets;
        int totalPrice;
        String[][] movies = {
                {"1", "Batman", "20:15", "1", "2"},
                {"2", "Matrix", "22:00", "3", "60"},
                {"3", "Matrix 2", "17:00", "2", "0"}
        };
        System.out.println("Wie viel Geld hast du mit?");
        wallet = sc.nextInt();

        if (wallet < 15) {
            System.out.println("Sie haben zu wenig geld!.");
        }
        else {
            while (true) {

                System.out.println("Filmnr   Filmname  Uhrzeit   Saal   Restplätze");
                for(int i = 0; i < movies.length; i++){
                    String name = movies[i][1];
                    int movieNumber = Integer.parseInt(movies[i][0]);
                    String time = movies[i][2];
                    int room = Integer.parseInt(movies[i][3]);
                    int tickets = Integer.parseInt(movies[i][4]);
                    String bookOutText;
                    if(tickets <= 0){
                        bookOutText = "ausgebucht";
                    }
                    else{
                        bookOutText = "verfügbar";
                    }
                    System.out.println("   " + movieNumber + "     " + name + "     " + time + "     " + room + "     " + bookOutText);
                }
                System.out.println("Welchen Film willst du schauen?");
                chosenMovie = sc.nextInt();

                if(chosenMovie == 0){
                    break;
                }
                if(chosenMovie >= movies.length){
                    System.out.println("Dieser Film exestiert nicht!");
                    continue; // sagt überspring alles und fang nochmal von vorne an
                }

                String[] movie = movies[chosenMovie-1];  // wählen von array (kontainer) den kleineren (kontainer)
                int tickets = Integer.parseInt(movie[4]); // von kleinen ( kontainer) an der stelle 4 ( tickets)

                if(tickets <= 0){
                    System.out.println("Dieser Film ist ausgebucht!");
                    continue;
                }

                System.out.println("Es sind noch " + tickets + " Tickets um jeweils " + ticketPrice + " dafür verfügbar. Wie viele möchtest du kaufen?");

                amountOfTickets = sc.nextInt();
                totalPrice = amountOfTickets * ticketPrice;
                if (wallet >= totalPrice) {
                    wallet -= totalPrice;
                    tickets -= amountOfTickets;
                    movie[4] = String.valueOf(tickets);
                    System.out.println("Du kaufst " + amountOfTickets + " Tickets um " + totalPrice + " € und hast jetzt noch " + wallet + "€");
                }
                else {
                    System.out.println("Sie haben zu wenig geld!");
                    break;
                }

            }
        }
    }
}

public class CleanThisV1 {
    public static void main(String[] args) {
        int age = 14;
        boolean access = true;
        boolean withAdult = true;
        boolean VIP = true;
        if (age >= 18) {
            System.out.println("Grünes Band");
        }
        else if (age >= 16) {
            System.out.println("Gelbes Band");
        }
        else if (age >= 4 && withAdult) {
            System.out.println("Rotes Band");
        }
        else {
            System.out.println("Kein Zutritt & kein goldenes Band dazu!");
            access = false;
        }
        if (VIP && access) {
            System.out.println("Goldenes Band dazu!");
        }
        else {
            System.out.println("Kein goldenes Band dazu!");
        }
    }
}




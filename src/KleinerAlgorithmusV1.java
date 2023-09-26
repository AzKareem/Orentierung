public class KleinerAlgorithmusV1 {
    public static void main(String[] args) {


        int a = 1;
        int b = 1;
        int c = a + b;


        for (int counter = 0; counter < 5; counter++) {
            c = a + b;
            a = b;
            b = c;
            System.out.println(a + " + " + b + " = " + c);
        }


    }

}

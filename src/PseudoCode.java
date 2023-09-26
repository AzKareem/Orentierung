public class PseudoCode {
    public static void main(String[] args) {



        int n = 17;
        boolean teiler = false;

        for(int k = 2; k < n; k++){

            if(n%k == 0){
                System.out.println("Primzahl false");
                teiler = true;
            }
        }
        if(teiler){

            System.out.println(n + " Es ist keine Primzahl");
        }
        else{
            System.out.println("Es ist eine Primzahl");
        }

    }
}

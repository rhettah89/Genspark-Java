import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class App {
    public static String guessNumber(){
        Scanner input = new Scanner(System.in);
        boolean intValidate = false;
        int randomNum = ThreadLocalRandom.current().nextInt(1, 500 + 1);
        String response = "";

        System.out.println("GUESS A NUMBER BETWEEN 1 AND 355");
        String guess = input.nextLine();

        do{
            try {
            Integer.parseInt(guess);

           intValidate = true;

           do{
               if (Integer.parseInt(guess) < randomNum) {
                   response = "TOO LOW!\nGUESS A NUMBER BETWEEN 1 AND 355";

               } else if(Integer.parseInt(guess) > randomNum) {
                   response = "TOO HIGH!\nGUESS A NUMBER BETWEEN 1 AND 355S";

               }
               System.out.println(response);
               guess = input.nextLine();
           }
           while(
                   Integer.parseInt(guess)  != randomNum);



            } catch (NumberFormatException e) {
            System.out.println("NOT A VALID ENTRY, GUESS A NUMBER");
            guess = input.nextLine();
            }
        }
        while(!intValidate);

        return response;


    }

//    public static void main(String[] args) {
//
//        System.out.println("GUESS A NUMBER BETWEEN 1 AND 355");
//
//        System.out.println(guessNumber());
//
//    }
}

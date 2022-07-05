import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class App {

    public static void guessNum(String guess, int randomNum, Scanner input){

        while (Integer.parseInt(guess) != randomNum) {

            if (Integer.parseInt(guess) < randomNum) {
                System.out.println("TOO LOW!\nGUESS A NUMBER BETWEEN 1 AND 355 \n ENTER YOUR GUESS");


            } else if(Integer.parseInt(guess) > randomNum) {
                System.out.println("TOO HIGH!\nGUESS A NUMBER BETWEEN 1 AND 355 \n ENTER YOUR GUESS");
               

            } guess = input.nextLine();
        }

        System.out.println("THATS IT! YOU WIN");
    }


    public static void result(String guess, int randomNum, Scanner input){
        try {
            Integer.parseInt(guess);
            guessNum( guess,  randomNum, input);
           
        } catch (NumberFormatException e) {
            System.out.println("NOT A VALID ENTRY, GUESS A NUMBER");
            guess = input.nextLine();

             guessNum( guess,  randomNum, input);
        } 

    }

    public static void main(String[] args) throws Exception {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 500 + 1);

        Scanner input = new Scanner(System.in);
        System.out.println("GUESS A NUMBER BETWEEN 1 AND 355 \n ENTER YOUR GUESS");
        String guess = input.nextLine();

        result(guess, randomNum, input);

    }
}

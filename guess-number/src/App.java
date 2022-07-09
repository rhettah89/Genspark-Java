import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class App {

    public static String result(String guess, int randomNum, Scanner input){
        String response = "";

        while (Integer.parseInt(guess) != randomNum) {

            if (Integer.parseInt(guess) < randomNum) {
                response = "TOO LOW!\nGUESS A NUMBER BETWEEN 1 AND 355 \n ENTER YOUR GUESS";


            } else if(Integer.parseInt(guess) > randomNum) {
                response = "TOO HIGH!\nGUESS A NUMBER BETWEEN 1 AND 355 \n ENTER YOUR GUESS";


            }
            guess = input.nextLine();
        }

        System.out.println("THAT'S IT! YOU WIN");

        return response;
    }


    public static void guessNumber(int randomNum, Scanner input){
        String guess = input.nextLine();

        try {
            Integer.parseInt(guess);
            result( guess,  randomNum, input);

        } catch (NumberFormatException e) {
            System.out.println("NOT A VALID ENTRY, GUESS A NUMBER");
            guess = input.nextLine();

             result( guess,  randomNum, input);
        }

        System.out.println();

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int randomNum = ThreadLocalRandom.current().nextInt(1, 500 + 1);

        System.out.println("GUESS A NUMBER BETWEEN 1 AND 355 \n ENTER YOUR GUESS");

        guessNumber(randomNum, input);

    }
}

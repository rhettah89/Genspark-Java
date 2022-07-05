import java.util.Scanner;

public class App {

    public static void main(String[] args)  {
        String choice;
        String result;
        Scanner input = new Scanner(System.in);

        System.out.println(
                "In front of you is a fork in the road leading to two caves. A storm is approaching so you hastily choose a path.\n Type left or right");

        do {
            choice = input.nextLine();


            switch (choice) {
                case "left":
                    result = "You come upon a friendly looking dragon. It offers you roast pig and shows you a pile of maps";

                    break;

                case "right":
                    result = "You burst into flames!";
                    break;

                default:
                    result = "You turn around in circles dazed and confused. Choose a path before the storm comes!\n Type left or right";
            }

            input.close();

            System.out.println(result);

        } while (!choice.equals("left") || choice.equals("right"));
    }
}

import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String choice;
        String result;
        Scanner input = new Scanner(System.in);

        System.out.println(
                "In front of you is a fork in the road leading to two caves. A storm is approaching so you hastily choose a path.\n Type left or right\nOr X to exit");
        choice = input.nextLine();


        if (choice.equals("left")) {
            result = "You come upon a friendly looking dragon. It offers to fly you to our destination when the storm passes";
        } else if (choice.equals("right")) {
            result = "You burst into flames!";
        } else {
            result = "Your caught in the torrential rain. Your wet, cold and miserable";
        }
        System.out.println(result);

    }}





import java.util.Scanner;

public class Main {
    Scanner input = new Scanner(System.in);
    String choice = "left";
    String result;

    boolean completed;

    public boolean chooseCave() {
        do {
            switch (choice) {
                case "left":
                    result = "You come upon a friendly looking dragon. It offers you roast pig and shows you a pile of maps";
                    completed = true;
                    break;

                case "right":
                    result = "You burst into flames!";
                    completed = true;

                    break;
                case "x":
                    result = "Your caught in the torrential rain. Your wet and miserable then you start to get cold and realize your in mortal danger.";
                    break;

                default:
                    result = "You turn around in circles dazed and confused. Choose a path before the storm comes!\n Type left or right";
            }

            System.out.println(result);
        } while (choice == "left" || choice == "false");


        return completed;
    }}
//        choice = input.nextLine();
//            switch (choice) {
//                case "left":
//                    result = "You come upon a friendly looking dragon. It offers you roast pig and shows you a pile of maps";
//
//                    break;
//
//                case "right":
//                    result = "You burst into flames!";
//                    break;
//                default:
//                    result = "You turn around in circles dazed and confused. Choose a path before the storm comes!\n Type left or right";
//            }
//
//            System.out.println(choice);
//
//        return completed;
//    }




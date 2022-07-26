import java.io.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static final int DEFAULT_BUFFER_SIZE = 8192;

    public String wordView(int l, String guess, String randomWord ){
        List<String> word_view = new ArrayList<>();



        for(int i = 0; i < l; i++){
            if(randomWord.contains(guess)){
                word_view.add( randomWord.indexOf("guess", 1), guess);
               }else{ word_view.add("_");}

     }

        return "";




    }






    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String randomWord = "";
        System.out.println("\n\nWELCOME TO HANGMAN\n\n\"+{word_view}+\"\n    |\n    |\n    |\n   ===\n\nMissed letters:\n\nGuess a letter");
        URI uri = URI.create("https://random-word-api.herokuapp.com/word");
        try (InputStream inputStream = uri.toURL().openStream()) {
            // Convert InputStream -> String
            String result = convertInputStreamToString(inputStream);
            randomWord = result.replace("\"", "").replace("[", "").replace("]", "");

            System.out.println( result.replace("\"", "").replace("[", "").replace("]", ""));
        }

        String guess = input.nextLine();




    }

    private static String convertInputStreamToString(InputStream is) throws IOException {

        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
        int length;
        while ((length = is.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }

        // Java 1.1
        //return result.toString(StandardCharsets.UTF_8.name());

        return result.toString("UTF-8");

        // Java 10
        //return result.toString(StandardCharsets.UTF_8);

    }
}
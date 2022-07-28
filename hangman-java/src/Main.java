import java.io.*;
import java.net.URI;
import java.util.*;


public class Main {
    public static final int DEFAULT_BUFFER_SIZE = 8192;

    public static String wordView(String guess, String randomWord ){
        List<String> letters = new ArrayList<>();
        String word = "";
            for(int i = 0; i < randomWord.length(); i++){
                letters.add("_");
                }
        if(randomWord.contains(guess)){
            letters.set(randomWord.indexOf(guess), guess);
        }
        for(String letter : letters){
            word = (word + letter);
        }
        System.out.println(word);
        return word;
    }

    public static String missedLetters(String randomWord, String guess){
        List<String> letters = new ArrayList<>();
        String missed = "";
        if(!randomWord.contains(guess)){
            letters.add(guess);
        }
        for(String letter : letters){
            missed = (missed + letter);
        }
        return letters.toString().replace("[", "").replace("]", "");
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String randomWord = "";
        String guess = "d";
        String space = "";
        String board = "";
        String word = wordView(guess, randomWord);
        System.out.println(word);

        URI uri = URI.create("https://random-word-api.herokuapp.com/word");
        try (InputStream inputStream = uri.toURL().openStream()) {
            String result = convertInputStreamToString(inputStream);
            randomWord = result.replace("\"", "").replace("[", "").replace("]", "");

            System.out.println( result.replace("\"", "").replace("[", "").replace("]", ""));
        }


        for(int i = 0; i < randomWord.length(); i++ ){
            space = space + " ";
            board = board + "=";
        }
        // Game Start
        System.out.println("\n\nWELCOME TO HANGMAN\n" + "+" + wordView(guess,randomWord) + "+");
        System.out.println(space+ "|\n"  + space+ "|\n"  +  space+ "|\n" + " " + board+"\n\nMissed letters: " + missedLetters(randomWord, guess) + "\n\nGuess a letter");
        guess = input.nextLine();
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
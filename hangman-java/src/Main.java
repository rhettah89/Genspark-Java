import java.io.*;
import java.net.URI;
import java.util.*;


public class Main {
    public static final int DEFAULT_BUFFER_SIZE = 8192;

    public static String wordView(String guess, String randomWord, String wordd ){
        StringBuilder word = new StringBuilder(wordd);

        for(int i = 0; i < randomWord.length(); i++){
            if(String.valueOf(word.charAt(i)) == guess){
                word.setCharAt(i, guess.toCharArray()[0]);
            }
        }
        System.out.println(word);
        return word.toString();
    }

//    public String hangman_parts( int missedletters){
//
//        if(missedletters == )
//
//
//
//        }
//    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String randomWord = "";
        String guess = "";
        String space1 = "";
        String space2 = "";
        String space3 = "";

        String board = "";
        List<String> letters = new ArrayList<>();
        List<String> guesses = new ArrayList<>();
        List<String> missedletters = new ArrayList<>();
//        List<String> person = new ArrayList<>();
        List<String> hangman = new ArrayList<>();

        String[] person = {"O", "|", "/", "\\", "*", "/", "\\" };

        List<String> word_line = new ArrayList<>();
        String word_line_string = word_line.toString().replace("[", "").replace("]", "").replace(",", "") .replace(" ", "");

        URI uri = URI.create("https://random-word-api.herokuapp.com/word");
        try (InputStream inputStream = uri.toURL().openStream()) {
            String result = convertInputStreamToString(inputStream);
            randomWord = result.replace("\"", "").replace("[", "").replace("]", "");

            System.out.println( result.replace("\"", "").replace("[", "").replace("]", ""));
        }

        for(int i = 0; i < randomWord.length(); i++){
            word_line.add("_");
            space1 = space1 + " ";
            space2 = space2 + " ";
            space3 = space3 + " ";

            board = board + "=";
        }



        for(char ch: randomWord.toCharArray()){
            letters.add(String.valueOf(ch));
        }



        // Game Start

        System.out.println("\n\nWELCOME TO HANGMAN\n");

        while(!word_line.toString().replace("[", "").replace("]", "").replace(",", "") .replace(" ", "").equals(randomWord) ){
            System.out.println("+" + word_line.toString().replace("[", "").replace("]", "").replace(",", "") .replace(" ", "")+ "+");
            System.out.println( " " + person[0] + space1 + "|\n" + person[2] + person[1] + person[3] +  space2 + "|\n" + person[5] + person[4] +  person[6] +  space3 + "|\n"  + " " + board +"\n\nMissed letters: " + missedletters.toString().replace("[", "").replace("]", "") + "\n\nGuess a letter");
            guess = input.nextLine();

            if(letters.contains(guess)){
                for(int i = 0; i < letters.size(); i++){
                    if(letters.get(i).equals(guess)){
                        word_line.set(i, guess);
                    }
                }

                for(String letter: word_line){
                    word_line_string = word_line_string + letter;
                }
            } else{missedletters.add(guess);}
            }
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
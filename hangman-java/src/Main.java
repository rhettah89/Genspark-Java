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


//        if(randomWord.contains(guess)){
//            letters.set(randomWord.indexOf(guess), guess);
//        }
//        for(Object letter : letters){
//            word = (word + letter);
//        }
        System.out.println(word);
        return word.toString();
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String randomWord = "";
        String guess = "d";
        String space = "";
        String board = "";
        List<String> letters = new ArrayList<>();
        List<String> guesses = new ArrayList<>();
        List<String> missedletters = new ArrayList<>();
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
            space = space + " ";
            board = board + "=";
        }
        for(char ch: randomWord.toCharArray()){
            letters.add(String.valueOf(ch));
        }

        // Game Start

        while(!word_line.toString().replace("[", "").replace("]", "").replace(",", "") .replace(" ", "").equals(randomWord) ){
            System.out.println("\n\nWELCOME TO HANGMAN\n" + "+" + word_line.toString().replace("[", "").replace("]", "").replace(",", "") .replace(" ", "")+ "+");
            System.out.println(space+ "|\n"  + space+ "|\n"  +  space+ "|\n" + " " + board+"\n\nMissed letters: " + missedletters.toString().replace("[", "").replace("]", "") + "\n\nGuess a letter");
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




//            if(randomWord.contains(guess)){
//
//                for(int i = 0; i < randomWord.length(); i++){
////                    if(String.valueOf(randomWord.charAt(i)) == guess){
////                        word_line.setCharAt(i, guess.toCharArray()[0]);
////                    }
//
//                }
//            }else{
//                missedletters.add(guess);
//
//            }






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
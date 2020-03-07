import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;


public class GuessMovie {
    public static void main(String[] args) throws Exception{
        //get list of movies from file
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);
        List<String> list = new ArrayList<String>();
        while(scanner.hasNextLine()){
            list.add(scanner.nextLine());
        }
        //get list length
        int listLength = list.size();
        System.out.println("There are "+ listLength + " movies:"+list);

        //get random movie from the list
        double random = Math.random()*listLength;
        int chosenIndex = (int)random;
        String chosenMovie = list.get(chosenIndex);

        //replace movie name with '_'
        char[] repeat = new char[chosenMovie.length()];
        Arrays.fill(repeat, '_');
        String coveredName = new String(repeat);

        //counting of guesses
        int guessed = 0;

        //create scanner for System.in
        Scanner systemInput = new Scanner(System.in);

        //if player win
        Boolean hasWon = false;

        //ArrayList of wrongly guessed letters
        List<Character> wrongLetters = new ArrayList<Character>();

        //allow 10 guesses
        while(guessed < 10){
            System.out.println("Your're guessing: "+coveredName);
            System.out.println("Your've guessed "+guessed + " wrong letters:"+ wrongLetters);

            System.out.println("Guess a letter: ");

            //get the input letter
            char letter = systemInput.next().charAt(0);

            //if the movie name contains the letter
            int letterIndex = chosenMovie.indexOf(letter);

            //if the letter already exist in the list
            Boolean letterAlreadyExist = coveredName.indexOf(letter)!=-1;

            if( letterIndex!=-1 && !letterAlreadyExist){

                while (letterIndex >= 0) {
                    repeat[letterIndex] = letter;
                    letterIndex = chosenMovie.indexOf(letter, letterIndex + 1);
                }
                coveredName = new String(repeat);
                if(coveredName.replace('_', ' ').equals(chosenMovie)) {
                    hasWon = true;
                    break;
                }
            } else if(letterIndex==-1) {
                wrongLetters.add(letter);
                guessed++;
            }
        }
        if(hasWon){
            System.out.println("You won! The movie is: "+ chosenMovie);
        } else {
            System.out.println("You lost:(");
        }
    }
}

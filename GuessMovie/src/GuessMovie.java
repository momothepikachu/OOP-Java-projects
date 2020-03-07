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
        int listLength = list.size();
        System.out.println("There are "+ list.size() + " movies:"+list);



        int chosenIndex = (int) Math.random()*listLength;
        String chosenMovie = list.get(chosenIndex);

        char[] repeat = new char[chosenMovie.length()];
        Arrays.fill(repeat, '_');
        String coveredName = new String(repeat);

        int guessed = 0;
        while(guessed < 10){
            System.out.println("Your're guessing: "+coveredName);
            System.out.println("Your've guessed "+guessed +" wrong letters.");
        }
    }
}

import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args){
        Boolean hasWon = false;
        int randomNumber = (int)(Math.random()*100) + 1;
        System.out.println("I have randomly chosen a number between 1 and 100");
        System.out.println("have a guess");

        int chances = 10;
        Scanner scanner = new Scanner(System.in);

        while(chances > 0){
            System.out.println("You have "+chances+" chances left. Choose:");
            int guess = scanner.nextInt();
            System.out.println("Your guess is: "+ guess);
            if(randomNumber> guess){
                System.out.println("It's greater than "+guess);
            }
            else if(randomNumber< guess){
                System.out.println("It's smaller than "+guess);
            }
            else{
                hasWon = true;
                break;
            }
            chances--;
        }
        if(hasWon){
            System.out.println("You won! The answer is "+randomNumber);
        } else {
            System.out.println("You lost... The answer is "+randomNumber);
        }
    }
}

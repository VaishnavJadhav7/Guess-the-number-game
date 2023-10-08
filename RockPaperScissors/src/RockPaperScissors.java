import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        //0 for Rock
        //1 for Paper
        //2 for Scissor

        Scanner scn = new Scanner(System.in);
        System.out.println("Welcome to the Rock Paper Scissor Game");
        System.out.println("Enter 0 for Rock , 1 for Paper , 2 for Scissor");
        int userInput = scn.nextInt();

        Random random = new Random();
        int computerInput = random.nextInt(3);

        if (userInput == computerInput){
            System.out.println("Draw");
        }
        else if (userInput == 0 && computerInput == 2 ||
                userInput == 1 && computerInput == 0 ||
                userInput == 2 && computerInput == 1) {
            System.out.println("You wins !!");

        }
        else {
            System.out.println("Computer wins !!");
        }
        //System.out.println("Computer choice :" + computerInput);
        if (computerInput == 0){
            System.out.println("Computer choice : Rock");
        }
        else if (computerInput == 1)
        {
            System.out.println("Computer choice : paper");

        }
        else if (computerInput == 2)
        {
            System.out.println("Computer choice : Scissors");
        }
    }
}

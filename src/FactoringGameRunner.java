import java.util.Scanner;
public class FactoringGameRunner {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
         System.out.print("Welcome to Avery's Factoring Game! If you want to read the rules, please type \"yes\". Skip this line if you don't want to read the rules. ");
         if (scanner.nextLine().equals("yes")){
          FactoringGame.readRules();
        }
        else
        {
            System.out.println("Alright then, let the game begin!");
            Thread.sleep(3000);
        }
        FactoringGame.factoringGameQuadratic();
        if (FactoringGame.strikes == 5){
            System.out.println("You lost the game due to having 5 strikes. Your total score is " + FactoringGame.points + " points!");
        }
        else{
            System.out.println("Yippee, you beat the game with " + FactoringGame.points + " points!");
        }
    }
}
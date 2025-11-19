import java.util.Scanner;
public class FactoringGameRunner {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
         System.out.print("Welcome to Avery's Factoring Game! If you want to read the rules, please type \"yes\". Skip this line if you don't want to read the rules. ");
         if (scanner.nextLine().equals("yes")){
          FactoringGame.readRulesQuad();
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
            Thread.sleep(3000);
            System.out.println("But it doesn't have to be over...");
            Thread.sleep(3000);
            System.out.print("Are you ready to play the cubic stage! Type \"yes\" if you are! ");
            if (scanner.nextLine().equals("yes")) {
                System.out.println("Now loading section 2... strikes and points have been reset.");
                Thread.sleep(3000);
                FactoringGame.readRulesCubic();
                FactoringGame.factoringGameCubic();
                if (FactoringGame.strikes == 5){
                    System.out.println("You lost the game due to having 5 strikes. Your total score is " + FactoringGame.points + " points!");
                    Thread.sleep(3000);
                    System.out.println("Thanks for playing!");
                }
                else {
                    System.out.println("Yippee, you beat the game with " + FactoringGame.points + " points!");
                    Thread.sleep(3000);
                    System.out.println("Thanks for playing!");
                }
            }
            else{
                System.out.println("Alright, thanks for playing!");
            }
        }
    }
}
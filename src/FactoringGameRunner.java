import java.util.Scanner;
public class FactoringGameRunner {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        // System.out.print("Welcome to Avery's Factoring Game! If you want to read the rules, please type \"yes\". Skip this line if you don't want to read the rules. ");
        // if (scanner.nextLine().equals("yes")){
        //  FactoringGame.readRules();
        //}
        //else
        //{
        //    System.out.println("Alright then, let the game begin!");
        //    Thread.sleep(1000);
        //}
        FactoringGame.quadGenerator();
    }
}
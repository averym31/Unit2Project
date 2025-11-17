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
        int points = 0;
        int strikes = 0;
        int strikesForSpecificAttempt = 0;
        int i = 0;
        while (strikes <= 5 && i <= 30){
            FactoringGame.quadGenerator();
            StringBuilder userQuad = new StringBuilder("");
            while (!(userQuad.toString().equals(FactoringGame.quadratic)) && strikes < 5){
                System.out.print("f = ");
                userQuad.append(Integer.toString(scanner.nextInt()));
                System.out.print("q = ");
                userQuad.append(Integer.toString(scanner.nextInt()));
                System.out.print("r = ");
                userQuad.append(Integer.toString(scanner.nextInt()));
                System.out.print("s = ");
                userQuad.append(Integer.toString(scanner.nextInt()));
                System.out.print("t = ");
                userQuad.append(Integer.toString(scanner.nextInt()));
                //System.out.println(userQuad.toString());
                if (!(userQuad.toString().equals(FactoringGame.quadratic))){
                    System.out.println("Wrong answer, please try again.");
                    strikes++;
                    strikesForSpecificAttempt++;
                    userQuad.setLength(0);
                }
            }
            if(strikesForSpecificAttempt == 0){
                System.out.println("Congrats! You earned 10 points for this level.");
                points = points + 10;
                i++;
            }
            else if(strikesForSpecificAttempt == 1){
                System.out.println("Congrats! You earned 5 points for this level.");
                points = points + 5;
                i++;
            }
            else if(strikesForSpecificAttempt == 2){
                System.out.println("Congrats! You earned 3 points for this level.");
                points = points + 3;
                i++;
            }
            else if(strikesForSpecificAttempt == 3){
                System.out.println("Congrats! You earned 2 points for this level.");
                points = points + 2;
                i++;
            }
            else if(strikesForSpecificAttempt == 4){
                System.out.println("Congrats! You earned 1 point for this level.");
                points = points + 1;
                i++;
            }
        }
        System.out.println("Yipee, you beat the game with " + points + " points!");
    }
}
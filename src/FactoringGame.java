import java.sql.SQLOutput;
import java.util.Scanner;
public class FactoringGame {
    public static String quadratic = "bowery";
    public static int strikes;
    public static int points;
    public static int counter = 0;

    public static void readRules() throws InterruptedException{
        System.out.println("Here are the rules:");
        Thread.sleep(3000);
        System.out.println("A quadratic equation (a^2+bx+c) will be shown, it is your responsibility to factor out this equation in a f(qx+r)(sx+t) format, with you determining both the sign and the values of each variable.");
        Thread.sleep(3000);
        System.out.println("Getting it wrong deducts potential points earned, and throughout your entire playthrough, if you get 5 strikes your game is over.");
        Thread.sleep(3000);
        System.out.println("NOTICE: Your q value will ALWAYS be either equal to or larger than your s value.");
        Thread.sleep(3000);
        System.out.println("NOTICE: if your q value and s value are equal, your r value will ALWAYS be either equal to or larger than your t value.");
        Thread.sleep(3000);
        System.out.println("With the rules out of the way, let the game begin!");
        Thread.sleep(3000);
    }

    public static int gcfSearch(int firstInt, int secondInt){
        int a = firstInt;
        int b = secondInt;
        int remainder = 1;
        if (b > a){
            int temp = b;
            b = a;
            a = temp;
        }
        if ((a % b) != 0){
            while ((a % b) != 0) {
                remainder = (a % b);
                a = b;
                b = remainder;
            }
        }
        else {
            remainder = b;
        }
        return remainder;
    }

    public static void quadGenerator(){
        int temp;
        int q = (int) (Math.random() * 2 + (double) counter /2) + 1;
        int r = (int) (Math.random() * 2 + (double) counter /2) + 1;
        int s = (int) (Math.random() * 2 + (double) counter /2) + 1;
        int t = (int) (Math.random() * 2 + (double) counter /2) + 1;
        q = q/gcfSearch(q,r);
        r = r/gcfSearch(q,r);
        s = s/gcfSearch(s,t);
        t = t/gcfSearch(s,t);
        int f = gcfSearch(q,r)*gcfSearch(s,t);
        if (s > q){
            temp = q;
            q = s;
            s = temp;

            temp = r;
            r = t;
            t = temp;
        }
        else if(s == q && t > r){
            temp = r;
            r = t;
            t = temp;
        }
        quadratic = f + "" + q + "" + r + "" + s + "" + t;
        //System.out.println(quadratic);
        System.out.println("Factor this equation: " + (f*q*s) + "x^2+" + f*((q*t) + (r*s)) + "x+" + (f*r*t));
    }

    public static void factoringGameQuadratic(){
        Scanner scanner = new Scanner(System.in);
        strikes = 0;
        points = 0;
        int strikesForSpecificAttempt = 0;
        for (int i = 0; i <= 10; i++){
            if (strikes == 5) {
                i = 10;
            } else {
                FactoringGame.quadGenerator();
            }
            StringBuilder userQuad = new StringBuilder("");
            while (!(userQuad.toString().equals(quadratic))){
                if (strikes == 5) {
                    break;
                }
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
                if (!(userQuad.toString().equals(quadratic))){
                    strikes++;
                    System.out.println("Wrong answer! You now have " + strikes + " strikes!");
                    strikesForSpecificAttempt++;
                    userQuad.setLength(0);
                }
                counter++;
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
    }
}
import java.util.Scanner;
public class FactoringGame {
    private Scanner scanner;
    public static String quadratic = "bowery";

    public FactoringGame(Scanner s) {
        this.scanner = s;
    }

    public static void readRules(){
        System.out.println("Here are the rules:");
        System.out.println("A quadratic equation (a^2+bx+c) will be shown, it is your responsibility to factor out this equation in a f(qx+r)(sx+t) format, with you determining both the sign and the values of each variable.");
        System.out.println("Getting it wrong deducts potential points earned, and throughout your entire playthrough, if you get 5 strikes your game is over.");
        System.out.println("With the rules out of the way, let the game begin!");
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
        int q = (int) (Math.random() * 3) + 1;
        int r = (int) (Math.random() * 5) + 1;
        int s = (int) (Math.random() * 3) + 1;
        int t = (int) (Math.random() * 5) + 1;
        q = q/gcfSearch(q,r);
        r = r/gcfSearch(q,r);
        s = s/gcfSearch(s,t);
        t = t/gcfSearch(s,t);
        int f = gcfSearch(q,r)*gcfSearch(s,t);
        quadratic = f + "" + q + "" + r + "" + s + "" + t;
        //System.out.println(quadratic);
        System.out.println("Factor this equation: " + (f*q*s) + "x^2+" + f*((q*t) + (r*s)) + "x+" + (f*r*t));
    }

    public static void factoringGameQuadratic(){
        // i will move most of the code in the runner to here for brevity purposes.
    }
}
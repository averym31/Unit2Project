import java.util.Scanner;
public class FactoringGame {
    public static void readRules() throws InterruptedException {
        System.out.println("Here are the rules:");
        Thread.sleep(2000);
        System.out.println("A quadratic equation (a^2+bx+c) will be shown, it is your responsibility to factor out this equation in a f(qx+r)(sx+t) format, with you determining both the sign and the values of each variable.");
        Thread.sleep(5000);
        System.out.println("Getting it wrong deducts both time and potential points earned, and if you run out of time on one of the questions, your game is over.");
        Thread.sleep(5000);
        System.out.println("The time for every question will gradually get shorter, so using a paper and pencil to write stuff down is highly recommended!");
        Thread.sleep(5000);
        System.out.println("With the rules out of the way, let the game begin!");
        Thread.sleep(2000);
    }

    public static int gcfSearch(int firstSide, int secondSide){
        int a = firstSide;
        int b = secondSide;
        if (b > a){
            int temp = b;
            b = a;
            a = temp;
        }
        int remainder = 1;
        for (int i = 0; i * (a % b) == 0; i++) {
            remainder = (a%b);
            a = b;
            b = remainder;
            System.out.println(remainder);
        }
        return remainder;
    }

    public static void quadGenerator() throws InterruptedException {

        int q = (int) (Math.random() * 3) + 1;
        int r = (int) (Math.random() * 5) + 1;
        int s = (int) (Math.random() * 3) + 1;
        int t = (int) (Math.random() * 5) + 1;
        System.out.println(q + " " + r + " " + s + " " + t);
        System.out.println("Factor this equation!: " + (q*s) + "x^2+" + ((q*t) + (r*s)) + "x+" + (r*t));
    }
}

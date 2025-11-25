import java.util.Scanner;
public class FactoringGame {
    public static String quadratic = "mrdasisthegoat";
    public static String cubic = "mrdasisNOTthegoat";
    public static int strikes;
    public static int points;
    public static int counter = 0;

    public static void readRulesQuad() throws InterruptedException{
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

    public static void readRulesCubic() throws InterruptedException{
        System.out.println("Here are the rules:");
        Thread.sleep(3000);
        System.out.println("A cubic equation (ax^3+bx^2+cx+d) will be shown, it is your responsibility to factor out this equation in a f(qx+r)(sx+t)(ux+v) format, with you determining both the sign and the values of each variable.");
        Thread.sleep(3000);
        System.out.println("Getting it wrong deducts potential points earned, and throughout your entire playthrough, if you get 5 strikes your game is over.");
        Thread.sleep(3000);
        System.out.println("NOTICE: Your q value will be greater than or equal to your s value, and your s value will be greater than or equal to your u value.");
        Thread.sleep(3000);
        System.out.println("NOTICE: depending on the combinations of q, s, or u values that are equal, your r value will be greater than equal to your t value, and your s value will be greater than or equal to your v value.");
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

    public static void cubicGenerator(){
        int temp;
        int q = (int) (Math.random() * 3) + 1;
        int r = (int) (Math.random() * 3) + 1;
        int s = (int) (Math.random() * 3) + 1;
        int t = (int) (Math.random() * 3) + 1;
        int u = (int) (Math.random() * 3) + 1;
        int v = (int) (Math.random() * 3) + 1;
        q = q/gcfSearch(q,r);
        r = r/gcfSearch(q,r);
        s = s/gcfSearch(s,t);
        t = t/gcfSearch(s,t);
        u = u/gcfSearch(u,v);
        v = v/gcfSearch(u,v);
        int f = gcfSearch(q,r)*gcfSearch(s,t)*gcfSearch(u,v);
        if (q < s){
            temp = q;
            q = s;
            s = temp;

            temp = r;
            r = t;
            t = temp;
        }
        if (s < u){
            temp = s;
            s = u;
            u = temp;

            temp = t;
            t = v;
            v = temp;
        }
        if (q < s){
            temp = q;
            q = s;
            s = temp;

            temp = r;
            r = t;
            t = temp;
        }
        if(q == s && r < t){
            temp = r;
            r = t;
            t = temp;
        }
        if(s == u && t < v){
            temp = t;
            t = v;
            v = temp;
        }
        if(q == u && r < v){
            temp = r;
            r = v;
            v = temp;
        }
        cubic = f + "" + q + "" + r + "" + s + "" + t + "" + u + "" + v;
        //System.out.println(cubic);
        System.out.println("Factor this equation: " + (f*q*s*u) + "x^3+" + f*(u*((q*t)+(r*s))+(q*s*v)) + "x^2+" + f*((r*t*u) + v*((q*t) + (r*s))) + "x+" + f*r*t*v);
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
                    System.out.println("Your current score is " + points + " points.");
                    strikesForSpecificAttempt++;
                    userQuad.setLength(0);
                }
                counter++;
            }
            if(strikesForSpecificAttempt == 0){
                System.out.println("Congrats! You earned 10 points for this level.");
                points = points + 10;
                System.out.println("Your current score is " + points + " points.");
                i++;
            }
            else if(strikesForSpecificAttempt == 1){
                System.out.println("Congrats! You earned 5 points for this level.");
                points = points + 5;
                System.out.println("Your current score is " + points + " points.");
                i++;
            }
            else if(strikesForSpecificAttempt == 2){
                System.out.println("Congrats! You earned 3 points for this level.");
                points = points + 3;
                System.out.println("Your current score is " + points + " points.");
                i++;
            }
            else if(strikesForSpecificAttempt == 3){
                System.out.println("Congrats! You earned 2 points for this level.");
                points = points + 2;
                System.out.println("Your current score is " + points + " points.");
                i++;
            }
            else if(strikesForSpecificAttempt == 4){
                System.out.println("Congrats! You earned 1 point for this level.");
                points = points + 1;
                System.out.println("Your current score is " + points + " points.");
                i++;
            }
        }
    }
    public static void factoringGameCubic() {
        Scanner scanner = new Scanner(System.in);
        strikes = 0;
        points = 0;
        int strikesForSpecificAttempt = 0;
        for (int i = 0; i <= 10; i++) {
            if (strikes == 5) {
                i = 10;
            } else {
                FactoringGame.cubicGenerator();
            }
            StringBuilder userCubic = new StringBuilder("");
            while (!(userCubic.toString().equals(cubic))) {
                if (strikes == 5) {
                    break;
                }
                System.out.print("f = ");
                userCubic.append(Integer.toString(scanner.nextInt()));
                System.out.print("q = ");
                userCubic.append(Integer.toString(scanner.nextInt()));
                System.out.print("r = ");
                userCubic.append(Integer.toString(scanner.nextInt()));
                System.out.print("s = ");
                userCubic.append(Integer.toString(scanner.nextInt()));
                System.out.print("t = ");
                userCubic.append(Integer.toString(scanner.nextInt()));
                System.out.print("u = ");
                userCubic.append(Integer.toString(scanner.nextInt()));
                System.out.print("v = ");
                userCubic.append(Integer.toString(scanner.nextInt()));
                //System.out.println(userQuad.toString());
                if (!(userCubic.toString().equals(cubic))){
                    strikes++;
                    System.out.println("Wrong answer! You now have " + strikes + " strikes!");
                    System.out.println("Your current score is " + points + " points.");
                    strikesForSpecificAttempt++;
                    userCubic.setLength(0);
                }
                counter++;
            }
            if (strikesForSpecificAttempt == 0) {
                System.out.println("Congrats! You earned 10 points for this level.");
                points = points + 10;
                System.out.println("Your current score is " + points + " points.");
                i++;
            } else if (strikesForSpecificAttempt == 1) {
                System.out.println("Congrats! You earned 5 points for this level.");
                points = points + 5;
                System.out.println("Your current score is " + points + " points.");
                i++;
            } else if (strikesForSpecificAttempt == 2) {
                System.out.println("Congrats! You earned 3 points for this level.");
                points = points + 3;
                System.out.println("Your current score is " + points + " points.");
                i++;
            } else if (strikesForSpecificAttempt == 3) {
                System.out.println("Congrats! You earned 2 points for this level.");
                points = points + 2;
                System.out.println("Your current score is " + points + " points.");
                i++;
            } else if (strikesForSpecificAttempt == 4) {
                System.out.println("Congrats! You earned 1 point for this level.");
                points = points + 1;
                System.out.println("Your current score is " + points + " points.");
                i++;
            }
        }
    }
}
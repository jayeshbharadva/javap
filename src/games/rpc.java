package games;

import java.util.Random;
import java.util.Scanner;

public class rpc {
    public static void main(String[] args) {
        Random R = new Random();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1.Rock");
            System.out.println("2.paper");
            System.out.println("3.scissor");

            int n = sc.nextInt();
            int r = R.nextInt(1,3);
            System.out.println("Computer choose:"+r);
            if (n > 3) {
                System.out.println("enter the right number");
                break;
            } else {
                if ((n == 1 && r == 2) || (n == 2 && r == 3) || (n == 3 && r == 1)) {
                    System.out.println("you won");

                }
                else if(n==r)
                {
                    System.out.println("tay");
                }
                else {
                    System.out.println("You lost");
                }
            }
        }

    }
}

package javaCodsoft;

import java.util.Scanner;

public class task1codsoft {
    public static int getrandN(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int chances = 8;
        int finals = 0;
        boolean playAgain = true;
        System.out.println("Welcome Buddy!!");
        System.out.println("Hey Buddy you have about " + chances + " chance to win the game");
        while (playAgain) {
            int rand = getrandN(0, 100);
            boolean guess = false;
            for (int i = 0; i < chances; i++) {
                System.out.println("Chances  " + (i + 1) + "   enter your guess");
                int user = sc.nextInt();
                if (user == rand) {
                    guess = true;
                    finals += 1;
                    System.out.println("You won it");
                    break;
                } else if (user > rand) {
                    System.out.println("Too high");
                } else {
                    System.out.println("Too low");
                }
            }
            if (guess == false) {
                System.out.println("Sorry buddy. you lost the chances.the number is" + rand);
            }
            System.out.println("Do you want to Play Again(y/n)");
            String pA = sc.next();
            playAgain = pA.equalsIgnoreCase("y");
        }
        System.out.println("That's it buddy, Hope you enjoyed it");
        System.out.println("Here is your Score" + finals);
    }

}

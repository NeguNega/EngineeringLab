import java.util.Scanner;

public class NumGuessingGame {
   public NumGuessingGame() {
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      int var2 = 1 + (int)(Math.random() * 100.0);
      int var3 = 7;
      boolean var4 = false;
      System.out.println("You have total of 7 rounds of guessing!GOOD LUCK");

      while(var3 > 0) {
         System.out.print("Enter you guess from 1 upto 100: ");
         int var5 = var1.nextInt();
         if (var5 > var2) {
            System.out.println("You are too high!");
         } else {
            if (var5 >= var2) {
               System.out.println("Congratulations You win! The Number is exactly " + var5);
               var4 = true;
               break;
            }

            System.out.println("You are too low!");
         }

         System.out.println(var3 - 1 + " rounds left!");
         --var3;
      }

      if (!var4) {
         System.out.print("Out of Rounds! The Number was " + var2 + ". Please play again!");
      }

   }
}

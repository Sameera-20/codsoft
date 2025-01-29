//NUMBER GAME


import java.util.Scanner;
import java.util.Random;

class Task1 
{
  public static void main(String args[]) 
  {
     Scanner s= new Scanner(System.in);
     Random rand_int= new Random();
     int rounds=0;
     int Won=0;
     while(true) 
     {
         rounds++;
         int n=rand_int.nextInt(100)+1;  
         int maxAttempts=10;  
         int attemptsLeft=maxAttempts;
         boolean result=false;
         System.out.println("Guess the number between 1 and 100.");
         while (attemptsLeft>0) 
         {
                System.out.print("Enter your guess: ");
                int userGuess=s.nextInt();
                attemptsLeft--;
                if (userGuess==n)
                {
                    result=true;
                    break;
                } 
                else if (userGuess>n)
                {
                    System.out.println("Too high.");
                }
                else 
                {
                    System.out.println("Too low.");
                }
                System.out.println("Attempts left:"+attemptsLeft);
          }

            if (result)
            {
                System.out.println("Congratulations! You guessed the number correctly.");
                Won++;
            } 
            else 
            {
                System.out.println("Sorry! You finished all your attempts."+"\n"+" The number was: "+n);
            }

            System.out.println("No.of Rounds played: "+rounds+",Rounds won: "+Won);
            System.out.print("Do you want to play another round? (yes/no): ");
            String str=s.next();
            if (!str.equalsIgnoreCase("yes"))
            {
                break;
            }
        }
        System.out.println("Thanks for playing! Final score: Rounds played="+rounds+", Rounds won="+Won);
    }
}

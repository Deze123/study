package ru.geekbrains.lesson3;

import java.util.Random;
import java.util.Scanner;

public class App
{
  public static void main(String[] args)
  {
    guessRandomNumber(); // Task 1
    guessPlants(); // Task 2
    stringFormatting(); // Task 3
  }


  public static void guessRandomNumber()
  {
    Random random = new Random();
    int rndNum = random.nextInt(10);
    Scanner inValue = new Scanner(System.in);
    int tryCount = 3;
    boolean succeed = false;

    System.out.println("Game: Guess a random number from 0 to 9");
    do
    {
      System.out.println("Input number: ");
      int guessNum = inValue.nextInt();
      if(guessNum == rndNum)
      {
        System.out.printf("Success! You guessed the number %d and a random number %d \n", rndNum, guessNum);
        succeed = true;
      }
      else
      {
        String failResult = rndNum > guessNum ? "Fail. The random number is greater than your %d.\n" : "Fail. The random number is less than your %d.\n";
        System.out.printf(failResult, guessNum);
        tryCount--;
      }

      if(tryCount == 0 || succeed)
      {
        System.out.println("Do you want to continue ? 1 - yes or 0 - no : ");
        int yesOrNo = inValue.nextInt();
        succeed = false;
        if(yesOrNo == 1)
        {
          tryCount = 3;
          System.out.println("The New Game\nIn the old game random number was " + rndNum);
          rndNum = random.nextInt(10);
        }
        else
        {
          System.out.println("See you in the next game\n");
          break;
        }
      }
    } while(tryCount > 0);
  }

  public static void guessPlants()
  {
    Random rnd = new Random();

    String[] array = {
        "apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin",
        "potato"};

    boolean debug = false;
    Scanner scanner = new Scanner(System.in);
    String guessWord = array[rnd.nextInt(array.length)];
    if(debug)
    {
      System.out.println(guessWord);
    }
    System.out.println("Selected the name of a random plant. Try to guess it: ");

    for(; ; )
    {
      String userWord = scanner.nextLine();
      if(guessWord.equals(userWord))
      {
        System.out.println("Success! You guessed the plant");
        break;
      }
      for(int index = 0; index < 15; index++)
      {
        if(index < guessWord.length() && index < userWord.length())
        {
          if(guessWord.charAt(index) == userWord.charAt(index))
          {
            System.out.print(guessWord.charAt(index));
          }
          else
          {
            System.out.print("#");
          }
        }
        else
        {
          System.out.print("#");
        }
      }
      System.out.println();
    }
  }

  public static final void stringFormatting()
  {
    String s = "Предложение   один    .     Теперь   предложение    два    Предложение    три   ";
    StringBuilder s2 = new StringBuilder();
    boolean haveDot = false;
    boolean haveSpace = false;
    for(int idx = 0; idx < s.length(); idx++)
    {
      char c = s.charAt(idx);
      for(;idx + 1 < s.length(); c = s.charAt(++idx))
      {
        if(c == '.')
          haveDot = true;
        else if(c == ' ')
          haveSpace = true;
        else
          break;
      }
      if(haveDot || (haveSpace && c >= 'А' && c <= 'Я') || idx + 1 == s.length())
      {
        s2.append('.');
        haveDot = false;
      }

      if(haveSpace)
      {
        s2.append(' ');
        haveSpace = false;
      }
      s2.append(c);
    }

    System.out.println(s2);
  }


}

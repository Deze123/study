package ru.geekbrains.lesson2_2;

import ru.geekbrains.lesson2_2.Exeptions.MyArrayDataException;
import ru.geekbrains.lesson2_2.Exeptions.MySizeArrayException;

public class Main
{
  public static void main(String[] args)
  {

    System.out.println("############################ Check Hours of working days at week ########################");
    System.out.println("Working hours remaining this week = " + DayOfWeek.getWorkingHours(DayOfWeek.WEDNESDAY));

    System.out.println("############################ Check Array data  ########################");
    String[][] arr = new String[][]{{"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}, {"1", "2", "3", "4"}};
    try
    {
      int result = checkArray(arr);
      System.out.println("Array check result summ is = " + result);
    }
    catch(MySizeArrayException e)
    {
      e.printStackTrace();
    }
    catch(MyArrayDataException e)
    {
      e.printStackTrace();
    }

  }

  public static int checkArray(String[][] arr) throws MySizeArrayException, MyArrayDataException
  {

    int count = 0;

    if(arr.length != 4)
    {
      throw new MySizeArrayException();
    }
    for(int i = 0; i < arr.length; i++)
    {
      if(arr[i].length != 4)
      {
        throw new MySizeArrayException();
      }
      for(int j = 0; j < arr[i].length; j++)
      {
        try
        {
          count = count + Integer.parseInt(arr[i][j]);
        }
        catch(NumberFormatException e)
        {
          throw new MyArrayDataException(i, j);
        }
      }

    }
    return count;
  }
}
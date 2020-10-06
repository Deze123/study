package ru.geekbrains.lesson1;

public class FirstApp
{
  public static void main(String[] args)
  {
    printSomething(); // Task 1
    calcFloatData(); // Task 3
    calcSum(10, 20); // Task 4
    negativePositiveNumber(-1); // Task 5
    negativePositiveBool(2); // Task 6
    sayMyName("Anatoliy"); // Task 7
    leap(1914); // Task 8
  }

  public static void printSomething()
  {
    System.out.println("Lesson 1");
  }

  public static void calcFloatData() // Task 3
  {
    float a = 100000f;
    float b = 20f;
    float c = 4f;
    float d = 2f;
    float calc = a * (b + (c / d));

    System.out.println(calc);
  }

  public static void calcSum(int a, int b) // Task 4
  {
    System.out.println(a + b > 20 ? "Sum greater than 20" : "Sum less than 20");
  }

  public static void negativePositiveNumber(int value) //Task 5
  {
    System.out.println(value >= 0 ? "Positive" : "Negative");
  }

  public static boolean negativePositiveBool(int val) // Task 6
  {
    if(val < 0)
    {
      System.out.println("Negative");
      return true;
    }
    else
      System.out.println("Positive");
    return false;
  }

  public static void sayMyName(String str) // Task 7
  {
    System.out.println("Hello " + str);
  }

  public static void leap(int year) // Task 8
  {
    if(isLeapYear(year))
    {
      System.out.println(year + " leap year");
    }
    else
      System.out.println(year + " not leap year");
  }

  public static boolean isLeapYear(int year)
  {
    if(year % 4 != 0)
      return false;
    else if(year % 100 != 0)
      return true;
    else if(year % 400 != 0)
      return false;
    return true;
  }

}

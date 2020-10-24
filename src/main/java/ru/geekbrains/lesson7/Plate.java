package ru.geekbrains.lesson7;

public class Plate
{
  private int food;

  public Plate(int food)
  {
    this.food = food;
  }

  public void decreaseFood(int n)
  {
    if(food - n < 0)
    {
      System.out.println("cannot be less than zero");
    }
    else
      food -= n;
  }

  public void increaseFood(int n)
  {
      food += n;
  }

  public int getFood()
  {
    return food;
  }

  public void info()
  {
    System.out.println("plate: " + food);
  }
}
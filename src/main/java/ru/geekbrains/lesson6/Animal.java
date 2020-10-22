package ru.geekbrains.lesson6;

public abstract class Animal
{
  protected double run;
  protected double jump;
  protected double swim;


  public Animal(double run, double jump, double swim)
  {
    this.run = run;
    this.jump = jump;
    this.swim = swim;
  }

  void run(double length)
  {
    info(length <= run);
  }

  void jump(double height)
  {
    info(height <= jump);
  }

  void swim(double height)
  {
    info(height <= swim);
  }

  protected void info(boolean result)
  {
    System.out.println(getClass().getSimpleName() + " : " + result);
  }
}

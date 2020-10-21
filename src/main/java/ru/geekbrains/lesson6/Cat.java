package ru.geekbrains.lesson6;

public class Cat extends Animal
{

  public Cat(double run, double jump, double swim)
  {
    super(run, jump, swim);
  }

  @Override
  void swim(double height)
  {
    info(false);
  }
}

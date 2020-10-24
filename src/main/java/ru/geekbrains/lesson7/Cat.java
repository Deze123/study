package ru.geekbrains.lesson7;


public class Cat
{
  private final String name;
  private final int     appetite;
  private       boolean hungry;

  public Cat(String name, int appetite, boolean hungry)
  {
    this.name = name;
    this.appetite = appetite;
    this.hungry = hungry;
  }

  public String getName()
  {
    return name;
  }

  public int getAppetite()
  {
    return appetite;
  }

  public boolean isHungry()
  {
    return hungry;
  }

  public void eat(Plate p)
  {
    if(p.getFood() >= getAppetite())
    {
      p.decreaseFood(appetite);
      hungry = false;
    }
    else
      hungry = true;
  }

  protected void info(boolean result)
  {
    System.out.println("Cat well-fed" + " " + this.getName() + " : " + result);
  }

}
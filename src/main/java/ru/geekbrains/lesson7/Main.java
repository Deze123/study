package ru.geekbrains.lesson7;

public class Main
{
  public static void main(String[] args)
  {
    Cat barsik = new Cat("Barsik", 105, true);
    Cat murzik = new Cat("Murzik", 105, true);
    Plate plate = new Plate(0);
    Cat[] arr = {barsik, murzik};

    // Drop food
    plate.increaseFood(200);
    // do eat
    for(Cat cat : arr)
    {
      cat.eat(plate);
      String nameString = " " + cat.getName();
      String isHungry = (cat.isHungry()) ? "true" : "false";
      System.out.println(nameString + " is hungry " + isHungry);
    }

    // info plate
    plate.info();
  }
}

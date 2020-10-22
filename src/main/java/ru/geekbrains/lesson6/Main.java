package ru.geekbrains.lesson6;

public class Main
{

  public static void main(String[] args)
  {
    Dog dog = new Dog(500, 0.5, 10);
    Dog dog2 = new Dog(600, 0.5, 10);
    Cat cat = new Cat(200, 2, 0);


    cat.run(200);
    cat.jump(2);
    cat.swim(0);

    dog.jump(0.5);
    dog.run(500);
    dog.swim(10);

    dog2.jump(0.5);
    dog2.run(700);
    dog2.swim(10);
  }

}

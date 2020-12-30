package ru.geekbrains.lesson2_2.Exeptions;

public class MySizeArrayException extends RuntimeException
{
  public MySizeArrayException()
  {
    super("Incorrect array size ! Must be 4x4");
  }
}
package ru.geekbrains.lesson2_2.Exeptions;

public class MyArrayDataException extends RuntimeException
{
  public int i, j;

  public MyArrayDataException(int i, int j)
  {
    super("Incorrect array data (must be digital only). You have incorrect data at : row " + i + ", column " + j);
    this.i = i;
    this.j = j;
  }
}
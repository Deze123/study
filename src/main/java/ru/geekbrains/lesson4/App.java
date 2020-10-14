package ru.geekbrains.lesson4;

import java.util.Random;
import java.util.Scanner;

public class App
{
  public static final char DOT_X     = 'X';
  public static final char DOT_O     = 'O';
  public static final char DOT_EMPTY = '•';
  public static int SIZE      = 5;
  public static int DOTS_TO_WIN = 4;
  public static Random   rnd     = new Random();
  public static char[][] map;
  public static Scanner  scanner = new Scanner(System.in);

  public static void main(String[] args)
  {
    initMap();
    printMap();
    while(true)
    {
      humanTurn();
      printMap();
      if(checkWin(DOT_X))
      {
        System.out.println("Human Win!");
        break;
      }
      if(isMapFull())
      {
        System.out.println("Tie");
        break;
      }
      aiTurn();
      printMap();
      if(checkWin(DOT_O))
      {
        System.out.println("AI Win!");
        break;
      }
      if(isMapFull())
      {
        System.out.println("Tie");
        break;
      }
    }
    System.out.println("Game Over");
  }

  private static boolean checkWin(char symb)
  {
    for(int i = 0; i < SIZE; i++)
    {
      for(int j = 0; j < SIZE; j++)
      {
        if(lineCheck(i, j, 0, 1, symb))
        {
          return true;
        }
        if(lineCheck(i, j, 1, 1, symb))
        {
          return true;
        }
        if(lineCheck(i, j, 1, 0, symb))
        {
          return true;
        }
        if(lineCheck(i, j, -1, 1, symb))
        {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean lineCheck(int y, int x, int vectorY, int vectorX, char symb)
  {
    int wayX = x + (DOTS_TO_WIN - 1) * vectorY;
    int wayY = y + (DOTS_TO_WIN - 1) * vectorX;
    if(wayX < 0 || wayY < 0 || wayX > SIZE - 1 || wayY > SIZE - 1)
      return false;
    for(int i = 0; i < DOTS_TO_WIN; i++)
    {
      int pointY = y + i * vectorY;
      int pointX = x + i * vectorX;
      if(map[pointY][pointX] != symb)
        return false;
    }
    return true;
  }

  public static boolean isMapFull()
  {
    for(int i = 0; i < SIZE; i++)
    {
      for(int j = 0; j < SIZE; j++)
      {
        if(map[i][j] == DOT_EMPTY)
          return false;
      }
    }
    return true;
  }

  public static void aiTurn()
  {
    int x, y;
    do
    {
      x = rnd.nextInt(SIZE);
      y = rnd.nextInt(SIZE);
    } while(!isCellValid(x, y));
    System.out.println("AI goes to point " + (x + 1) + " " + (y + 1));
    map[y][x] = DOT_O;
  }

  public static void humanTurn()
  {
    int x, y;
    do
    {
      System.out.println("Enter coordinates in X Y format");
      x = scanner.nextInt() - 1;
      y = scanner.nextInt() - 1;
    } while(!isCellValid(x, y));
    map[y][x] = DOT_X;
  }

  public static boolean isCellValid(int x, int y)
  {
    if(x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
    return map[y][x] == DOT_EMPTY;
  }

  public static void initMap()
  {
    map = new char[SIZE][SIZE];
    for(int i = 0; i < SIZE; i++)
    {
      for(int j = 0; j < SIZE; j++)
      {
        map[i][j] = DOT_EMPTY;
      }
    }
  }

  public static void printMap()
  {
    for(int i = 0; i <= SIZE; i++)
    {
      System.out.print(i + " ");
    }
    System.out.println();
    for(int i = 0; i < SIZE; i++)
    {
      System.out.print((i + 1) + " ");
      for(int j = 0; j < SIZE; j++)
      {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }
}

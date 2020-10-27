package ru.geekbrains.lesson8;

public class Main
{

  public static void main(String[] args)
  {
    int lineX = 5;
    int lineY = 5;
    int init = 1;
    int step1 = 1;
    int step2 = 1;
    int[][] arr = new int[lineX][lineY];

    for(int y = 0; y < lineY; y++)
    {
      arr[0][y] = init;
      init++;
    }

    for(int x = 1; x < lineX; x++)
    {
      arr[x][lineY - 1] = init;
      init++;
    }

    for(int y = lineY - 2; y >= 0; y--)
    {
      arr[lineX - 1][y] = init;
      init++;
    }

    for(int x = lineX - 2; x > 0; x--)
    {
      arr[x][0] = init;
      init++;
    }

    while(init < lineX * lineY)
    {
      while(arr[step1][step2 + 1] == 0)
      {
        arr[step1][step2] = init;
        init++;
        step2++;
      }

      while(arr[step1 + 1][step2] == 0)
      {
        arr[step1][step2] = init;
        init++;
        step1++;
      }

      while(arr[step1][step2 - 1] == 0)
      {
        arr[step1][step2] = init;
        init++;
        step2--;
      }

      while(arr[step1 - 1][step2] == 0)
      {
        arr[step1][step2] = init;
        init++;
        step1--;
      }
    }

    for(int x = 0; x < lineX; x++)
    {
      for(int y = 0; y < lineY; y++)
      {
        if(arr[x][y] == 0)
        {
          arr[x][y] = init;
        }
      }
    }

    for(int x = 0; x < lineX; x++)
    {
      for(int y = 0; y < lineY; y++)
      {
        System.out.print(arr[x][y] + " ");
      }
      System.out.println();
    }
  }
}

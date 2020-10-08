package ru.geekbrains.lession2;

import java.util.Arrays;

public class App
{
  public static void main(String... args)
  {
    // task 1
    invertArray();
    // task 2
    zeroArrayMov();
    // task 3
    mulMoreSixArray();
    // task 4
    fillDiagonal();
    // task 5
    findMinMaxNum();
    // task 6
    System.out.println(checkBalance(new int[]{1, 1, 1, 3}));
    // task 7
    System.out.println(Arrays.toString(moveElements((new int[]{1 ,2 ,3 ,4, 5}), 2)));
  }


  public static void invertArray()
  {
    byte[] zeroOneArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

    for(int idx = 0; idx < zeroOneArray.length; idx++)
    {
      switch(zeroOneArray[idx])
      {
      case 0:
        zeroOneArray[idx] = 1;
        break;
      case 1:
        zeroOneArray[idx] = 0;
        break;
      }
    }
    System.out.println(Arrays.toString(zeroOneArray));
  }

  public static void zeroArrayMov()
  {
    int[] zeroArray = new int[8];
    for(int index = 1, counter = 0; index < zeroArray.length; index++)
    {
      zeroArray[index] = counter += 3;
    }
    System.out.println(Arrays.toString(zeroArray));
  }

  public static void mulMoreSixArray()
  {
    int[] array = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    for(int index = 0; index < array.length; index++)
    {
      if(array[index] < 6)
      {
        array[index] *= 2;
      }
    }
    System.out.println(Arrays.toString(array));
  }

  public static void fillDiagonal()
  {
    int[][] table = new int[10][10];
    for(int i = 0; i < table[0].length; i++)
    {
      for(int j = 0; j < table[1].length; j++)
      {
        if(i == j)
        {
          table[i][j] = 1;
        }
        else
          table[i][j] = 0;

        System.out.print(table[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void findMinMaxNum()
  {
    int[] table = new int[] {-1, -10, -11, -65000, -12, -100, -4, -112};
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for(int index = 0; index < table.length; index++)
    {
      if(table[index] > max)
      {
        max = table[index];
      }
      if(table[index] < min)
      {
        min = table[index];
      }
    }
    System.out.println("Max Number = " + max + "\n" + "Min Number = " + min);
  }

  public static boolean checkBalance(int[] array)
  {
    long leftSum = 0;
    for(int leftIndex = 0; leftIndex < array.length; leftIndex++)
    {
      long rightSum = 0;
      leftSum += array[leftIndex];
      for(int rightIndex = leftIndex + 1; rightIndex < array.length; rightIndex++)
      {
        rightSum += array[rightIndex];
      }
      if(leftSum == rightSum)
        return true;
    }
    return false;
  }

  public static int[] moveElements(int[] arr, int n)
  {
    //int[] arr = new int[]{1, 2, 3, 4, 5, 6};
    //int n = -1;

    if(n > 0)
    {
      for(int index = arr.length - 1; index >= 0; index--)
      {
        arr[index] = index - n >= 0 ? arr[index - n] : 0;
      }
    }
    else
    {
      for(int index = 0; index < arr.length; index++)
      {
        arr[index] = index - n < arr.length ? arr[index - n] : 0;
      }
    }
    return arr;
  }



  // example while > for 
  private static final void forLoopMethod()
  {
    {
      // for (int i = 0; i < 3; i++) {
      int i = 0; // ext_init
      while(i < 3)
      { // ext_cond
        op_external:
        {
          // for(int j = 0; j < 3; j++) {
          int j = 0; // int_init
          while(j < 3) // int_cond
          {
            op_internal:
            {
              System.out.print(" " + i + j);
            }
            j++; // int_it
          }
          //}
        }
        i++; // ext_it
      }
      // }
    }
  }

}

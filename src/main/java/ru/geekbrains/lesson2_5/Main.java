package ru.geekbrains.lesson2_5;

public class Main
{

  private static final int SIZE      = 10000000;
  private static final int HALF_SIZE = SIZE / 2;

  public static void main(String[] s)
  {
    Main m = new Main();
    m.launchSoloThread();
    m.launchDuoThread();
  }

  public float[] calculate(float[] arr)
  {
    for(int i = 0; i < arr.length; i++)
    {
      arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
    }
    return arr;
  }

  public void launchSoloThread()
  {
    float[] arr = new float[SIZE];
    for(int i = 0; i < arr.length; i++) arr[i] = 1.0f;
    long a = System.currentTimeMillis();
    calculate(arr);
    System.out.println("Solo Thread end with: " + (System.currentTimeMillis() - a));
  }

  public void launchDuoThread()
  {
    float[] array = new float[SIZE];
    float[] array1 = new float[HALF_SIZE];
    float[] array2 = new float[HALF_SIZE];
    for(int i = 0; i < array.length; i++) array[i] = 1.0f;

    long a = System.currentTimeMillis();
    System.arraycopy(array, 0, array1, 0, HALF_SIZE);
    System.arraycopy(array, HALF_SIZE, array2, 0, HALF_SIZE);

    new Thread()
    {
      public void run()
      {
        float[] a1 = calculate(array1);
        System.arraycopy(a1, 0, array1, 0, a1.length);
      }
    }.start();

    new Thread()
    {
      public void run()
      {
        float[] a2 = calculate(array2);
        System.arraycopy(a2, 0, array2, 0, a2.length);
      }
    }.start();

    System.arraycopy(array1, 0, array, 0, HALF_SIZE);
    System.arraycopy(array2, 0, array, HALF_SIZE, HALF_SIZE);
    System.out.println("Duo Threads end with: " + (System.currentTimeMillis() - a));
  }


}
package ru.geekbrains.lesson2_2;

public enum DayOfWeek
{
  MONDAY(8),
  TUESDAY(8),
  WEDNESDAY(8),
  THURSDAY(8),
  FRIDAY(8),
  SATURDAY(0),
  SUNDAY(0);

  private final int workHours;

  DayOfWeek(int hour)
  {
    this.workHours = hour;
  }

  public int getWorkHours()
  {
    return workHours;
  }

  public static int getWorkingHours(DayOfWeek dayOfWeek)
  {
    int result = 0;
    DayOfWeek[] values = DayOfWeek.values();
    for(int i = dayOfWeek.ordinal(); i < values.length; i++)
    {
      result += values[i].getWorkHours();
    }
    return result;
  }
}

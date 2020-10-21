package ru.geekbrains.lesson5;


public class App
{
  public static void main(String[] args)
  {
    Employee[] persArray = new Employee[]{
        new Employee("0Ivanov Ivan", "Engineer", "0ivivan@mailbox.com", "892312311", 10000, 20),
        new Employee("1vanov Ivan", "Engineer", "1ivivan@mailbox.com", "892312312", 20000, 30),
        new Employee("2vanov Ivan", "Engineer", "2ivivan@mailbox.com", "892312313", 30000, 40),
        new Employee("3vanov Ivan", "Engineer", "3ivivan@mailbox.com", "892312314", 40000, 50),
        new Employee("4vanov Ivan", "Engineer", "4ivivan@mailbox.com", "892312315", 50000, 60),
    };

    for(int i = 0; i < persArray.length; i++)
    {
      if(persArray[i].getAge() > 40)
      {
        persArray[i].info();
      }
    }
  }

}

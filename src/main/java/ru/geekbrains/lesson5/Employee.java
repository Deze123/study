package ru.geekbrains.lesson5;

class Employee
{
  private String name;
  private String position;
  private String email;
  private String phoneNumber;
  private int    salary;
  private int    age;

  public Employee(String name, String position, String email, String phoneNumber, int salary, int age)
  {
    this.name = name;
    this.position = position;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.salary = salary;
    this.age = age;
  }


  public String getName()
  {
    return name;
  }

  public Employee setName(String name)
  {
    this.name = name;
    return this;
  }

  public String getPosition()
  {
    return position;
  }

  public Employee setPosition(String position)
  {
    this.position = position;
    return this;
  }

  public String getEmail()
  {
    return email;
  }

  public Employee setEmail(String email)
  {
    this.email = email;
    return this;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public Employee setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
    return this;
  }

  public int getSalary()
  {
    return salary;
  }

  public Employee setSalary(int salary)
  {
    this.salary = salary;
    return this;
  }

  public int getAge()
  {
    return age;
  }

  public Employee setAge(int age)
  {
    this.age = age;
    return this;
  }

  //  name = name;
//      this.position = position;
//      this.email = email;
//      this.phoneNumber = phoneNumber;
//      this.salary = salary;
//      this.age = age;
  public void info()
  {
    System.out.println(name + " " + position + " " + email + " " + phoneNumber + " " + salary + " " + age);
  }

  @Override
  public String toString()
  {
    return "Employee{" +
           "name='" + name + '\'' +
           ", position='" + position + '\'' +
           ", email='" + email + '\'' +
           ", phoneNumber='" + phoneNumber + '\'' +
           ", salary=" + salary +
           ", age=" + age +
           '}';
  }
}

package ru.geekbrains.lesson2_3;

import java.util.HashMap;

public class Main
{
  public static void main(String[] args)
  {
    String[] towns = new String[]{
        "Russia",
        "France",
        "Germany",
        "Germany",
        "Norway",
        "Moscow",
        "Paris",
        "Berlin",
        "Berlin",
        "Oslo"
    };

    HashMap<String, Integer> uniqueTown = new HashMap<>();
    for(String s : towns)
    {
      Integer result = uniqueTown.get(s);
      uniqueTown.put(s, result == null ? 1 : result + 1);
    }

    System.out.println(uniqueTown + "\n");

    // Phonebook
    Phonebook book = new Phonebook();
    // Create contacts
    book.addContact("Анатолий", "12345");
    book.addContact("Женя", "123456");
    book.addContact("Рома", "1234567");
    book.addContact("Артем", "12345678");
    book.addContact("Аня", "123456789");

    // Try to find contact
    book.findAndPrint("Анатолий");


  }
}

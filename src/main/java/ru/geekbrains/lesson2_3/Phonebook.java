package ru.geekbrains.lesson2_3;

import java.util.HashMap;
import java.util.HashSet;

public class Phonebook
{
  HashMap<String, HashSet<String>> pb;

  public Phonebook()
  {
    this.pb = new HashMap<>();
  }

  public void addContact(String name, String phone)
  {
    HashSet<String> book = pb.getOrDefault(name, new HashSet<>());
    book.add(phone);
    pb.put(name, book);
  }

  public void findAndPrint(String name)
  {
    System.out.println("Contact Name is " + name + " and Phone number is " + pb.getOrDefault(name, new HashSet<>()));
  }
}
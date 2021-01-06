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

  public void addContact(String lastName, String phone)
  {
    HashSet<String> book = pb.getOrDefault(lastName, new HashSet<>());
    book.add(phone);
    pb.put(lastName, book);
  }

  public void findAndPrint(String lastname)
  {
    System.out.println("Contact Last Name is " + lastname + " and Phone number is " + pb.getOrDefault(lastname, new HashSet<>()));
  }
}
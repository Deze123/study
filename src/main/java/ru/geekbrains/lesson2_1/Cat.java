package ru.geekbrains.lesson2_1;

public class Cat extends Animal {
    int age;

    public Cat(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    void info() {
        System.out.println("Cat " + name + " " + age);
    }
}

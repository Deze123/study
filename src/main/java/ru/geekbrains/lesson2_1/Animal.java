package ru.geekbrains.lesson2_1;

public abstract class Animal {

    protected String name;

    public Animal(String name) {
        this.name = name;
    }

//    abstract void calc();

    void info() {
        System.out.println("Animal " + name);
    }
}

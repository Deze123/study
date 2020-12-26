package ru.geekbrains.lesson2_1.Marathon;

public class Main {
    public static void main(String[] args) {
        Competitor[] competitors = {new Human("Bob"), new Cat("Barsik"), new Dog("Bobik")};
        Obstacle[] course = {new Cross(70), new Wall(2), new Water(20)};

        for (Competitor c : competitors) {
            for (Obstacle o : course) {
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }

        for (Competitor c : competitors) {
            c.info();
        }
    }
}

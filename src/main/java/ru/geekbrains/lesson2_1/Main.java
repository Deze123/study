package ru.geekbrains.lesson2_1;

import ru.geekbrains.lesson2_1.Marathon.Competitor;
import ru.geekbrains.lesson2_1.Marathon.Course;
import ru.geekbrains.lesson2_1.Marathon.Cross;
import ru.geekbrains.lesson2_1.Marathon.Dog;
import ru.geekbrains.lesson2_1.Marathon.Human;
import ru.geekbrains.lesson2_1.Marathon.Cat;
import ru.geekbrains.lesson2_1.Marathon.Obstacle;
import ru.geekbrains.lesson2_1.Marathon.Team;
import ru.geekbrains.lesson2_1.Marathon.Wall;
import ru.geekbrains.lesson2_1.Marathon.Water;

public class Main {
    public static void main(String[] args) {

        Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")};
        Obstacle[] obstacles = {new Cross(400), new Wall(2), new Water(1)};

        Team team = new Team("Winners", competitors);

        System.out.println("################# setup new team ################");
        System.out.println(team.getTeamName());

        System.out.println("################# greeting team members #################");
        team.showResults();

        //
        Course course = new Course(obstacles);

        System.out.println("################# team go to course #################");
        course.doIt(team);

        System.out.println("################# show results #################");
        team.showResults();

        System.out.println("################# team finish #################");
        team.showMembersFinishedCourse();
    }
}
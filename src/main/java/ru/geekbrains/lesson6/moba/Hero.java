package ru.geekbrains.lesson6.moba;


import java.util.Random;

abstract class Hero
{

  protected int    health;
  protected String name;
  protected int    damage;

  public Hero(int health, String name, int damage)
  {
    this.health = health;
    this.name = name;
    this.damage = damage;
  }

  abstract void hit(Hero whom);

  abstract void healing(Hero whom);

  void causeDamage(int damage)
  {
    if(isAlive())
    {
      health -= damage;
    }
    else
    {
      System.out.println("Герой уже мертвый!");
    }
  }

  public boolean isAlive()
  {
    return health > 0;
  }

  public int getHealth()
  {
    return health;
  }

  void addHealth(int health)
  {
    this.health += health;
  }

  void info()
  {
    System.out.println(name + " " + (health < 0 ? "Герой мертвый" : health) + " " + damage);
  }

  boolean canHeal()
  {
    return false;
  }

  boolean canHit()
  {
    return false;
  }
}

class Warrior extends Hero
{

  public Warrior(int health, String type, int damage)
  {
    super(health, type, damage);
  }

  @Override
  void hit(Hero hero)
  {
    if(hero != this)
    {
      if(health < 0)
      {
        System.out.println("Герой погиб и бить не может!");
      }
      else
      {
        hero.causeDamage(damage);
      }
      System.out.println(this.name + " нанес урон " + hero.name);
    }
  }

  @Override
  boolean canHit()
  {
    return true;
  }

  @Override
  void healing(Hero hero)
  {
    System.out.println("Войны не умеют лечить!");
  }
}

class Assasin extends Hero
{

  int    cricitalHit;
  Random random = new Random();

  public Assasin(int heal, String name, int damage)
  {
    super(heal, name, damage);
    this.cricitalHit = random.nextInt(20);
  }

  @Override
  void hit(Hero hero)
  {
    if(hero != this)
    {
      if(health < 0)
      {
        System.out.println("Герой погиб и бить не может!");
      }
      else
      {
        hero.causeDamage(damage + cricitalHit);
      }
      System.out.println(this.name + " нанес урон " + hero.name);
    }
  }

  @Override
  boolean canHit()
  {
    return true;
  }

  @Override
  void healing(Hero hero)
  {
    System.out.println("Убийцы не умеют лечить!");
  }
}

class Doctor extends Hero
{
  protected int    addHeal;

  public Doctor(int heal, String name, int addHeal)
  {
    super(heal, name, 0);
    this.addHeal = addHeal;
  }

  @Override
  void hit(Hero hero)
  {
    System.out.println("Доктор не может бить!");
  }

  @Override
  void healing(Hero hero)
  {
    if(!hero.isAlive())
    {
      System.out.println(name + " воскресил " + hero.name);
    }
    System.out.println(name + " захилил " + hero.name);
    hero.addHealth(addHeal);
  }

  @Override
  boolean canHeal()
  {
    return true;
  }
}

class Team {
  Warrior warrior;
  Assasin assasin;
  Doctor doctor;

  public Team(Warrior warrior, Assasin assasin, Doctor doctor)
  {
    this.warrior = warrior;
    this.assasin = assasin;
    this.doctor = doctor;
  }

  public Hero[] getMembers()
  {
    return new Hero[]{warrior, assasin, doctor};
  }

  public boolean isLoose()
  {
    return !warrior.isAlive() && !assasin.isAlive() && !doctor.isAlive();
  }

  public void step(int heroIdx, Team enemyTeam)
  {
    Random r = new Random();
    Hero who = getMembers()[heroIdx];
    if(!who.isAlive())
      return;
    if(who.canHit())
    {
      Hero enemy = enemyTeam.getMembers()[r.nextInt(enemyTeam.getMembers().length)];
      if(!enemy.isAlive())
        return;
      who.hit(enemy);
    }
    if(who.canHeal())
    {
      Hero whom = getMembers()[r.nextInt(getMembers().length)];
      who.healing(whom);
    }
  }

}

class Game
{
  public static void main(String[] args)
  {

    Random randomStep = new Random();

    Team team1 = new Team(
        new Warrior(250, "Тигрил", 50),
        new Assasin(150, "Акали", 70),
        new Doctor(120, "Жанна", 60)
    );
    Team team2 = new Team(
        new Warrior(290, "Минотавр", 60),
        new Assasin(160, "Джинкс", 90),
        new Doctor(110, "Зои", 80)
    );


    while(!team1.isLoose() && !team2.isLoose())
    {
      for(int heroIdx = 0; heroIdx < 3; heroIdx++)
      {
        if(randomStep.nextInt(2) == 0)
        {
          team1.step(heroIdx, team2);
        }
        else
        {
          team2.step(heroIdx, team1);
        }
      }
    }
    System.out.println("---------------");


    System.out.println("Team1 " + (team1.isLoose() ? "проиграла" : "выиграла"));
    for(Hero t1 : team1.getMembers())
    {
      t1.info();
    }


    System.out.println("Team2 " + (team2.isLoose() ? "проиграла" : "выиграла"));
    for(Hero t2 : team2.getMembers())
    {
      t2.info();
    }

  }

}
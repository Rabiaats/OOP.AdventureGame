package SelfStudy.AdventureGame;

public class Obstacle {
    private String name;
    private int id;
    private int damage;
    private int health;
    private int money;
    private int number;

    public Obstacle(String name, int id, int damage, int health, int money, int number) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public static int obstacleNumber(){
        return (int) ((Math.random() * 3) + 1);
    }
}

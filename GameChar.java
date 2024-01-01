package SelfStudy.AdventureGame;

public abstract class GameChar {
    private String name;
    private int id;
    private int damage;
    private int health;
    private int money;

    public GameChar(String name, int id, int damage, int health, int money) {
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.money = money;
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

    public int getMoney() {
        return money;
    }

}

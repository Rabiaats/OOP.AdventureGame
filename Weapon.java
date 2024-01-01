package SelfStudy.AdventureGame;

public abstract class Weapon extends Item{
    private int damage;

    public Weapon(String name, int id, int damage, int price) {
        super(name, id, price);
        this.damage = damage;
    }
    public int getDamage() {
        return damage;
    }
}

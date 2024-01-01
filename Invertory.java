package SelfStudy.AdventureGame;

public class Invertory {
    private Weapon weapon;
    private Armor armor;
    private boolean water;
    private boolean food;
    private boolean firewood;
    public Invertory(){
        this.water = false;
        this.food = false;
        this.firewood = false;
        this.armor = new NullArmor();
        this.weapon = new NullWeapon();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        System.out.println("You have a " + weapon.getName() +
                           "\nDamage: " + weapon.getDamage() +
                           "\nYou can fight better now");
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        System.out.println("You have a " + weapon.getName() +
                           "\nBlock: " + armor.getBlock() +
                           "\nYou can block better now");
        this.armor = armor;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }
}

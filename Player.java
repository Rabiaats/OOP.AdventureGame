package SelfStudy.AdventureGame;

public class Player {
    private Invertory invertory;
    private String name;
    private String charName;
    private int damage;
    private int health;
    private int money;
    private int tmpHealth; // for full health

    public Player(String name) {
        this.name = name;
        this.invertory = new Invertory();
    }
    public Invertory getInvertory() {
        return invertory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setMoney(int money) {
        if (money > this.money)System.out.println("You made " + (money - this.money) +
                                                  " money. Don't forget to stop by the Toolstore");
        this.money = money;
    }

    public int getTmpHealth() {
        return tmpHealth;
    }

    public void addChar(GameChar gameChar) {
        this.charName = gameChar.getName();
        this.damage = gameChar.getDamage();
        this.health = gameChar.getHealth();
        this.tmpHealth = gameChar.getHealth();
        this.money = gameChar.getMoney();
        System.out.println(this);
    }
    public boolean addWeapon(Weapon weapon) {
        if (this.money < weapon.getPrice()){
            System.out.println("Your money is insufficient\n" +
                                weapon.getName() + " price: " + weapon.getPrice() +
                               "\nYour money: " + this.money);
            return false;
        }else {
            this.invertory.setWeapon(weapon);
            this.money = (this.money - weapon.getPrice());

            System.out.println("Your money: " + this.money +
                               "\nYour total damage: " + (this.damage + this.invertory.getWeapon().getDamage()));
            return true;
        }
    }
    public boolean addArmor(Armor armor) {
        if (this.money < armor.getPrice()) {
            System.out.println("Your money is insufficient\n" +
                               armor.getName() + " price: " + armor.getPrice() +
                               "\nYour money: " + this.money);
            return false;
        } else {
            this.invertory.setArmor(armor);
            this.money = (this.money - armor.getPrice());
            armor.onItem();

            System.out.println("Your money: " + this.money +
                               "\nYour block: " + this.invertory.getArmor().getBlock());
            return true;
        }
    }

    public String toString(){
        return "YOUR CHOICE\n" +
                "Character: " + this.charName +
                "\nHealty: " + this.health +
                "\nDamage: " + this.damage +
                "\nWeapon Damage: " + this.getInvertory().getWeapon().getDamage() +
                "\nArmor Block: " + this.getInvertory().getArmor().getBlock() +
                "\nMoney: " + this.money;
    }
}

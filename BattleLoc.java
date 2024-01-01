package SelfStudy.AdventureGame;

import java.util.Scanner;

public abstract class BattleLoc extends Location{
    private static Scanner scan = new Scanner(System.in);
    private static String select;
    private Obstacle obstacle ;
    private String itemName;
    private int tmpObsHealth; /* the health of the other remaining monster health returns
                                 first monster's health when a monster kill */

    public BattleLoc(String name, Obstacle obstacle, String itemName) {
        super(name);
        this.obstacle = obstacle;
        this.itemName = itemName;
        this.tmpObsHealth = obstacle.getHealth();
    }
    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getItemName() {
        return itemName;
    }

    public int getTmpObsHealth() {
        return tmpObsHealth;
    }

    @Override
    public void onLocation(){
        System.out.println("-".repeat(58));

        System.out.println("Wellcome " + this.getPlayer().getName() +
                           "\nYou're in a " + this.getName() + " now." +
                           "\nThere are " + this.getObstacle().getNumber() + " " +
                           this.getObstacle().getName() + " here.\n" +
                           this.getObstacle().getName() + "'s health: " + getObstacle().getHealth() +
                           "\n" + this.getObstacle().getName() + "'s damage: " + getObstacle().getDamage() +
                           "\nYou have to kill them all to win the " + this.getItemName() +
                           "\nBe careful.\nGood luck :)");

        if (combat()){
            System.out.println("-".repeat(58));
            System.out.println("Congratulations. You won the " + this.getItemName());
            switch (this.getItemName()) {
                case "Food" -> this.getPlayer().getInvertory().setFood(true);
                case "Firewood" -> this.getPlayer().getInvertory().setFirewood(true);
                case "Water" -> this.getPlayer().getInvertory().setWater(true);
            }

            System.out.println("-".repeat(58));
        }
        else {
            if (this.getPlayer().getHealth() > 0) System.out.println("You come back to win the " + this.getItemName());
        }
    }

    public boolean combat(){
        do {
            System.out.println("-".repeat(58));
            System.out.print("""
                    What are you planning to do?
                    1)Fight
                    2)Go Back
                    Enter number:\s""");
            select = scan.nextLine();
            if (select.equals("1")){
                return attack();
            }else if (select.equals("2")){
                return false;
            }else {
                System.out.println("You must choose 1 or 2!!");
            }
        }while (!(select.equals("1") || select.equals("2")));
        return false;

    }

    public boolean attack(){
        do {
            System.out.println("-".repeat(58));

            int defense =  (int)((Math.random() * 2) + 1);
            int whoAttack = (int)((Math.random() * 2) + 1);

            System.out.println("-".repeat(58));

            if (whoAttack == 1){
                System.out.println(this.obstacle.getName() + " has gone on the attack");

                if (defense == 1) System.out.println("You escaped the attack");
                else {
                    System.out.println("You were attacked by " + this.obstacle.getName());

                    if (this.getPlayer().getInvertory().getArmor().getBlock() != 0){ // player has a armor
                        this.getPlayer().setHealth((this.getPlayer().getHealth() +
                                                    this.getPlayer().getInvertory().getArmor().getBlock()) -
                                                    this.obstacle.getDamage());

                        System.out.println("You have blocked the attack and reduced its effect by " +
                                           this.getPlayer().getInvertory().getArmor().getBlock() +
                                           ".\n Because you have " +
                                           this.getPlayer().getInvertory().getArmor().getName());

                    } else this.getPlayer().setHealth(this.getPlayer().getHealth() - this.obstacle.getDamage());

                    System.out.println("Your current health: " + this.getPlayer().getHealth());

                    if (this.getPlayer().getHealth() <= 0) return false;
                }
            } else {
                System.out.println("You has gone on the attack");

                if (defense == 2) System.out.println(this.obstacle.getName() + " escaped the attack");
                else {
                    System.out.println(this.obstacle.getName() + " was attacked by you");

                    if (this.getPlayer().getInvertory().getWeapon().getDamage() != 0){ // player has a weapon
                        this.obstacle.setHealth(this.obstacle.getHealth() -
                                                (this.getPlayer().getDamage() +
                                                 this.getPlayer().getInvertory().getWeapon().getDamage()));

                        System.out.println("Since you have a " +
                                           this.getPlayer().getInvertory().getWeapon().getName() +
                                           ", the damage you have caused has increased by " +
                                            this.getPlayer().getInvertory().getWeapon().getDamage());

                    } else this.obstacle.setHealth(this.obstacle.getHealth() - this.getPlayer().getDamage());

                    if (this.obstacle.getHealth() <= 0){ // the monster die
                        System.out.println("You killed " + this.obstacle.getName());
                        this.obstacle.setNumber(this.obstacle.getNumber() - 1);
                        System.out.println("There are " + this.obstacle.getNumber() + " " + this.obstacle.getName());
                        this.obstacle.setHealth(this.tmpObsHealth);

                        if (this.getName().equals("Mine")) return true;
                        else {
                            this.getPlayer().setMoney(this.getPlayer().getMoney() + this.obstacle.getMoney());
                            System.out.println("Your money: " + this.getPlayer().getMoney());
                        }

                        if (this.obstacle.getNumber() == 0) return true; // all monsters die
                    }

                    System.out.println(this.obstacle.getName() + "'s current health: " + this.obstacle.getHealth());
                }
            }

            System.out.println("-".repeat(58));

            System.out.print("There are " + this.obstacle.getNumber() + " " + this.obstacle.getName() +
                             "\nWhat are you planning to do?" +
                             "\n1)Continue\n2)Get Away" +
                             "\nEnter number: ");

            select = scan.nextLine();

        } while (select.equals("1"));

        return false;
    }
}

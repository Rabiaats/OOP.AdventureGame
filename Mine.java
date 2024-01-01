package SelfStudy.AdventureGame;

import java.awt.font.TextHitInfo;

public class Mine extends BattleLoc{
    private int percentage;
    public Mine() {
        super("Mine", new Snake(), "İtem");
    }
    @Override
    public void onLocation(){
        System.out.println("-".repeat(58));

        if (this.getObstacle().getNumber() == 0){
            System.out.println("There are no monsters " + this.getName());
            return;
        }

        System.out.println("Wellcome " + this.getPlayer().getName());
        System.out.println("You're in a " + this.getName() + " now." +
                "\nThere are " + this.getObstacle().getNumber() + " " + this.getObstacle().getName() + " here.\n" +
                this.getObstacle().getName() + "'s health: " + getObstacle().getHealth() +
                "\n" + this.getObstacle().getName() + "'s damage: " + getObstacle().getDamage() +
                "\nYou have to kill them all to win the " + this.getItemName() + "s" +
                "\nBe careful.\nGood luck :)");

        if (combat()){
            System.out.println("-".repeat(58));

            System.out.println("""
                    Congratulations. You have a chance to win an item
                    It depends entirely on your luck
                    Let's see""");

            System.out.println("-".repeat(58));

            this.percentage = (int)((Math.random() * 100) + 1);

            if (percentage <= 15)addItem(1);
            else if (percentage <= 30) addItem(2);
            else if (percentage <= 55) addItem(3);
            else System.out.println("""
                        Dude, you didn't have a chance.
                        You didn't win an award.
                        Kill the snake and try again.
                        Good luck again:).""");

            if (this.getObstacle().getNumber() == 0) return;

            attack();
        } else if (this.getPlayer().getHealth() > 0) System.out.println("You come back to win the " + this.getItemName());
    }
    public void addItem(int num){
        this.percentage = (int)(Math.random() * 101);
        // the game has 3 weapons and 3 armors, the id is 1, 2 or 3

        if (percentage <= 20){
            if (num == 1){
                if (this.getPlayer().getInvertory().getWeapon() == null || this.getPlayer().getInvertory().getWeapon().getId() < 3)
                    this.getPlayer().getInvertory().setWeapon(new Rifle());

            } else if (num == 2) {
                if (this.getPlayer().getInvertory().getArmor() == null || this.getPlayer().getInvertory().getArmor().getId() < 3)
                    this.getPlayer().getInvertory().setArmor(new Heavy());

            }else this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);

        } else if (percentage <= 50) {
            if (num == 1){
                if (this.getPlayer().getInvertory().getWeapon() == null || this.getPlayer().getInvertory().getWeapon().getId() < 2)
                    this.getPlayer().getInvertory().setWeapon(new Sword());

            } else if (num == 2) {
                if (this.getPlayer().getInvertory().getArmor() == null || this.getPlayer().getInvertory().getArmor().getId() < 2)
                    this.getPlayer().getInvertory().setArmor(new Middle());

            }else this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);

        }else {
            if (num == 1){
                if (this.getPlayer().getInvertory().getWeapon() == null) this.getPlayer().getInvertory().setWeapon(new Gun());

            } else if (num == 2) {
                if (this.getPlayer().getInvertory().getArmor() == null)  this.getPlayer().getInvertory().setArmor(new Light());

            }else this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
        }
    }
}

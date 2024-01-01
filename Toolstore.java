package SelfStudy.AdventureGame;

import java.util.Scanner;

public class Toolstore extends Normalloc{
    private static Scanner scan = new Scanner(System.in);
    private static String select;
    private static boolean isSelect;

    public Toolstore() {
        super("Toolstore");
        isSelect = false;
    }

    @Override
    public void onLocation(){
        System.out.println("-".repeat(58));

        System.out.println("Wellcome " + this.getPlayer().getName() +
                           "You're in a " + this.getName() + " now" +
                           "You can buy armor and weapons to strengthen your inventory" +
                           "Do not forget!! You can increase the damage you will inflict by buying a weapon");
        menu();
    }
    public void menu(){
        do {
            System.out.print("""
                    What do you want to buy?
                    1)Weapon
                    2)Armor
                    3)Exit
                    Enter number:\s""");
            select = scan.nextLine();

            switch (select) {
                case "1" -> buyWeapon();
                case "2" -> buyArmor();
                case "3" -> {
                    return;
                }
                default -> System.out.println("You must choose 1, 2 or 3!!");
            }
        }while (!(select.equals("1") || select.equals("2") || select.equals("3")));
    }
    public void buyWeapon(){
        System.out.println("+--------+----+--------+-------+");
        System.out.printf("| %6s | %2s | %6s | %5s |\n","WEAPON" , "ID" , "DAMAGE" , "PRICE");
        System.out.println("+--------+----+--------+-------+");
        System.out.printf("| %-6s |  %1d |    %1d   |   %2d   |\n","Gun" , 1 , 2 , 25);
        System.out.println("|--------|----|--------|-------|");
        System.out.printf("| %-6s |  %1d |    %1d   |   %2d   |\n","Sword" , 2 , 3 , 35);
        System.out.println("|--------|----|--------|-------|");
        System.out.printf("| %-6s |  %1d |    %1d   |   %2d   |\n","Rifle" , 3 , 7 , 45);
        System.out.println("+--------+----+--------+-------+");
        System.out.println("+------------------------------+");
        System.out.println("Type 4 to return to the menu");
        System.out.println("+------------------------------+");

        do {
            System.out.print("Which weapon will you want to buy?" +
                             "\nEnter weapon ID: ");
            select = scan.nextLine();

            switch (select){
                case "1":
                    isSelect = this.getPlayer().addWeapon(new Gun());
                    break;
                case "2":
                    isSelect = this.getPlayer().addWeapon(new Sword());
                    break;
                case "3":
                    isSelect = this.getPlayer().addWeapon(new Rifle());
                    break;
                case "4":
                    System.out.println("You returning to the menu");
                    menu();
                    return;
                default:
                    System.out.println("You need to choose one of the options");
            }
        }while(!isSelect);
    }
    public void buyArmor(){
        System.out.println("+--------------+----+--------+-------+");
        System.out.printf("|     %5s    | %2s | %5s | %5s |\n","ARMOR" , "ID" , "BLOCK" , "PRICE");
        System.out.println("+--------------+----+--------+-------+");
        System.out.printf("| %-12s |  %1d |    %1d   |   %2d   |\n","Light Armor" , 1 , 2 , 25);
        System.out.println("|--------------|----|--------|-------|");
        System.out.printf("| %-12s |  %1d |    %1d   |   %2d   |\n","Middle Armor" , 2 , 3 , 35);
        System.out.println("|--------------|----|--------|-------|");
        System.out.printf("| %-12s |  %1d |    %1d   |   %2d   |\n","Heavy Armor" , 3 , 7 , 45);
        System.out.println("+--------------+----+--------+-------+");
        System.out.println("+------------------------------------+");
        System.out.println("Type 4 to return to the menu");
        System.out.println("+------------------------------------+");

        do {
            System.out.print("Which weapon will you want to buy?" +
                             "\nEnter weapon ID: ");
            select = scan.nextLine();

            switch (select){
                case "1":
                    isSelect = this.getPlayer().addArmor(new Light());
                    break;
                case "2":
                    isSelect = this.getPlayer().addArmor(new Middle());
                    break;
                case "3":
                    isSelect = this.getPlayer().addArmor(new Heavy());
                    break;
                case "4":
                    System.out.println("You returning to the menu");
                    menu();
                    return;
                default:
                    System.out.println("You need to choose one of the options");
            }
        }while(!isSelect);
    }
}

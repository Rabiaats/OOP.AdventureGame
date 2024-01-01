package SelfStudy.AdventureGame;

import java.nio.channels.Pipe;
import java.util.Scanner;

public class Game {
    private static Scanner scan = new Scanner(System.in);
    private Player player;
    private Location location;
    private static String select;

    public Game(){}

    public Game(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public Location getLocation() {
        return location;
    }

    public void start() {
        System.out.println("-".repeat(58));

        System.out.print("""
                Wellcome player.
                Please, enter your player name to start the game.
                Player name : \s""");
        this.player = new Player(scan.nextLine());

        System.out.println("-".repeat(58));

        System.out.println(this.player.getName() + " have logged in to the game.\n" +
                           "-".repeat(58) +
                           "\nChoose the character you will play to continue.");

        selectChar();

        System.out.println("""
                ***
                Your goal in the game is to collect 3 special items; Food, Wood and Water.
                The food is in the cave, the wood is in the forest and the water is in the river.
                You must defeat the monsters found in these places in order to collect. 1, 2 or 3 of them.
                There are zombies in the cave, vampires in the forest and bears in the river.
                You must act according to the characteristics of your chosen character.
                You can attack and make money.\s
                You can make a defense.
                You may withdraw.

                You can buy weapons and armor in the store before fighting monsters.
                Let's start the game,\s""" + player.getName() +".\n***");

        System.out.println("-".repeat(58));

        System.out.println("Choose where you want to go?");
        selectLoc();
    }

    public void selectChar(){
        System.out.println("+-----------+----+--------+--------+-------+");
        System.out.printf("| %9s | %2s | %6s | %6s | %5s |\n","CHARACTER" , "ID" , "DAMAGE" , "HEALTH" , "MONEY");
        System.out.println("+-----------+----+--------+--------+-------+");
        System.out.printf("| %-9s |  %1d |    %1d   |   %2d   |   %2d  |\n","Samurai" , 1 , 5 , 21 , 15);
        System.out.println("|-----------|----|--------|--------|-------|");
        System.out.printf("| %-9s |  %1d |    %1d   |   %2d   |   %2d  |\n","Archer" , 2 , 7 , 18 , 20);
        System.out.println("|-----------|----|--------|--------|-------|");
        System.out.printf("| %-9s |  %1d |    %1d   |   %2d   |    %1d  |\n","Knight" , 3 , 8 , 24 , 5);
        System.out.println("+-----------+----+--------+--------+-------+");

        System.out.println("Which character will you choose?");

        do {
            System.out.print("Enter character ID: ");
            select = scan.nextLine();

            System.out.println("-".repeat(58));

            switch (select) {
                case "1":
                    this.player.addChar(new Samurai());
                    break;
                case "2":
                    this.player.addChar(new Archer());
                    break;
                case "3":
                    this.player.addChar(new Knight());
                    break;
                default:
                    System.out.println("You entered the wrong ID. Enter again.");
            }
        }while (!(select.equals("1") || select.equals("2") || select.equals("3")));

        System.out.println("-".repeat(58));
    }
    public void selectLoc(){
        do {
            System.out.println("+----+------------+--------------------------------------+");
            System.out.printf("| %2s |  %8s  |             %11s              |\n","  ","LOCATION" ,"EXPLANATION");
            System.out.println("+----+------------+--------------------------------------+");
            System.out.printf("|  %1d | %-10s | %-36s |\n",1,"Safe House" ,"Your health is full.");
            System.out.println("|----|------------|--------------------------------------|");
            System.out.printf("|  %1d | %-10s | %-36s |\n",2,"Toolstore" ,"You can buy armor and weapons");
            System.out.println("|----|------------|--------------------------------------|");
            System.out.printf("|  %1d | %-10s | %-36s |\n",3,"Cave" ,"You can kill zombies and earn money");
            System.out.println("|----|------------|--------------------------------------|");
            System.out.printf("|  %1d | %-10s | %-36s |\n",4,"Forest" ,"You can kill vampires and earn money");
            System.out.println("|----|------------|--------------------------------------|");
            System.out.printf("|  %1d | %-10s | %-36s |\n",5,"River" ,"Your can kill bears and earn money");
            System.out.println("|----|------------|--------------------------------------|");
            System.out.printf("|  %1d | %-10s | %-36s |\n",6,"Mine" ,"Your can kill snakes and earn items");
            System.out.println("|----|------------|--------------------------------------|");
            System.out.printf("|  %1d | %-10s | %-36s |\n",7,"Game Exit" ,"Game ends");
            System.out.println("+----+------------+--------------------------------------+");

            System.out.print("Enter location number: ");
            select = scan.nextLine();

            switch (select) {
                case "1":
                    this.location = new SafeHouse();
                    this.location.setPlayer(this.player);
                    location.onLocation();
                    break;
                case "2":
                    this.location = new Toolstore();
                    this.location.setPlayer(this.player);
                    location.onLocation();
                    break;
                case "3":
                    if (this.getPlayer().getInvertory().isFood()){
                        System.out.println("This location is closed because you won the Food");
                        break;
                    }
                    this.location = new Cave();
                    this.location.setPlayer(this.player);
                    this.location.onLocation();
                    break;
                case "4":
                    if (this.getPlayer().getInvertory().isFirewood()){
                        System.out.println("This location is closed because you won the Firewood");
                        break;
                    }
                    this.location = new Forest();
                    this.location.setPlayer(this.player);
                    location.onLocation();
                    break;
                case "5":
                    if (this.getPlayer().getInvertory().isWater()){
                        System.out.println("This location is closed because you won the Water");
                        break;
                    }
                    this.location = new River();
                    this.location.setPlayer(this.player);
                    location.onLocation();
                    break;
                case "6":
                    this.location = new Mine();
                    this.location.setPlayer(this.player);
                    location.onLocation();
                    break;
                case "7":
                    System.out.println("You have closed the game");
                    break;
                default:
                    System.out.println("Just select the places in the table");
            }

            if (this.player.getHealth() <= 0){
                System.out.println("Game Over !! :( :( :( :(");
                return;
            }

            System.out.print("Are " + this.player.getName() + " see your information? \n1)YES\n2)NO\nEnter number: ");
            select = scan.nextLine();

            if (select.equals("1")) System.out.println(this.player);

            if (this.player.getInvertory().isFirewood() && this.player.getInvertory().isFood() && this.player.getInvertory().isWater()){
                this.location = new SafeHouse();
                System.out.println("Congratulations , You won !! :) :) :) :) :) :)");
                return;
            }

        }while (!select.equals("7"));
    }
}

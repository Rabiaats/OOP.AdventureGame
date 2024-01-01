package SelfStudy.AdventureGame;

public class Vampire extends Obstacle{
    private static int number;
    static {
        number = obstacleNumber();
    }
    public Vampire() {
        super("Vampire", 2, 4, 14,7, number);
    }

}

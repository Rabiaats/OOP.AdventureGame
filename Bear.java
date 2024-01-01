package SelfStudy.AdventureGame;

public class Bear extends Obstacle{
    private static int number;
    static {number = obstacleNumber();}
    public Bear() {
        super("Bear", 3, 7, 20,12, number);
    }
}

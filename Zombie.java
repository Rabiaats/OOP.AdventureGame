package SelfStudy.AdventureGame;

public class Zombie extends Obstacle{
    private static int number;
    static {
        number = obstacleNumber();
    }
    public Zombie() {
        super("Zombie", 1, 3, 10,4, number);
    }
}

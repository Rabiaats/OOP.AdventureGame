package SelfStudy.AdventureGame;

public class Snake extends Obstacle{
    private static int number;
    private static int damage;
    static {
        number = obstacleNumber();
        damage = damage();
    }
    public Snake() {
        super("Snake", 4, damage, 12,0, number);
    }
    public static int damage(){
        return (int) ((Math.random() * 3) + 3);
    }
    public static int obstacleNumber(){
        return (int) ((Math.random() * 5) + 1);
    }
}

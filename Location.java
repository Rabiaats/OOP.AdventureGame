package SelfStudy.AdventureGame;

public abstract class Location {
    private Player player;
    private String name;

    public Location(String name) {
        this.name = name;
    }
    public Player getPlayer() {
        return player;
    }

    public String getName() {
        return name;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public abstract void onLocation();
}

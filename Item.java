package SelfStudy.AdventureGame;

public abstract class Item {
    private String name;
    private int id;
    private int price;

    public Item(String name, int id, int price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public int getPrice() {
        return price;
    }

}

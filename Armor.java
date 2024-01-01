package SelfStudy.AdventureGame;

public abstract class Armor extends Item{
    private int block;
    public Armor(String name, int id, int block, int price) {
        super(name, id, price);
        this.block = block;
    }
    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public void onItem(){
        System.out.println("You have purchased " + this.getName() +
                "\nBlock: " + this.getBlock());
    }
}

package SelfStudy.AdventureGame;

public class SafeHouse extends Normalloc{
    public SafeHouse() {
        super("Safe House");
    }

    @Override
    public void onLocation(){
        System.out.println("-".repeat(58));

        this.getPlayer().setHealth(this.getPlayer().getTmpHealth());

        System.out.println("Wellcome " + this.getPlayer().getName() +
                           "You're in a " + this.getName() + " now.\n" +
                           "Your health is full. ;)");
    }
}

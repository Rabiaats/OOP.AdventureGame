package SelfStudy.AdventureGame;

public abstract class Normalloc extends Location{
    public Normalloc(String name) {
        super(name);
    }

    @Override
    public abstract void onLocation();
}

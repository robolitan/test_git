package ua.patterns.creators.abstractfabrice;

public abstract class Animal {
    protected String name;

    abstract void sayWhoYouAre();

    public String getName() {
        sayWhoYouAre();
        return name;
    }
}

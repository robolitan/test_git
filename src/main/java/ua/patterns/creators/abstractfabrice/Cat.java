package ua.patterns.creators.abstractfabrice;

public class Cat extends Animal {
    public Cat() {
        this.name = "cat";
    }

    @Override
    void sayWhoYouAre() {
        System.out.println(getName());
    }
}

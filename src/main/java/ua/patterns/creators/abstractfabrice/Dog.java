package ua.patterns.creators.abstractfabrice;

public class Dog extends Animal {

    public Dog() {
        this.name = "dog";
    }

    @Override
    void sayWhoYouAre() {
        System.out.println(getName());
    }
}

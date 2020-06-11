package ua.patterns.behavior.visitor;

public class ShowMeYourNameClass implements Visitor {
    @Override
    public void accept(Mouse m) {
        System.out.println(m.getClass());
    }

    @Override
    public void accept(Keyboard k) {
        System.out.println(k.getClass());
    }
}

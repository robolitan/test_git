package ua.patterns.behavior.visitor;

public class ShowMeWhoYouAre implements Visitor {
    @Override
    public void accept(Mouse m) {
        m.getName();
    }

    @Override
    public void accept(Keyboard k) {
        k.getName();
    }
}

package ua.patterns.behavior.visitor;

public interface Visitor {
    void accept(Mouse m);
    void accept(Keyboard k);
}

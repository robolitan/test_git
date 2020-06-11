package ua.patterns.behavior.visitor;

public class Keyboard extends ComputerPart {
    @Override
    void getName() {
        System.out.println("i am keyboard");
    }

    @Override
    void accept(Visitor v) {
        v.accept(this);
    }
}

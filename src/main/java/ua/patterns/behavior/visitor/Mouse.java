package ua.patterns.behavior.visitor;

public class Mouse extends ComputerPart {
    @Override
    void getName() {
        System.out.println("i am mouse");
    }

    @Override
    void accept(Visitor v) {
        v.accept(this);
    }
}

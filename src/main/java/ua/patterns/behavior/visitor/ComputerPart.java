package ua.patterns.behavior.visitor;

public abstract class ComputerPart {
    abstract void getName();
    abstract void accept(Visitor v);
}

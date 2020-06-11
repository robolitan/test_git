package ua.patterns.behavior.strategy;

abstract class Strategy {
    protected String name;

    abstract int execute(int x, int y);
}

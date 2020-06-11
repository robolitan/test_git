package ua.patterns.behavior.strategy;

public class Multiply extends Strategy {

    public Multiply() {
        this.name = "multy";
    }

    @Override
    public int execute(int x, int y) {
        return x*y;
    }
}

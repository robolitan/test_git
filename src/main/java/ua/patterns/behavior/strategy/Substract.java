package ua.patterns.behavior.strategy;

public class Substract extends Strategy {

    public Substract() {
        this.name = "sub";
    }

    @Override
    public int execute(int x, int y) {
        return x - y;
    }
}

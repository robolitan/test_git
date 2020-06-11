package ua.patterns.behavior.strategy;

public class Division extends Strategy {
    public Division() {
        this.name = "division";
    }

    @Override
    public int execute(int x, int y) {
        return x/y;
    }
}

package ua.patterns.behavior.strategy;

public class Context {
    Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    void printResult(int x, int y){
        System.out.println("Strategy name: " + strategy.name + " - " + strategy.execute(x, y));
    }
}

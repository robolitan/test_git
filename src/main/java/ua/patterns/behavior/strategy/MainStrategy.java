package ua.patterns.behavior.strategy;

public class MainStrategy {
    public static void main(String[] args) {
        Context context = new Context();
        context.setStrategy(new Division());
        context.printResult(20, 10);
        context.setStrategy(new Multiply());
        context.printResult(2, 30);
        context.setStrategy(new Substract());
        context.printResult(5, 5);
    }
}

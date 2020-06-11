package ua.patterns.behavior.template_method;

public class ShowDifferntConsole extends SomeAlgorithm {
    @Override
    protected void do1() {
        System.out.println("fuck_1");
    }

    @Override
    protected void do2() {
        System.out.println("fuck_2");
    }
}

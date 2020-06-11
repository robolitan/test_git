package ua.patterns.behavior.template_method;

public class ShowOrder extends SomeAlgorithm {
    @Override
    protected void do1() {
        System.out.println("in do1()");
    }

    /**
     *
     */
    @Override
    protected void do2() {
        System.out.println("in do2()");
    }
}

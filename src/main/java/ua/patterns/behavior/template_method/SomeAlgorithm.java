package ua.patterns.behavior.template_method;

public abstract class SomeAlgorithm {

    protected abstract void do1();

    protected abstract void do2();

    protected void do3() {
        System.out.println("in method do3()");
    }

    void startWork() {
        do1();
        do2();
        do3();
    }
}

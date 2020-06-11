package ua.patterns.structure.decorator;

public class MainDecorator {
    public static void main(String[] args) {
        BaseEntity baseEntity = new BaseEntity();
        HelloDecorator helloDecorator = new HelloDecorator(baseEntity);
        helloDecorator.doWork();
        helloDecorator.newDoWork();
    }
}

package ua.patterns.structure.decorator;

public class HelloDecorator extends Decorator {
    public HelloDecorator(BaseEntity baseEntity) {
        super(baseEntity);
    }

    @Override
    void doWork() {
        System.out.print("Hello ");
        super.doWork();
    }
}

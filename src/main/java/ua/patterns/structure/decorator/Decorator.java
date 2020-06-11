package ua.patterns.structure.decorator;

public abstract class Decorator {
    private BaseEntity baseEntity;
    public Decorator(BaseEntity baseEntity) {
        this.baseEntity = baseEntity;
    }

    void doWork(){
        baseEntity.doWork();
    }

    void newDoWork(){
        System.out.println("additional work");
    }
}

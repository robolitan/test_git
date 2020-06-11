package ua.patterns.structure.adapter;

public class SomeClassNewAdapter implements Clazz {

    private SomeClassOld someClassOld;

    public SomeClassNewAdapter(SomeClassOld someClassOld) {
        this.someClassOld = someClassOld;
    }

    @Override
    public void doWork() {
        System.out.println("new do work (additional work)");
        someClassOld.doWork();
        System.out.println("^ it`s was in adapter");
    }
}

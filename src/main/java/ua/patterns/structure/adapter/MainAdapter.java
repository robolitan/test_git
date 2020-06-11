package ua.patterns.structure.adapter;

public class MainAdapter {
    public static void main(String[] args) {
        SomeClassOld someClassOld = new SomeClassOld();
        SomeClassNewAdapter someClassNewAdapter = new SomeClassNewAdapter(someClassOld);
        someClassOld.doWork();
        someClassNewAdapter.doWork();
    }
}

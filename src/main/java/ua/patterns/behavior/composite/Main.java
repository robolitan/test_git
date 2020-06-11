package ua.patterns.behavior.composite;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add(2);
        list.add("s");
        list.add("f");
        list.add("s");
        System.out.println(list.size());
        System.out.println(list);
        list.remove("s");
        System.out.println(list.size());
        System.out.println(list);
    }
}

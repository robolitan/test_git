package ua.patterns.behavior.memento;

public class Memento {
    String state;

    public Memento(String state) {
        this.state = state;
    }

    String getState(){
        return state;
    }
}

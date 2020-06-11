package ua.patterns.behavior.memento;

public class MainMemento {
    public static void main(String[] args) {
        ObjectToSave object = new ObjectToSave("some initial state");
        CareTaker careTaker = new CareTaker();
        System.out.println(object.getCurrentState());
       careTaker.setMemento( object.saveState());
       object.setCurrentState("after changing state");
        System.out.println(object.getCurrentState());
        System.out.println("try to restore");
        object.restoreStateFromMemento(careTaker.getMemento());
        System.out.println(object.getCurrentState());
    }
}

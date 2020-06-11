package ua.patterns.behavior.memento;

public class ObjectToSave {
    private String currentState;

    public ObjectToSave(String currentState) {
        this.currentState = currentState;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public Memento saveState(){
        return new Memento(currentState);
    }

    public void restoreStateFromMemento(Memento memento){
        this.currentState = memento.getState();
    }
}

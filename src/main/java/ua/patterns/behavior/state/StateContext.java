package ua.patterns.behavior.state;

public class StateContext {
    private State currentState = new Холодное();
    private State previous = null;

    public void холоднее() {
        printInfoBefore();
        currentState.холоднее(this);
        printInfoAfter();
    }

    public void жарче() {
        printInfoBefore();
        currentState.жарче(this);
        printInfoAfter();
    }

    public void setCurrentState(State currentState) {
        previous = this.currentState;
        this.currentState = currentState;
    }

    private void printInfoAfter() {
        String[] nameAfter = currentState.getClass().getName().split("\\.");
        if (previous != currentState) {
            System.out.println("Поменялось на - " + nameAfter[nameAfter.length - 1]);
        } else {
            System.out.println("Не поменялось");
        }
    }

    private void printInfoBefore() {
        String[] nameBefore = currentState.getClass().getName().split("\\.");
        System.out.println("Текущее состояние - " + nameBefore[nameBefore.length - 1]);
    }
}

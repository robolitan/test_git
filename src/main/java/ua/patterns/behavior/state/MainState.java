package ua.patterns.behavior.state;

public class MainState {
    public static void main(String[] args) {
        StateContext stateContext = new StateContext();
        stateContext.жарче();
        stateContext.жарче();
        stateContext.жарче();
        stateContext.холоднее();
        stateContext.холоднее();
        stateContext.холоднее();
    }
}

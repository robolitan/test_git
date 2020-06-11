package ua.patterns.behavior.state;

public abstract class State {
    protected String name;
    abstract void холоднее(StateContext context);
    abstract void жарче(StateContext context);
}

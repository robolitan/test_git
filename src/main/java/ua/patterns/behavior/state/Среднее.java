package ua.patterns.behavior.state;

public class Среднее extends State {

    public Среднее() {
        this.name = "среднее";
    }

    @Override
    public void холоднее(StateContext context) {
        context.setCurrentState(new Холодное());
    }

    @Override
    public void жарче(StateContext context) {
        context.setCurrentState(new Жаркое());
    }
}

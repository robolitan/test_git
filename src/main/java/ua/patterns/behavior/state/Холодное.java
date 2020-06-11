package ua.patterns.behavior.state;

public class Холодное extends State {

    public Холодное() {
        this.name = "холодное";
    }

    @Override
    public void холоднее(StateContext context) {
        System.out.println("уже и так холодно");
    }

    @Override
    public void жарче(StateContext context) {
        context.setCurrentState(new Среднее());
    }
}

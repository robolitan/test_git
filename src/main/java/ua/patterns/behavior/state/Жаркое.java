package ua.patterns.behavior.state;

public class Жаркое extends State {

    public Жаркое() {
        this.name = "жаркое";
    }

    @Override
    public void холоднее(StateContext context) {
        context.setCurrentState(new Среднее());
    }

    @Override
    public void жарче(StateContext context) {
        System.out.println("Будет пекло");
    }
}

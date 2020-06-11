package ua.patterns.structure.flyewidth;

public class Computer implements Item {

    private String param = "1111";

    public Computer(String param) {
        this.param = param;
    }

    @Override
    public String getParam() {
        return param;
    }
}

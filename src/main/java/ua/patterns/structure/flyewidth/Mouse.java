package ua.patterns.structure.flyewidth;

public class Mouse implements Item {
    private String param;

    public Mouse(String param) {
        this.param = param;
    }

    @Override
    public String getParam() {
        return param;
    }
}

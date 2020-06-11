package ua.patterns.creators.prototype;

public abstract class Cookie implements Cloneable{

    protected int x;

    @Override
    public Cookie clone() throws CloneNotSupportedException {
        return (Cookie) super.clone();
    }
}

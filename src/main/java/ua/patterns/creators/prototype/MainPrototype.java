package ua.patterns.creators.prototype;

public class MainPrototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyCookie myCookie = new MyCookie(999);
        CookieMachine cookieMachine = new CookieMachine(myCookie);
        System.out.println(cookieMachine.makeCookie().x);
        System.out.println(cookieMachine.makeCookie().x);
        System.out.println(cookieMachine.makeCookie().x);
        System.out.println(cookieMachine.makeCookie().x);
    }
}

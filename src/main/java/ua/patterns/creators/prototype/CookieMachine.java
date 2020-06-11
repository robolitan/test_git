package ua.patterns.creators.prototype;

public class CookieMachine {

    private Cookie cookie;

    public CookieMachine(Cookie cookie) {
        this.cookie = cookie;
    }

    Cookie makeCookie() throws CloneNotSupportedException {
        return this.cookie.clone();
    }
}

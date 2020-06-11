package ua.patterns.behavior.visitor;

public class MainVisitor {
    public static void main(String[] args) {
        Mouse mouse = new Mouse();
        Keyboard keyboard = new Keyboard();
        ShowMeWhoYouAre showMeWhoYouAre = new ShowMeWhoYouAre();
        ShowMeYourNameClass showMeYourNameClass = new ShowMeYourNameClass();

        mouse.accept(showMeWhoYouAre);
        mouse.accept(showMeYourNameClass);
        keyboard.accept(showMeWhoYouAre);
        keyboard.accept(showMeYourNameClass);
    }
}

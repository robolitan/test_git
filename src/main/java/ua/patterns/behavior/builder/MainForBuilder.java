package ua.patterns.behavior.builder;

public class MainForBuilder {
    public static void main(String[] args) {
        System.out.println(new Account.AccountBuilder("Artem", "Lambert", 27)
                .aboutPerson("java dev. i work hard")
                .gender("male")
                .build());
    }
}

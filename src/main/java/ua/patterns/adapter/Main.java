package ua.patterns.adapter;

public class Main {
    public static void main(String[] args) {
        ABankImpl aBank = new ABankImpl();
        aBank.printBalanceOfCredit();
        BBankImpl bBank = new BBankImpl();
        bBank.printBalanceOfCredit();
        new BAdapter(aBank).printBalanceOfCredit();
    }
}

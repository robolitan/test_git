package ua.patterns.adapter;

public class ABankImpl implements Bank {
    private int balance;

    public ABankImpl() {
        balance = 200;
    }

    @Override
    public void printBalanceOfCredit() {
        System.out.println(this.getClass().getName() + " - balance = " + balance);

    }
}

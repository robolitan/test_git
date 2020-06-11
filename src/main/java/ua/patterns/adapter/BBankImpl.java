package ua.patterns.adapter;

public class BBankImpl implements Bank {
    private int balance;

    public BBankImpl() {
        this.balance = 100;
    }

    @Override
    public void printBalanceOfCredit() {
        System.out.println(this.getClass().getName() + " - balance = " + balance);

    }
}

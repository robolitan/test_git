package ua.patterns.adapter;

public class BAdapter extends BBankImpl {
    ABankImpl aBank;

    public BAdapter(ABankImpl aBank) {
        this.aBank = aBank;
    }

    @Override
    public void printBalanceOfCredit() {
        System.out.println("it adapter work");
        aBank.printBalanceOfCredit();
    }
}

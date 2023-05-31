package vn.funix.FX20359.java.asm2.models;

public class Account {

    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isPremium() {
        return getBalance() >= 10000000;
    }

    @Override
    public String toString() {
        return " " + accountNumber + " |                              " + String.format("%,dđ",(long)getBalance());
    }
}

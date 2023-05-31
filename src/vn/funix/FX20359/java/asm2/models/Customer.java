package vn.funix.FX20359.java.asm2.models;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private List<Account> accounts;

    public Customer(String name, String customerId) {
        super(name, customerId);
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }
    public boolean isPremium() {
        for (Account account : accounts) {
            if (account.isPremium()) {
                return true;
            }
        }
        return false;
    }

    public void addAccount(Account newAccount) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(newAccount.getAccountNumber())) {
                System.out.println("số tài khoản đã tồn tại");
            }
        }
        accounts.add(newAccount);

    }

    public double getTotalBalance() {
        double totalBalance = 0.0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }
    public void displayInformation(){
        String capDo;
        String totalBlance = String.format( "%,dđ", (long) getTotalBalance());

        if(isPremium()){
            capDo = "Premium";
        }else {
            capDo = "Normal";
        }
        System.out.printf("   %-10s|        %-7s| %-10s | %10s", getCustomerId(),getName(),capDo,totalBlance);
        System.out.println();
        for (int i = 0; i < accounts.size(); i++){
            System.out.println((i + 1) + ".      " + accounts.get(i)  );
        }

    }

}


package Bank_System_Methods;

import java.util.*;

public class Account {

    public Account(double accountNumber,double password) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.balance = 0;
    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(double accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double accountNumber;
    private double balance;

    public double getPassword() {
        return password;
    }

    public void setPassword(double password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", password=" + password +
                '}';
    }

    private double password;


    public void deposit(double amount){
        this.balance = this.balance + amount;
    }
    public void withDrawl(double amount){
        this.balance = this.balance - amount;
    }
}
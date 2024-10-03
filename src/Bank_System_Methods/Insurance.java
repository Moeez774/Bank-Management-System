package Bank_System_Methods;


public class Insurance {

    public double getAmountPerYear() {
        return amountPerYear;
    }

    public void setAmountPerYear(double amountPerYear) {
        this.amountPerYear = amountPerYear;
    }

    public int getTotalYear() {
        return totalYear;
    }

    public void setTotalYear(int totalYear) {
        this.totalYear = totalYear;
    }

    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(double accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void addBalance(double amount){
        this.balance = this.balance + amount;
    }

    private double amountPerYear;

    public double getYearsLeft() {
        return yearsLeft;
    }

    public void setYearsLeft(double yearsLeft) {
        this.yearsLeft = yearsLeft;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "amountPerYear=" + amountPerYear +
                ", yearsLeft=" + yearsLeft +
                ", totalYear=" + totalYear +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", status='" + status + '\'' +
                '}';
    }

    private double yearsLeft;

    public Insurance(double amountPerYear, int totalYear, double accountNumber) {
        this.amountPerYear = amountPerYear;
        this.totalYear = totalYear;
        this.yearsLeft = totalYear;
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.status = "Going on";
    }

    private int totalYear;
    private double accountNumber;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void cutYears(){
        this.yearsLeft = yearsLeft - 1;
    }

    private double balance;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;


}
package Bank_System_Methods;


public class Loan {

    private String loanID;

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }


    public String getLoanID() {
        return loanID;
    }

    public void setLoanID(String loanID) {
        this.loanID = loanID;
    }

    private double loanAmount;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    public double getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(double accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanID='" + loanID + '\'' +
                ", loanAmount=" + loanAmount +
                ", status='" + status + '\'' +
                ", accountNumber=" + accountNumber +
                '}';
    }

    private double accountNumber;
    public Loan(String loanID, double loanAmount, double accountNumber) {
        this.loanID = loanID;
        this.loanAmount = loanAmount;
        this.status = "Pending";
        this.accountNumber = accountNumber;
    }

}
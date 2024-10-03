package Bank_System_Methods;


public class Employee extends Person {

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public boolean checkInsuranceForm(Insurance i){
        if(i.getAmountPerYear() > 50000){
            return false;
        }
        else if(i.getTotalYear() > 30){
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + getName() + ", address='" + getAddress() + ", phone number='" + getPhoneNumber() +
                "employeeID='" + employeeID + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    private String employeeID;
    private String role;

    public Employee(String name, String address, String phoneNumber, String employeeID, String role) {
        super(name, address, phoneNumber);
        this.employeeID = employeeID;
        this.role = role;
    }
    public boolean authorizeLoan(Loan loan) {

        //For Checking Loan Requirements By Specific Employee

        if(loan.getLoanAmount() > 50000){
            return false;
        }
        return true;

    }
    public void approveLoan(Loan loan) {

        //For Approving Loan By Specific Employee

        loan.setStatus("Approved");

    }

}
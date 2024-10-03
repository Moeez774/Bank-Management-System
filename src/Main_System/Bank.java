package Main_System;

import Bank_System_Methods.*;

import java.io.Serializable;
import java.util.*;

class Bank {

    Map<Customer, List<Account>> accounts;

    Bank() {

        accounts = new HashMap<>();
        loans = new HashMap<>();
        transactions = new HashMap<>();
        customers = new LinkedList<>();
        insurances = new HashMap<>();
        loanController = new LinkedList<>();
        InsuranceController = new LinkedList<>();
        employee = new ArrayList<>();

    }

    Map<Customer, List<Insurance>> insurances;
    List<Customer> customers;
    Queue<Employee> loanController;
    Queue<Employee> InsuranceController;
    List<Employee> employee;
    Map<Customer, List<Loan>> loans;
    Map<Customer, List<Transaction>> transactions;

    public void addCustomer() {

        //For Adding Specific Customer

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Customer Address: ");
        String address = sc.nextLine();
        System.out.print("Enter Customer Phone Number: ");
        String number = sc.nextLine();
        Customer c = new Customer(name, address, number);
        customers.add(c);
        System.out.println("Customer Added Successfully");

    }

    public void removeCustomer() {

        //For Viewing Speciic Customer List

        Scanner sc = new Scanner(System.in);
        if (customers.isEmpty()) {
            System.out.println("No Customer Added Yet");
        } else {
            Customer c1 = null;
            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();
            for (Customer c : customers) {
                if (name.equals(c.getName())) {
                    c1 = c;
                    customers.remove(c1);
                    System.out.println("Customer Removed");
                    break;
                }
            }
            if (c1 == null) {
                System.out.println("No Customer found with this name");
            }
        }

    }

    public void viewCustomers() {

        //For Viewing Customers List

        if (customers.isEmpty()) {
            System.out.println("No customer added yet");
        } else {
            System.out.println("Customers: ");
            for (Customer e : customers) {
                System.out.println(e);
            }
        }

    }

    public void addAccount() {

        //For Adding Specific Account of Specific Customer

        Scanner sc = new Scanner(System.in);
        Customer c1 = null;
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        for (Customer c : customers) {
            if (name.equals(c.getName())) {
                c1 = c;
                break;
            }
        }
        if (c1 == null) {
            System.out.println("No Customer found with provided name");
        } else {
            System.out.print("Enter Account Number: ");
            double ac = sc.nextInt();
            System.out.print("Enter Password: ");
            double p = sc.nextInt();
            Account a = new Account(ac, p);
            accounts.putIfAbsent(c1, new LinkedList<>());
            accounts.get(c1).add(a);
            System.out.println("Account Added");
        }

    }

    public void removeAccount() {

        //For Removing Specific Account of Specific Customer

        Customer c1 = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        for (Customer c : customers) {
            if (name.equals(c.getName())) {
                c1 = c;
                break;
            }
        }
        if (c1 == null) {
            System.out.println("No Customer found of provided name");
        } else {
            if (accounts.get(c1).isEmpty()) {
                System.out.println("No Account exist of provided Customer");
            } else {
                System.out.print("Enter Account Number: ");
                double ac = sc.nextInt();
                for (Account a : accounts.get(c1)) {
                    if (ac == a.getAccountNumber()) {
                        accounts.get(c1).remove(a);
                        System.out.println("Account Removed");
                        break;
                    }
                }
                System.out.println("The Account Number provided did not exist");
            }
        }

    }

    public void viewAccounts() {

        //For Viewing List if Each Customer's Account

        Customer c1 = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        for (Customer c : customers) {
            if (name.equals(c.getName())) {
                c1 = c;
                break;
            }
        }
        if (c1 == null) {
            System.out.println("No Customer found of provided name");
        } else {
            System.out.println("Accounts of " + c1.getName() + ":");
            for (Account a : accounts.get(c1)) {
                System.out.println(a);
            }
        }

    }

    public void viewEmployees() {

        //For Viewing List of All Employees

        if (employee.isEmpty()) {
            System.out.println("No Employee Added Yet");
        }
        System.out.println("Employees: ");
        {
            for (Employee e : employee) {
                System.out.println(e);
            }
        }

    }

    public void addEmployee() {

        //For Adding Specific Employee

        String d;
        int t;
        char[] ch;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String number = sc.nextLine();
        do {
            System.out.println("Employee ID must be start with 'E' and only have 4 characters");
            System.out.print("Enter EmployeeID: ");
            d = sc.nextLine();
            t = 0;
            ch = d.toCharArray();
        } while (ch[t] != 'E' || ch.length != 4);
        System.out.print("Enter Role: ");
        String role = sc.nextLine();
        String r1 = "Loan Controller";
        String r2 = "Insurance Controller";
        Employee e = new Employee(name, address, number, d, role);
        if (e.getRole().equals(r1)) {
            loanController.add(e);
            employee.add(e);
            System.out.println("Employee Added");
        } else if (e.getRole().equals(r2)) {
            InsuranceController.add(e);
            employee.add(e);
            System.out.println("Employee Added");
        } else {
            System.out.println("Employee can not be added without any role");
        }

    }

    public void removeEmployee() {

        //For Removing Specific Employee

        if (employee.isEmpty()) {
            System.out.println("No Employee Added Yet");
        } else {
            Employee e1 = null;
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();
            for (Employee e : employee) {
                if (name.equals(e.getName())) {
                    e1 = e;
                    employee.remove(e1);
                    System.out.println("Employee Removed");
                    break;
                }
            }
            if (e1 == null) {
                System.out.println("No Employee exist of provided name");
            }
        }

    }

    public void applyForLoan() {

        //For Applying Loan

        if (loanController.isEmpty()) {
            System.out.println("No Employee Available for Approving Loan");
        } else {
            Scanner sc = new Scanner(System.in);
            Customer c1 = null;
            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();
            for (Customer c : customers) {
                if (name.equals(c.getName())) {
                    c1 = c;
                    break;
                }
            }
            if (c1 == null) {
                System.out.println("No Customer found of provided name");
            } else {
                Account a = null;
                String d;
                char[] ch;
                int t;
                do {
                    System.out.println("Loan ID must be start with 'L' and only contain 4 characters");
                    System.out.print("Enter Loan ID: ");
                    d = sc.nextLine();
                    t = 0;
                    ch = d.toCharArray();
                } while (ch[t] != 'L' || ch.length != 4);
                System.out.print("Enter Account Number: ");
                double ac = sc.nextInt();
                System.out.print("Enter Loan Amount: ");
                double amount = sc.nextInt();
                Employee e = loanController.poll();
                for (Account account : accounts.get(c1)) {
                    if (ac == account.getAccountNumber()) {
                        a = account;
                        Loan l = new Loan(d, amount, ac);
                        if (e != null && e.authorizeLoan(l)) {
                            e.approveLoan(l);
                            System.out.println("Loan Approved by Loan Controller " + e.getName() + " and Send Successfully");
                            loans.putIfAbsent(c1, new LinkedList<>());
                            loans.get(c1).add(l);
                            a.deposit(l.getLoanAmount());
                        } else {
                            System.out.println("Loan Amount Limit is 50000");
                        }
                        break;
                    }
                }
                loanController.add(e);
                if (a == null) {
                    System.out.println("The Account Number provided did not exist");
                }
            }
        }

    }

    public void viewLoanQueue() {

        //For Viewing Loan History of Each Customer

        Customer c1 = null;
        Scanner sc = new Scanner(System.in);
        if (customers.isEmpty()) {
            System.out.println("No Customer added yet");
        } else {
            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();
            for (Customer c : customers) {
                if (name.equals(c.getName())) {
                    c1 = c;
                    break;
                }
            }
            if (c1 == null) {
                System.out.println("No Customer exist of provided name");
            } else {
                System.out.println("Loans of " + c1.getName() + ":");
                try {
                    for (Loan l : loans.get(c1)) {
                        System.out.println(l);
                    }
                } catch (NullPointerException e) {
                    System.out.println("No Loan has been applied by " + c1.getName());
                }
            }
        }

    }

    public void processTransaction() {

        //For Depositing or Withdrawing Money

        Scanner sc = new Scanner(System.in);
        if (customers.isEmpty()) {
            System.out.println("No Customer added yet");
        } else {
            Customer c1 = null;
            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();
            for (Customer c : customers) {
                if (name.equals(c.getName())) {
                    c1 = c;
                    break;
                }
            }
            if (c1 == null) {
                System.out.println("No Customer exist of provided name");
            } else {
                Account a = null;
                int i;
                do {
                    System.out.println("1-Deposit");
                    System.out.println("2-Withdraw");
                    i = sc.nextInt();
                } while (i != 1 && i != 2);
                System.out.print("Enter Amount: ");
                double amount = sc.nextInt();
                System.out.print("Enter Account Number: ");
                double ac = sc.nextInt();
                System.out.print("Enter Password: ");
                int p = sc.nextInt();
                for (Account account : accounts.get(c1)) {
                    if (ac == account.getAccountNumber() && p == account.getPassword()) {
                        a = account;
                        switch (i) {
                            case 1:
                                a.deposit(amount);
                                System.out.println("Deposit Successfully");
                                Transaction t = new Transaction(a, amount, "Deposit");
                                transactions.putIfAbsent(c1, new LinkedList<>());
                                transactions.get(c1).add(t);
                                break;
                            case 2:
                                if (amount > 50000) {
                                    System.out.println("50000 amount is limit for withdrawal");
                                } else if (a.getBalance() < amount) {
                                    System.out.println("Balance is not enough for withdrawal");
                                    break;
                                }
                                a.withDrawl(amount);
                                System.out.println("WithDraw Successfully");
                                Transaction t1 = new Transaction(a, amount, "withdrawal");
                                transactions.putIfAbsent(c1, new LinkedList<>());
                                transactions.get(c1).add(t1);
                        }
                    }
                }
                if (a == null) {
                    System.out.println("Account Number did not exist or Password is Wrong");
                }
            }
        }
    }

    public void checkBalance() {

        //For Checking Balance

        Scanner sc = new Scanner(System.in);
        if (customers.isEmpty()) {
            System.out.println("No Customer added yet");
        } else {
            Customer c = null;
            Account a = null;
            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();
            for (Customer c1 : customers) {
                if (name.equals(c1.getName())) {
                    c = c1;
                    break;
                }
            }
            if (c == null) {
                System.out.println("No Customer exist of provided name");
            } else {
                System.out.print("Enter Account Number: ");
                double ac = sc.nextInt();
                System.out.print("Enter Password: ");
                int p = sc.nextInt();
                for (Account account : accounts.get(c)) {
                    if (ac == account.getAccountNumber() && p == account.getPassword()) {
                        a = account;
                        System.out.println("Balance of " + c.getName() + " Account Number " + a.getAccountNumber() + ":");
                        System.out.println(a.getBalance());
                        break;
                    }
                }
                if (a == null) {
                    System.out.println("Account Number provided did not exist or Password is Wrong");
                }
            }
        }
    }

    public void transferMoney() {

        //For Transfer of Money

        Scanner sc = new Scanner(System.in);
        if (customers.isEmpty()) {
            System.out.println("No Customer added yet");
        } else {
            Customer sender = null;
            Customer receiver = null;
            System.out.print("Enter Sender Name: ");
            String s = sc.nextLine();
            System.out.print("Enter Sender Account Number: ");
            double sac = sc.nextInt();
            System.out.print("Enter Password: ");
            int sp = sc.nextInt();
            System.out.print("Enter Amount: ");
            double amount = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Receiver Name: ");
            String r = sc.nextLine();
            System.out.print("Enter Receiver Account Number: ");
            double rac = sc.nextInt();
            for (Customer c : customers) {
                if (s.equals(c.getName())) {
                    sender = c;
                    break;
                }
            }
            for (Customer c1 : customers) {
                if (r.equals(c1.getName())) {
                    receiver = c1;
                }
            }
            if (sender == null) {
                System.out.println("Sender Customer did not exist of provided name");
            } else if (receiver == null) {
                System.out.println("Receiver Customer did not exist of provided name");
            } else {
                Account a1 = null;
                Account a2 = null;
                for (Account account : accounts.get(sender)) {
                    if (sac == account.getAccountNumber() && sp == account.getPassword()) {
                        a1 = account;
                        break;
                    }
                }
                for (Account account : accounts.get(receiver)) {
                    if (rac == account.getAccountNumber()) {
                        a2 = account;
                        break;
                    }
                }
                if (a1 != null && a2 != null) {
                    a1.withDrawl(amount);
                    a2.deposit(amount);
                    System.out.println("Transfer Completed");
                    Transaction t = new Transaction(a1, a2, "Transfer", amount);
                    transactions.putIfAbsent(sender, new LinkedList<>());
                    transactions.get(sender).add(t);
                } else {
                    if (a1 == null) {
                        System.out.println("Sender Account Number did not exist or Sender Password is Wrong");
                    } else {
                        System.out.println("Receiver Account Number did not exist");
                    }
                }
            }
        }

    }

    public void viewTransactionHistory() {

        //For Viewing Each Customer's Transaction Histroy

        Scanner sc = new Scanner(System.in);
        if (customers.isEmpty()) {
            System.out.println("No Customers added yet");
        } else {
            Customer c1 = null;
            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();
            for (Customer c : customers) {
                if (name.equals(c.getName())) {
                    c1 = c;
                    break;
                }
            }
            if (c1 == null) {
                System.out.println("No Customer exist of provided name");
            } else {
                System.out.println("List of Transactions of " + c1.getName() + ":");
                try {
                    for (Transaction t : transactions.get(c1)) {
                        System.out.println(t);
                    }
                } catch (NullPointerException e) {
                    System.out.println("No Transaction Has Made Yet by " + c1.getName());
                }
            }
        }

    }

    public void applyForInsurance() {

        //For Applying Insurance

        Scanner sc = new Scanner(System.in);
        if (customers.isEmpty()) {
            System.out.println("No Customer added yet");
        } else if (InsuranceController.isEmpty()) {
            System.out.println("No Employee added yet for Controlling Insurance form");
        } else {
            Customer c1 = null;
            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();
            for (Customer c : customers) {
                if (name.equals(c.getName())) {
                    c1 = c;
                    break;
                }
            }
            if (c1 == null) {
                System.out.println("No Customer exist of provided name");
            } else {
                Account acc = null;
                System.out.print("Enter Amount Per Year You Want To Add: ");
                double amount = sc.nextInt();
                System.out.println("How Many Years Of Insurance You Want? ");
                int total = sc.nextInt();
                System.out.print("Enter Your Account Number: ");
                double ac = sc.nextInt();
                for (Account a : accounts.get(c1)) {
                    if (ac == a.getAccountNumber()) {
                        acc = a;
                        break;
                    }
                }
                if (acc != null) {
                    Insurance i = new Insurance(amount, total, ac);
                    Employee e = InsuranceController.poll();
                    if (e != null && e.checkInsuranceForm(i)) {
                        System.out.println("Insurance Form accepted, You can now start adding amount per year for " + i.getTotalYear() + " years");
                        insurances.putIfAbsent(c1, new LinkedList<>());
                        insurances.get(c1).add(i);
                    } else {
                        System.out.println("Insurance Form Rejected");
                    }
                    InsuranceController.add(e);
                } else {
                    System.out.println("Provided Account number for Insurance did not exist");
                }
            }
        }

    }

    public void addAmountToInsurance() {

        //For Adding Amount in Insurance

        Scanner sc = new Scanner(System.in);
        if (customers.isEmpty()) {
            System.out.println("No Customer Added Yet");
        } else {
            Customer c1 = null;
            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();
            for (Customer c : customers) {
                if (name.equals(c.getName())) {
                    c1 = c;
                    break;
                }
            }
            if (c1 == null) {
                System.out.println("No Customer exit of provided name");
            } else {
                Insurance is = null;
                Account acc = null;
                System.out.print("Enter Account Number: ");
                double ac = sc.nextInt();
                System.out.print("Enter Amount: ");
                double amount = sc.nextInt();
                try {
                    for (Insurance i : insurances.get(c1)) {
                        if (i.getAccountNumber() == ac) {
                            is = i;
                            if ((is.getStatus().equals("Completed")) || (is.getStatus().equals("Customer Dead"))) {
                                System.out.println("Insurance is Completed so you can not add more money");
                                break;
                            } else {
                                is.addBalance(amount);
                                is.cutYears();
                                System.out.println("Amount Added to Insurance Balance");
                                if (is.getYearsLeft() == 0) {
                                    i.setStatus("Completed");
                                    System.out.println("Your Total Time for Insurance is completed");
                                    for (Account a : accounts.get(c1)) {
                                        if (is.getAccountNumber() == a.getAccountNumber()) {
                                            acc = a;
                                            acc.deposit(is.getBalance());
                                            System.out.println("Your Total Time for Insurance is completed and Your Total Amount has been sent to provided Account");
                                            break;
                                        }
                                    }
                                    if (acc == null) {
                                        System.out.println("We can not sent total amount because provided Account Number of Insurance did not exist");
                                    }
                                    break;
                                }
                            }
                        }
                    }
                    if (is == null) {
                        System.out.println("Account Number provided did not exist for Insurance of this Customer");
                    }
                } catch (NullPointerException e) {
                    System.out.println("Customer did not apply for Insurance yet");
                }
            }
        }

    }

    public void deathOfInsuranceCustomer() {

        //Customer Death

        Scanner sc = new Scanner(System.in);
        if (customers.isEmpty()) {
            System.out.println("No Customer Added Yet");
        } else {
            Customer c1 = null;
            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();
            for (Customer c : customers) {
                if (name.equals(c.getName())) {
                    c1 = c;
                    break;
                }
            }
            if (c1 == null) {
                System.out.println("No Customer exist of provided name");
            } else {
                System.out.print("Enter Account Number: ");
                double ac = sc.nextInt();
                Insurance is = null;
                Account acc = null;
                try {
                    for (Insurance i : insurances.get(c1)) {
                        if (i.getAccountNumber() == ac) {
                            is = i;
                            System.out.println("Customer is dead so we are gonna sent total balance of Insurance");
                            for (Account a : accounts.get(c1)) {
                                if (is.getAccountNumber() == a.getAccountNumber()) {
                                    acc = a;
                                    acc.deposit(is.getBalance());
                                    i.setStatus("Customer Dead");
                                    System.out.println("Customer is dead so present amount has been sent to provided account");
                                    break;
                                }
                            }
                            if (acc == null) {
                                System.out.println("We can not sent total amount because provided Account Number of Insurance did not exist");
                            }
                        }
                    }
                    if (is == null) {
                        System.out.println("Account Number provided did not exist for Insurance of this customer");

                    }
                } catch (NullPointerException e) {
                    System.out.println("Customer did not apply for Insurance yet");
                }
            }
        }

    }

    public void viewInsuranceHistory() {

        //View Insurance History of Each Customer

        Scanner sc = new Scanner(System.in);
        if (customers.isEmpty()) {
            System.out.println("No Customer Added Yet");
        } else {
            Customer c1 = null;
            System.out.print("Enter Customer Name: ");
            String name = sc.nextLine();
            for (Customer c : customers) {
                if (name.equals(c.getName())) {
                    c1 = c;
                    break;
                }
            }
            if (c1 == null) {
                System.out.println("No Customer exist of provided name");
            } else {
                System.out.println("Insurance History of " + c1.getName() + ":");
                try {
                    for (Insurance i : insurances.get(c1)) {
                        System.out.println(i);
                    }
                } catch (NullPointerException e) {
                    System.out.println("No Insurance History Exist Of Provided Customer");
                }
            }
        }
    }

}

package Main_System;

import java.io.IOException;
import java.util.Scanner;

public class Bank_System {
    public static void main(String[] args) throws IOException {

        //Main System

        Bank b = new Bank();
        int i;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("What you want?");
            System.out.println("1-Add Customer");
            System.out.println("2-Remove Customer");
            System.out.println("3-View Customers List");
            System.out.println("4-Add Account of Specific Customer");
            System.out.println("5-Remove Account of Specific Customer");
            System.out.println("6-View Accounts of Specific Customer");
            System.out.println("7-Add Employee");
            System.out.println("8-Remove Employee");
            System.out.println("9-View Employees List");
            System.out.println("10-Apply for Loan");
            System.out.println("11-View Loan History of Specific Customer");
            System.out.println("12-For Process Transaction");
            System.out.println("13-Transfer Money");
            System.out.println("14-Check Balance");
            System.out.println("15-View Transaction History of Specific Customer");
            System.out.println("16-Apply For Insurance");
            System.out.println("17-Add Amount To Insurance");
            System.out.println("18-Death of Insurance Customer");
            System.out.println("19-View History of Insurances of Specific Customer");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if (b != null) {
                        b.addCustomer();
                    }
                    break;
                case 2:
                    if (b != null) {
                        b.removeCustomer();
                    }
                    break;
                case 3:
                    if (b != null) {
                        b.viewCustomers();
                    }
                    break;
                case 4:
                    if (b != null) {
                        b.addAccount();
                    }
                    break;
                case 5:
                    if (b != null) {
                        b.removeAccount();
                    }
                    break;
                case 6:
                    if (b != null) {
                        b.viewAccounts();
                    }
                    break;
                case 7:
                    if (b != null) {
                        b.addEmployee();
                    }
                    break;
                case 8:
                    if (b != null) {
                        b.removeEmployee();
                    }
                    break;
                case 9:
                    if (b != null) {
                        b.viewEmployees();
                    }
                    break;
                case 10:
                    if (b != null) {
                        b.applyForLoan();
                    }
                    break;
                case 11:
                    if (b != null) {
                        b.viewLoanQueue();
                    }
                    break;
                case 12:
                    if (b != null) {
                        b.processTransaction();
                    }
                    break;
                case 13:
                    if (b != null) {
                        b.transferMoney();
                    }
                    break;
                case 14:
                    if (b != null) {
                        b.checkBalance();
                    }
                    break;
                case 15:
                    if (b != null) {
                        b.viewTransactionHistory();
                    }
                    break;
                case 16:
                    if (b != null) {
                        b.applyForInsurance();
                    }
                    break;
                case 17:
                    if (b != null) {
                        b.addAmountToInsurance();
                    }
                    break;
                case 18:
                    if (b != null) {
                        b.deathOfInsuranceCustomer();
                    }
                    break;
                case 19:
                    if (b != null) {
                        b.viewInsuranceHistory();
                    }
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
            System.out.println("Enter 1 to perform more functions or 2 to exit");
            i = sc.nextInt();
        } while (i == 1);

        System.out.println("Exit Successfully");
    }
}

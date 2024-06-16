package cod;

import java.util.Scanner;
//Step 1: Create a class to represent the ATM machine
class ATM {
 private BankAccount account;
 private Scanner scanner;

 public ATM(BankAccount account) {
     this.account = account;
     scanner = new Scanner(System.in);
 }

 // Step 2: Design the user interface for the ATM
 public void displayMenu() {
     int choice = 0;
     while (choice != 4) {
         System.out.println("\nATM Menu:");
         System.out.println("1. Check Balance");
         System.out.println("2. Deposit Money");
         System.out.println("3. Withdraw Money");
         System.out.println("4. Exit");
         System.out.print("Enter your choice: ");
         choice = scanner.nextInt();
         performAction(choice);
     }
 }

 // Step 3: Implement methods for each option
 private void performAction(int choice) {
     switch (choice) {
         case 1:
             checkBalance();
             break;
         case 2:
             deposit();
             break;
         case 3:
             withdraw();
             break;
         case 4:
             System.out.println("Thank you for using the ATM. Goodbye!");
             break;
         default:
             System.out.println("Invalid choice. Please try again.");
     }
 }

 private void checkBalance() {
     System.out.println("Current balance: " + account.getBalance() + " Rs");
 }

 private void deposit() {
     System.out.print("Enter amount to deposit: ");
     double amount = scanner.nextDouble();
     if (amount > 0.0) {
         account.deposit(amount);
         System.out.println("Deposited: " + amount + " Rs");
     } else {
         System.out.println("Invalid amount. Please try again.");
     }
 }

 private void withdraw() {
     System.out.print("Enter amount to withdraw: ");
     double amount = scanner.nextDouble();
     if (amount > 0.0 && account.withdraw(amount)) {
         System.out.println("Withdrew: " + amount + " Rs");
     } else {
         System.out.println("Insufficient funds or invalid amount. Please try again.");
     }
 }

 public static void main(String[] args) {
     BankAccount account = new BankAccount(1000.0); // Initial balance
     ATM atm = new ATM(account);
     atm.displayMenu();
 }
}

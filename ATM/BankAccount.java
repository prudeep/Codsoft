package cod;

//Step 4: Create a class to represent the user's bank account
class BankAccount {
 private double balance;

 public BankAccount(double initialBalance) {
     if (initialBalance > 0.0) {
         this.balance = initialBalance;
     } else {
         this.balance = 0.0;
     }
 }

 public double getBalance() {
     return balance;
 }

 public void deposit(double amount) {
     if (amount > 0.0) {
         balance += amount;
     }
 }

 public boolean withdraw(double amount) {
     if (amount > 0.0 && amount <= balance) {
         balance -= amount;
         return true;
     } else {
         return false;
     }
 }
}
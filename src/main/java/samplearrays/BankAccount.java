package samplearrays;

public class BankAccount {

    String name;
    double currentBalance;
    //TO-DO: Initialize an Array with 1000 in size that stores Double called 'transactions' to keep track of the user's transactions
    Double[] transactions;
    int transctionCount;
    public BankAccount(String name, int startingBalance){
        this.name = name;
        this.currentBalance = startingBalance;
        this.transactions = new Double[1000];
        this.transctionCount = 0;
    }

    public void deposit(double amount){
        if (amount <= 0 ) {
            System.out.println("Invalid amount!");
            return;
        }
        currentBalance += amount;
        if (transctionCount < transactions.length) {
            transactions[transctionCount] = amount;
            transctionCount++;
        }
        System.out.println(name + " has deposited " + amount);
        System.out.println("Current balance: " + currentBalance);
    }

    public void withdraw(double amount){
        if (amount > currentBalance || amount <= 0) {
            System.out.println("Invalid amount!");
            return;
        }
        currentBalance -= amount;
        if (transctionCount < transactions.length) {
            transactions[transctionCount] = -amount;
            transctionCount++;
        }
        System.out.println(name + " has withdrawn " + amount);
        System.out.println("Current balance: " + currentBalance);
    }

    public void displayTransactions(){
        for (int i = 0; i < transctionCount; i++) {
            if (transactions[i] > 0) {
                System.out.println("Transaction: " + transactions[i]);
            } else {
                System.out.println("Withdrawl: " + -(transactions[i]));
            }

        }
    }

    public void displayBalance(){
        System.out.println("Current balance: " + currentBalance);
    }

    public static void main(String[] args) {

        BankAccount john = new BankAccount("John Doe", 100);

        // ----- DO NOT CHANGE -----

        //Testing..
        john.displayBalance();
        john.deposit(0.25);
        john.withdraw(100.50);
        john.withdraw(40.90);
        john.deposit(-90.55);
        john.deposit(3000);
        john.displayTransactions();
        john.displayBalance();

        // ----- DO NOT CHANGE -----

    }

}

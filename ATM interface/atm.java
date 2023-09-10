import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(0);
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Central bank of India:");
            System.out.println("Select an option:");
            System.out.println("1. Withdraw the amount");
            System.out.println("2. Deposit the amount");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount userAccount) {
        this.userAccount = userAccount;
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= userAccount.getBalance()) {
            userAccount.decreaseBalance(amount);
            System.out.println("Withdrawal successful. New balance: " + userAccount.getBalance());
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            userAccount.increaseBalance(amount);
            System.out.println("Deposit successful. New balance: " + userAccount.getBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + userAccount.getBalance());
    }
}
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void increaseBalance(double amount) {
        balance += amount;
    }

    public void decreaseBalance(double amount) {
        balance -= amount;
    }
}

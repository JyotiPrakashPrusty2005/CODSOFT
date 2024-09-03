import java.util.Scanner;

public class codsoft_task3 {
    private bank_account account;
    private Scanner scanner;

    public codsoft_task3(bank_account account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
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
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void checkBalance() {
        System.out.printf("Current Balance: $%.2f\n", account.getBalance());
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: $");
        double amount = scanner.nextDouble();
        if (account.deposit(amount)) {
            System.out.printf("Deposited $%.2f successfully.\n", amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: $");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.printf("Withdrew $%.2f successfully.\n", amount);
        } else {
            System.out.println("Insufficient funds or invalid amount.");
        }
    }

    public static void main(String[] args) {
        
        bank_account my_account = new bank_account(1000);

        // Create an ATM instance and pass the bank account to it
        codsoft_task3 atm = new codsoft_task3(my_account);

        // Show the ATM menu
        atm.showMenu();
    }
}
 class bank_account {
    private double balance;

    public bank_account(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

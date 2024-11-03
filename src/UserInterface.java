import java.util.Scanner;

public class UserInterface {
    private Account[] accounts = new Account[10]; // Adjust size as needed
    private int accountCount = 0;
    private Scanner scanner = new Scanner(System.in);

    public void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        int accountNumber = 1000 + accountCount; // Unique account number generation
        Account newAccount = new Account(accountNumber, name, initialDeposit, email, phoneNumber);
        accounts[accountCount] = newAccount;
        accountCount++;

        System.out.println("Account created successfully with Account Number: " + accountNumber);
    }

    public void performDeposit() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        Account account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void performWithdrawal() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        Account account = findAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void showAccountDetails() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();

        Account account = findAccount(accountNumber);
        if (account != null) {
            account.displayAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

    public void updateContact() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline
        System.out.print("Enter new email address: ");
        String email = scanner.nextLine();
        System.out.print("Enter new phone number: ");
        String phoneNumber = scanner.nextLine();

        Account account = findAccount(accountNumber);
        if (account != null) {
            account.updateContactDetails(email, phoneNumber);
        } else {
            System.out.println("Account not found.");
        }
    }

    private Account findAccount(int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        return null;
    }

    public void mainMenu() {
        int choice;
        do {
            System.out.println("\nWelcome to the Banking Application!");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Update contact details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> createAccount();
                case 2 -> performDeposit();
                case 3 -> performWithdrawal();
                case 4 -> showAccountDetails();
                case 5 -> updateContact();
                case 6 -> System.out.println("Exiting application. Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }
}

public class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private String email;
    private String phoneNumber;

    public Account(int accountNumber, String accountHolderName, double balance, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Invalid or insufficient balance for withdrawal.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
    }

    public void updateContactDetails(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        System.out.println("Contact details updated.");
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}

package packJava;
public class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;
    public BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited:" + amount);
        } else {
            System.out.println("Invalid");
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn:" + amount);
        } else {
            System.out.println("Insufficient or invalid ");
        }
    }
    public void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current" + balance);
    }
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("Pradeep Chauhan", "1234567890", 1000.0);

        myAccount.displayBalance();
        myAccount.deposit(500.0);
        myAccount.withdraw(200.0);
        myAccount.withdraw(2000.0);
        myAccount.displayBalance();
    }
}

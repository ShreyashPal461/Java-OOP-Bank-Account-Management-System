public class CheckingAccount extends BankAccount {

    // Private field
    private double overdraftLimit;

    // Constructor
    public CheckingAccount(String accountNumber, String accountHolderName, double overdraftLimit) {
        super(accountNumber, accountHolderName);
        this.overdraftLimit = overdraftLimit;
    }

    // Override withdraw method
    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return;
        }

        if (getBalance() - amount < -overdraftLimit) {
            System.out.println("Overdraft limit exceeded.");
        } else {
            setBalance(getBalance() - amount);
            if (getBalance() < 0) {
                System.out.println("Overdraft used. Withdrawn: $" + amount);
            } else {
                System.out.println("Withdrawn: $" + amount);
            }
        }
    }

    // Override getAccountDetails
    @Override
    public String getAccountDetails() {
        return "Checking Account #" + getAccountNumber() +
                ", Balance: $" + String.format("%.2f", getBalance()) +
                ", Limit: $" + String.format("%.2f", overdraftLimit);
    }
}

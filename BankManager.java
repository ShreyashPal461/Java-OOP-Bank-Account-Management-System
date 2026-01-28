import java.util.ArrayList;

public class BankManager {

    public static void main(String[] args) {

        // Polymorphism: parent reference
        ArrayList<BankAccount> accounts = new ArrayList<>();

        // Create accounts
        SavingsAccount savings = new SavingsAccount("12345", "Alice", 0.02);
        CheckingAccount checking = new CheckingAccount("67890", "Bob", 500.00);

        // Add to list
        accounts.add(savings);
        accounts.add(checking);

        // Display initial details
        System.out.println("---- Initial Account Details ----");
        for (BankAccount account : accounts) {
            System.out.println(account.getAccountDetails());
        }

        // Perform transactions
        System.out.println("\n---- Transactions ----");
        savings.deposit(200);
        checking.withdraw(100);

        // Apply interest (casting)
        if (savings instanceof SavingsAccount) {
            savings.applyInterest();
        }

        // Display final details
        System.out.println("\n---- Final Account Details ----");
        for (BankAccount account : accounts) {
            System.out.println(account.getAccountDetails());
        }
    }
}

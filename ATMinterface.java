import java.util.*;

public class ATMinterface {

    private static double balance = 1000.0;

    private static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean option1 = true;

        System.out.println("Welcome to our ATM interface!");

        while (option1) {
            System.out.println("\nPlease select an option:\n1. Check balance\n2. Deposit\n3. Withdraw\n4. Transfer\n5. Transaction history\n6. Exit");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.printf("Your balance is %.2f\n", balance);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double Amount = sc.nextDouble();
                    deposit(Amount);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdraw = sc.nextDouble();
                    withdraw(withdraw);
                    break;

                case 4:
                    System.out.print("Enter amount to transfer: ");
                    double transfer = sc.nextDouble();
                    System.out.print("Enter recipient account number: ");
                    String recipient = sc.next();
                    transfer(transfer, recipient);
                    break;

                case 5:
                    displayTransactionHistory();
                    break;

                case 6:
                    option1 = false;
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid selected option");
                    break;
            }
        }
    }
    private static void deposit(double amount) {
        balance += amount;
        String transaction = String.format("Deposited %.2f. \nNew balance: %.2f", amount, balance);
        transactionHistory.add(transaction);
        System.out.println(transaction);
    }
    private static void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            String transaction = String.format("Withdrew %.2f. \nNew balance: %.2f", amount, balance);
            transactionHistory.add(transaction);
            System.out.println(transaction);
        }
    }
    private static void transfer(double amount, String recipient) {
        if (amount > balance) {
            System.out.println("Sorry, Your balance is insufficient");
        } else {
            balance -= amount;
            String transaction = String.format("Transferred %.2f to %s. \nNew balance: %.2f", amount, recipient, balance);
            transactionHistory.add(transaction);
            System.out.println(transaction);
        }
    }
    private static void displayTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}
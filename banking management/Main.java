import java.util.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static class Account {
        private String accountNumber;
        private double balance;

        public Account(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public double getBalance() {
            return balance;
        }

        public void debit(double amount) {
            if (amount <= balance) {
                balance -= amount;
            } else {
                System.out.println("Insufficient funds");
            }
        }

        public void credit(double amount) {
            balance += amount;
        }
    }

    private HashMap<String, Account> accounts = new HashMap<>();

    public void addAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, new Account(accountNumber, initialBalance));
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public static void main(String[] args) {
        Main bank = new Main();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Account");
            System.out.println("2. Debit");
            System.out.println("3. Credit");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.next();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    bank.addAccount(accountNumber, initialBalance);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    System.out.print("Enter amount to debit: ");
                    double debitAmount = scanner.nextDouble();
                    Account debitAccount = bank.getAccount(accountNumber);
                    if (debitAccount != null) {
                        debitAccount.debit(debitAmount);
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    System.out.print("Enter amount to credit: ");
                    double creditAmount = scanner.nextDouble();
                    Account creditAccount = bank.getAccount(accountNumber);
                    if (creditAccount != null) {
                        creditAccount.credit(creditAmount);
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    Account balanceAccount = bank.getAccount(accountNumber);
                    if (balanceAccount != null) {
                        System.out.println("Balance: " + balanceAccount.getBalance());
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
}
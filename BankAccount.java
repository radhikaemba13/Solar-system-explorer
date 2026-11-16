import java.util.Scanner;

class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    
    BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    
    void deposit(double amount) {
        balance = balance + amount;
    }

    
    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    
    void display() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Balance : Rs." + balance);
    }

    public static void main(String[] args) {

        System.out.println("Name : Inbakumar");
        System.out.println("Reg No : RA2512701010010");
        System.out.println();

        Scanner sc = new Scanner(System.in);

        int accountNumber = sc.nextInt();
        String name = sc.next();
        double balance = sc.nextDouble();

        BankAccount account =
            new BankAccount(accountNumber, name, balance);

        double depositAmount = sc.nextDouble();
        account.deposit(depositAmount);

        double withdrawAmount = sc.nextDouble();
        account.withdraw(withdrawAmount);

        account.display();

        sc.close();
    }
}
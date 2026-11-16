import java.util.Scanner;

interface Payment {
    void makePayment(double amount);
}

class UPI implements Payment {
    public void makePayment(double amount) {
        System.out.println("Payment Method : UPI");
        System.out.println("Amount Paid : Rs." + amount);
    }
}

class CreditCard implements Payment {
    public void makePayment(double amount) {
        System.out.println("Payment Method : Credit Card");
        System.out.println("Amount Paid : Rs." + amount);
    }
}

class NetBanking implements Payment {
    public void makePayment(double amount) {
        System.out.println("Payment Method : Net Banking");
        System.out.println("Amount Paid : Rs." + amount);
    }
}

public class PaymentDemo {
    public static void main(String[] args) {

        System.out.println("Name : Inbakumar");
        System.out.println("Reg No : RA2512701010010");
        System.out.println();

        Scanner sc = new Scanner(System.in);

        System.out.println("1. UPI");
        System.out.println("2. Credit Card");
        System.out.println("3. Net Banking");

        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();

        Payment payment;

        if (choice == 1) {
            payment = new UPI();
        } 
        else if (choice == 2) {
            payment = new CreditCard();
        } 
        else if (choice == 3) {
            payment = new NetBanking();
        } 
        else {
            System.out.println("Invalid Choice");
            sc.close();
            return;
        }

        payment.makePayment(amount);

        sc.close();
    }
}
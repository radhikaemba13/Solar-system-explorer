import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter price of product 1: ");
        double p1 = sc.nextDouble();

        System.out.print("Enter price of product 2: ");
        double p2 = sc.nextDouble();

        System.out.println("Total: " + (p1 + p2));
        System.out.println("Difference: " + Math.abs(p1 - p2));
        System.out.println("Product: " + (p1 * p2));
        System.out.println("Quotient: " + (p1 / p2));
        System.out.println("Remainder: " + (p1 % p2));

        sc.close();
    }
}

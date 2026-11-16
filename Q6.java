import java.util.Scanner;

public class Q6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter seat number: ");
        int seat = sc.nextInt();

        if (seat % 2 == 0) {
            System.out.println("Even-numbered counter");
        } else {
            System.out.println("Odd-numbered counter");
        }

        sc.close();
    }
}
import java.util.Scanner;

public class Q5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter score 1: ");
        int s1 = sc.nextInt();

        System.out.print("Enter score 2: ");
        int s2 = sc.nextInt();

        System.out.print("Enter score 3: ");
        int s3 = sc.nextInt();

        int highest = Math.max(s1, Math.max(s2, s3));

        System.out.println("Highest score: " + highest);

        sc.close();
    }
}

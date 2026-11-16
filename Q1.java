import java.util.Scanner;

public class Q1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the name of the student:");
        String name = sc.nextLine();

        System.out.println("enter the roll number of the student:");
        int rollNumber = sc.nextInt();
        sc.nextLine();

        System.out.println("enter the Department of the student:");
        String dept = sc.nextLine();

        System.out.println("enter the college name of the student:");
        String collegeName = sc.nextLine();

        System.out.println("--------------------------------");
        System.out.println("Student Details:");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Department: " + dept);
        System.out.println("College Name: " + collegeName);
        System.out.println("--------------------------------");

        sc.close();
    }
}
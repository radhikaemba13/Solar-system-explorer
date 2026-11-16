import java.util.Scanner;

class Student {
    String name;
    int rollNo;

    // Constructor
    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    // Method to display student details
    void display() {
        System.out.println("\nStudent Details:");
        System.out.println("Name      : " + name);
        System.out.println("Roll No   : " + rollNo);
    }
}

public class inba {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();

        // Create Student object
        Student s = new Student(name, rollNo);

        // Display student details
        s.display();

        sc.close();
    }
}
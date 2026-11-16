class Student {
    String name;
    int age;

    // Constructor
    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display student details
    void display() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
        System.out.println();
    }
}

public class student2 {
    public static void main(String[] args) {

        // Create two student objects
        Student s1 = new Student("Inbakumar", 18);
        Student s2 = new Student("Rahul", 19);

        // Display details
        System.out.println("Student 1 Details:");
        s1.display();

        System.out.println("Student 2 Details:");
        s2.display();
    }
}
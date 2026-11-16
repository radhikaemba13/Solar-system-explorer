import student.Student;
import course.Course;

public class Mainn {
    public static void main(String[] args) {

        Student s = new Student(101, "Inbakumar", "Artificial Intelligence");
        Course c = new Course(501, "Data Structures", 4);

        System.out.println("===== COLLEGE MANAGEMENT SYSTEM =====");

        System.out.println("\nStudent Details");
        s.display();

        System.out.println("\nCourse Details");
        c.display();
    }
}
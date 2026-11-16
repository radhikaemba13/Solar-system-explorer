import java.util.*;

class StudentEligibility {

    static class Student {
        String name;
        boolean python;
        boolean dataStructures;

        Student(String name, boolean python,
                boolean dataStructures) {
            this.name = name;
            this.python = python;
            this.dataStructures = dataStructures;
        }

        boolean eligible() {
            return python && dataStructures;
        }
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("inbakumar", true, true),
            new Student("Bala", true, false),
            new Student("Charan", true, true),
            new Student("Divya", false, true)
        );

        System.out.println(
            "Eligible students for advanced programming:");

        for (Student s : students) {
            if (s.eligible()) {
                System.out.println(s.name);
            }
        }
    }
}
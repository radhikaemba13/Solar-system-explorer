import java.util.*;

class EmployeePromotion {

    static class Employee {
        String name;
        int experience;
        boolean trainingCompleted;
        int rating;

        Employee(String name, int experience,
                 boolean trainingCompleted, int rating) {
            this.name = name;
            this.experience = experience;
            this.trainingCompleted = trainingCompleted;
            this.rating = rating;
        }

        boolean eligibleForPromotion() {
            return experience >= 5
                && trainingCompleted
                && rating >= 4;
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("INBAKUMAR", 6, true, 5),
            new Employee("Priya", 3, true, 4),
            new Employee("Kumar", 8, false, 5),
            new Employee("MOHIT", 7, true, 4)
        );

        System.out.println("Employees eligible for promotion:");

        for (Employee e : employees) {
            if (e.eligibleForPromotion()) {
                System.out.println(e.name);
            }
        }
    }
}
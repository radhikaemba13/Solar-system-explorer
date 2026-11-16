
class Employee {
    String name;
    int id;
    String department;

    public static void main(String[] args) {
        Employee emp1 = new Employee();
        emp1.name = "Eve";
        emp1.id = 1001;
        emp1.department = "HR";

        Employee emp2 = new Employee();
        emp2.name = "Frank";
        emp2.id = 1002;
        emp2.department = "IT";

        System.out.println("Employee 1 -> Name: " + emp1.name + ", ID: " + emp1.id + ", Dept: " + emp1.department);
        System.out.println("Employee 2 -> Name: " + emp2.name + ", ID: " + emp2.id + ", Dept: " + emp2.department);
    }
}
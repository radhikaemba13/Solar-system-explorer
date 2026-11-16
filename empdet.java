import java.util.Scanner;

class Employee {
    int id;
    String name;
    int salary;

    
    Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    
    void display() {
        System.out.println("Employee ID : " + id);
        System.out.println("Employee Name : " + name);
        System.out.println("Salary : " + salary);
    }
}

public class empdet {
    public static void empdet(String[] args) {

        Scanner sc = new Scanner(System.in);

        int id = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        int salary = sc.nextInt();

        // Creating object using constructor
        Employee emp = new Employee(id, name, salary);

        emp.display();

        sc.close();
    }
}
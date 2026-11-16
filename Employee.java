class Employee {
    int employeeId;
    String name;
    double monthlySalary;

    // Constructor
    Employee(int employeeId, String name, double monthlySalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    // Display employee details
    void display() {
        double annualSalary = monthlySalary * 12;
        double bonus;
        String eligibility;

        // Check bonus eligibility
        if (monthlySalary >= 30000) {
            bonus = annualSalary * 0.10;
            eligibility = "Eligible for Bonus";
        } else {
            bonus = 0;
            eligibility = "Not Eligible for Bonus";
        }

        System.out.println("Employee ID : " + employeeId);
        System.out.println("Name : " + name);
        System.out.println("Monthly Salary : Rs." + monthlySalary);
        System.out.println("Annual Salary : Rs." + annualSalary);
        System.out.println("Bonus : Rs." + bonus);
        System.out.println("Eligibility : " + eligibility);
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("Name : Inbakumar");
        System.out.println("Reg No : RA2512701010010");
        System.out.println();

        // Array of Employee objects
        Employee[] employees = new Employee[5];

        employees[0] = new Employee(101, "Rahul", 45000);
        employees[1] = new Employee(102, "Arun", 25000);
        employees[2] = new Employee(103, "Priya", 60000);
        employees[3] = new Employee(104, "Kumar", 30000);
        employees[4] = new Employee(105, "Anitha", 20000);

        // Loop to display all employees
        for (int i = 0; i < 5; i++) {
            employees[i].display();
        }
    }
}
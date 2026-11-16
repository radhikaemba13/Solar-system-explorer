class Student {
    String name;
    int rollNumber;
    String department;

    public static void main(String[] args) {
        // Create an object
        Student student1 = new Student();
        
        // Store details
        student1.name = "E.R.INBA KUMAR";
        student1.rollNumber = 10;
        student1.department = "Artificial Intelligence";
        
        // Display details
        System.out.println("--- Student Details ---");
        System.out.println("Name: " + student1.name);
        System.out.println("Roll Number: " + student1.rollNumber);
        System.out.println("Department: " + student1.department);
    }
}
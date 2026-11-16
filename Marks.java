class Marks {
    double subject1;
    double subject2;
    double subject3;

    void calculateAndDisplay() {
        double total = subject1 + subject2 + subject3;
        double average = total / 3.0;
        
        System.out.println("Subject 1: " + subject1);
        System.out.println("Subject 2: " + subject2);
        System.out.println("Subject 3: " + subject3);
        System.out.println("Total Marks: " + total);
        System.out.println("Average Marks: " + average);
    }

    public static void main(String[] args) {
        Marks studentMarks = new Marks();
        studentMarks.subject1 = 69.5;
        studentMarks.subject2 = 94.0;
        studentMarks.subject3 = 67.0;
        
        studentMarks.calculateAndDisplay();
    }
}
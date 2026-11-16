import doctor.Doctor;
import patient.Patient;

public class Hospital {
    public static void main(String[] args) {

        Doctor d1 = new Doctor(101, "Dr. Kumar", "Cardiologist", 800);
        Doctor d2 = new Doctor(102, "Dr. Priya", "Dermatologist", 600);

        Patient p1 = new Patient(201, "Arun", "Heart Disease", 45);
        Patient p2 = new Patient(202, "Rahul", "Skin Allergy", 25);
        Patient p3 = new Patient(203, "Vijay", "Heart Disease", 50);

        int d1Patients = 0;
        int d2Patients = 0;

        System.out.println("===== HOSPITAL MANAGEMENT SYSTEM =====");

        System.out.println("\nPatient 1");
        p1.display();
        System.out.println("Treating Doctor:");
        d1.display();
        d1Patients++;

        System.out.println("\nPatient 2");
        p2.display();
        System.out.println("Treating Doctor:");
        d2.display();
        d2Patients++;

        System.out.println("\nPatient 3");
        p3.display();
        System.out.println("Treating Doctor:");
        d1.display();
        d1Patients++;

        double total1 = d1Patients * d1.getConsultationFee();
        double total2 = d2Patients * d2.getConsultationFee();

        System.out.println("\n===== TOTAL CONSULTATION FEE =====");
        System.out.println(d1.getName() + " : Rs." + total1);
        System.out.println(d2.getName() + " : Rs." + total2);
    }
}
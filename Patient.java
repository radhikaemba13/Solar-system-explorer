class Patient {
    String patientName;
    double consultationFee;

    // Parameterized constructor
    Patient(String patientName, double consultationFee) {
        this.patientName = patientName;
        this.consultationFee = consultationFee;
    }

    // Method with argument to calculate final amount
    double calculateFinalAmount(double fee) {
        double discount;

        if (fee >= 2000) {
            discount = fee * 0.10;
        } else {
            discount = fee * 0.05;
        }

        return fee - discount;
    }

    // Method to display details
    void display() {
        double discount;

        if (consultationFee >= 2000) {
            discount = consultationFee * 0.10;
        } else {
            discount = consultationFee * 0.05;
        }

        double finalAmount = calculateFinalAmount(consultationFee);

        System.out.println("Patient Name : " + patientName);
        System.out.println("Original Consultation Fee : Rs." + consultationFee);
        System.out.println("Discount : Rs." + discount);
        System.out.println("Final Amount : Rs." + finalAmount);
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("Name : Inbakumar");
        System.out.println("Reg No : RA2512701010010");
        System.out.println();

        // Array of Patient objects
        Patient[] patients = new Patient[5];

        patients[0] = new Patient("Rahul", 3000);
        patients[1] = new Patient("Arun", 1500);
        patients[2] = new Patient("Priya", 2500);
        patients[3] = new Patient("Kumar", 1800);
        patients[4] = new Patient("Anitha", 4000);

        // Loop to process all patients
        for (int i = 0; i < 5; i++) {
            patients[i].display();
        }
    }
}
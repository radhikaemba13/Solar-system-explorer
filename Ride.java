class Ride {
    int rideNumber;
    String rideName;

    // Constructor
    Ride(int rideNumber, String rideName) {
        this.rideNumber = rideNumber;
        this.rideName = rideName;
    }

    void display() {
        System.out.print(rideName + " : ");

        // Nested for loop to print *
        for (int j = 1; j <= rideNumber; j++) {
            System.out.print("*");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("Name : Inbakumar");
        System.out.println("Reg No : RA2512701010010");
        System.out.println();

        // Array of Ride objects
        Ride[] rides = new Ride[5];

        rides[0] = new Ride(1, "Roller Coaster");
        rides[1] = new Ride(2, "Ferris Wheel");
        rides[2] = new Ride(3, "Bumper Cars");
        rides[3] = new Ride(4, "Water Ride");
        rides[4] = new Ride(5, "Haunted House");

        // For loop to access each ride
        for (int i = 0; i < 5; i++) {
            rides[i].display();
        }
    }
}
import java.util.Scanner;
class Car {
    String model;
    int price;

    
    Car() {
        model = "Not Entered";
        price = 0;
    }

    
    Car(String model) {
        this.model = model;
        price = 0;
    }

    
    Car(String model, int price) {
        this.model = model;
        this.price = price;
    }

    void display() {
        System.out.println("Model : " + model);
        System.out.println("Price : " + price);
        System.out.println("Name : Inbakumar");
        System.out.println("Reg No : RA2512701010010");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Car c1 = new Car();
        Car c2 = new Car("Honda City");
        Car c3 = new Car("BMW", 5000000);

        System.out.println("Car 1:");
        c1.display();

        System.out.println("Car 2:");
        c2.display();

        System.out.println("Car 3:");
        c3.display();

        sc.close();
    }
}
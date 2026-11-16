import java.util.Scanner;

class Product {
    int productId;
    String productName;
    double price;
    int quantity;

    // Constructor
    Product(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    void display() {
        double totalPrice = price * quantity;
        double discount;

        // Conditional control structure
        if (totalPrice >= 5000) {
            discount = totalPrice * 0.10;
        } else {
            discount = totalPrice * 0.05;
        }

        double finalPrice = totalPrice - discount;

        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + productName);
        System.out.println("Total Price: Rs." + totalPrice);
        System.out.println("Discount: Rs." + discount);
        System.out.println("Final Price: Rs." + finalPrice);
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("Name : Inbakumar");
        System.out.println("Reg No : RA2512701010010");
        System.out.println();

        Scanner sc = new Scanner(System.in);

        // Array of 5 Product objects
        Product[] products = new Product[5];

        // Looping to read product details
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details for Product " + (i + 1) + ":");

            System.out.print("ID: ");
            int id = sc.nextInt();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            products[i] = new Product(id, name, price, quantity);
            System.out.println();
        }

        // Display details of all products
        System.out.println("----- PRODUCT BILL -----");

        for (int i = 0; i < 5; i++) {
            products[i].display();
        }

        sc.close();
    }
}
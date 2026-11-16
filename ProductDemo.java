import java.util.Scanner;

abstract class Product {
    int productId;
    String name;
    double price;

    Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    abstract double calculateDiscount();

    void display() {
        double discount = calculateDiscount();
        double finalPrice = price - discount;

        System.out.println("Product ID : " + productId);
        System.out.println("Product Name : " + name);
        System.out.println("Price : Rs." + price);
        System.out.println("Discount : Rs." + discount);
        System.out.println("Final Price : Rs." + finalPrice);
        System.out.println();
    }
}

class Electronics extends Product {

    Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    double calculateDiscount() {
        return price * 0.10;
    }
}

class Clothing extends Product {

    Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    double calculateDiscount() {
        return price * 0.20;
    }
}

class Books extends Product {

    Books(int id, String name, double price) {
        super(id, name, price);
    }

    double calculateDiscount() {
        return price * 0.15;
    }
}

public class ProductDemo {

    public static void main(String[] args) {

        System.out.println("Name : Inbakumar");
        System.out.println("Reg No : RA2512701010010");
        System.out.println();

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Electronics");
        System.out.println("2. Clothing");
        System.out.println("3. Books");

        System.out.print("Enter product type: ");
        int choice = sc.nextInt();

        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Product Name: ");
        String name = sc.next();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        Product product;

        if (choice == 1) {
            product = new Electronics(id, name, price);
        }
        else if (choice == 2) {
            product = new Clothing(id, name, price);
        }
        else if (choice == 3) {
            product = new Books(id, name, price);
        }
        else {
            System.out.println("Invalid Choice");
            sc.close();
            return;
        }

        System.out.println();
        product.display();

        sc.close();
    }
}
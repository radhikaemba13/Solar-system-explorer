import java.sql.*;
import java.util.Scanner;

public class BookManagementJDBC {

    static final String URL = "jdbc:mysql://localhost:3306/library";
    static final String USER = "root";
    static final String PASSWORD = "root";

    static Connection con;
    static Scanner sc = new Scanner(System.in);

    public static void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(URL, USER, PASSWORD);

            System.out.println("Database connected successfully.");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            System.out.println("Add MySQL Connector/J .jar file to BlueJ.");
        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            System.out.println(e.getMessage());
        }
    }
    
    public static void insertBook() {

        String sql = "INSERT INTO Book " +
                     "(BookID, Title, Author, Price, Availability) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Book Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            ps.setInt(1, id);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setDouble(4, price);
            ps.setString(5, "Available");

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Book inserted successfully.");
            }

            ps.close();

        } catch (SQLException e) {
            System.out.println("Error inserting book.");
            System.out.println(e.getMessage());
        }
    }

    public static void searchBook() {

        String sql = "SELECT * FROM Book WHERE BookID = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            System.out.print("Enter Book ID to search: ");
            int id = sc.nextInt();

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\nBook Details");
                System.out.println("------------------------");
                System.out.println("Book ID      : " + rs.getInt("BookID"));
                System.out.println("Title        : " + rs.getString("Title"));
                System.out.println("Author       : " + rs.getString("Author"));
                System.out.println("Price        : Rs." + rs.getDouble("Price"));
                System.out.println("Availability : " +
                                   rs.getString("Availability"));

            } else {
                System.out.println("Book not found.");
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error searching book.");
            System.out.println(e.getMessage());
        }
    }

    public static void displayAvailableBooks() {

        String sql = "SELECT * FROM Book WHERE Availability = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, "Available");

            ResultSet rs = ps.executeQuery();

            System.out.println("\nAvailable Books");
            System.out.println("------------------------------------------------");
            System.out.printf("%-10s %-20s %-20s %-10s%n",
                              "Book ID", "Title", "Author", "Price");
            System.out.println("------------------------------------------------");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.printf("%-10d %-20s %-20s Rs.%-7.2f%n",
                        rs.getInt("BookID"),
                        rs.getString("Title"),
                        rs.getString("Author"),
                        rs.getDouble("Price"));
            }

            if (!found) {
                System.out.println("No available books.");
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error displaying books.");
            System.out.println(e.getMessage());
        }
    }

    
    public static void issueBook() {

        String checkSql =
            "SELECT Availability FROM Book WHERE BookID = ?";

        String updateSql =
            "UPDATE Book SET Availability = ? WHERE BookID = ?";

        try {

            System.out.print("Enter Book ID to issue: ");
            int id = sc.nextInt();

            // Check availability
            PreparedStatement checkPs =
                con.prepareStatement(checkSql);

            checkPs.setInt(1, id);

            ResultSet rs = checkPs.executeQuery();

            if (!rs.next()) {

                System.out.println("Book not found.");

            } else {

                String availability =
                    rs.getString("Availability");

                if (availability.equalsIgnoreCase("Available")) {

                    PreparedStatement updatePs =
                        con.prepareStatement(updateSql);

                    updatePs.setString(1, "Issued");
                    updatePs.setInt(2, id);

                    int rows = updatePs.executeUpdate();

                    if (rows > 0) {
                        System.out.println(
                            "Book issued successfully."
                        );
                    }

                    updatePs.close();

                } else {

                    System.out.println(
                        "Book is already issued."
                    );
                }
            }

            rs.close();
            checkPs.close();

        } catch (SQLException e) {
            System.out.println("Error issuing book.");
            System.out.println(e.getMessage());
        }
    }

    
    public static void main(String[] args) {

        connect();

        if (con == null) {
            return;
        }

        int choice;

        do {

            System.out.println("\n===== BOOK MANAGEMENT SYSTEM =====");
            System.out.println("1. Insert Book");
            System.out.println("2. Search Book by ID");
            System.out.println("3. Display Available Books");
            System.out.println("4. Issue Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    insertBook();
                    break;

                case 2:
                    searchBook();
                    break;

                case 3:
                    displayAvailableBooks();
                    break;

                case 4:
                    issueBook();
                    break;

                case 5:
                    System.out.println(
                        "Thank you for using Book Management System."
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice. Try again."
                    );
            }

        } while (choice != 5);

        try {
            con.close();
            sc.close();
        } catch (SQLException e) {
            System.out.println("Error closing database.");
        }
    }
}
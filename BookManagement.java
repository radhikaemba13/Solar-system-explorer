import java.sql.*;
import java.util.Scanner;

public class BookManagement {

    // MySQL connection details
    static final String URL =
        "jdbc:mysql://127.0.0.1:3306/library";

    static final String USER = "root";

    // CHANGE THIS to the password you create during MySQL installation
    static final String PASSWORD = "Shanks@2007";

    static Scanner sc = new Scanner(System.in);
    static Connection con;

    // Connect to MySQL
    public static void connectDatabase() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                URL, USER, PASSWORD
            );

            System.out.println("Database connected successfully!");

        } catch (ClassNotFoundException e) {

            System.out.println(
                "MySQL Connector/J not found."
            );

        } catch (SQLException e) {

            System.out.println(
                "Database connection failed!"
            );

            System.out.println(
                "Error: " + e.getMessage()
            );
        }
    }

    // Insert a new book
    public static void insertBook() {

        String sql =
            "INSERT INTO Book " +
            "(BookID, Title, Author, Price, Availability) " +
            "VALUES (?, ?, ?, ?, ?)";

        try {

            PreparedStatement ps =
                con.prepareStatement(sql);

            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Book Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            System.out.print("Enter Price: ");
            double price = sc.nextDouble();

            ps.setInt(1, id);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setDouble(4, price);
            ps.setString(5, "Available");

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println(
                    "Book inserted successfully!"
                );
            }

            ps.close();

        } catch (SQLException e) {

            System.out.println(
                "Error inserting book: " +
                e.getMessage()
            );
        }
    }

    // Search book by ID
    public static void searchBook() {

        String sql =
            "SELECT * FROM Book WHERE BookID = ?";

        try {

            PreparedStatement ps =
                con.prepareStatement(sql);

            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\nBook Details");
                System.out.println("--------------------------");

                System.out.println(
                    "Book ID      : " +
                    rs.getInt("BookID")
                );

                System.out.println(
                    "Title        : " +
                    rs.getString("Title")
                );

                System.out.println(
                    "Author       : " +
                    rs.getString("Author")
                );

                System.out.println(
                    "Price        : Rs." +
                    rs.getDouble("Price")
                );

                System.out.println(
                    "Availability : " +
                    rs.getString("Availability")
                );

            } else {

                System.out.println(
                    "Book not found!"
                );
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {

            System.out.println(
                "Error searching book: " +
                e.getMessage()
            );
        }
    }

    // Display all available books
    public static void displayAvailableBooks() {

        String sql =
            "SELECT * FROM Book " +
            "WHERE Availability = ?";

        try {

            PreparedStatement ps =
                con.prepareStatement(sql);

            ps.setString(1, "Available");

            ResultSet rs = ps.executeQuery();

            System.out.println("\nAvailable Books");
            System.out.println(
                "---------------------------------------------"
            );

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println(
                    "Book ID      : " +
                    rs.getInt("BookID")
                );

                System.out.println(
                    "Title        : " +
                    rs.getString("Title")
                );

                System.out.println(
                    "Author       : " +
                    rs.getString("Author")
                );

                System.out.println(
                    "Price        : Rs." +
                    rs.getDouble("Price")
                );

                System.out.println(
                    "---------------------------------------------"
                );
            }

            if (!found) {

                System.out.println(
                    "No available books found."
                );
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {

            System.out.println(
                "Error displaying books: " +
                e.getMessage()
            );
        }
    }

    // Issue a book
    public static void issueBook() {

        String checkSQL =
            "SELECT Availability FROM Book " +
            "WHERE BookID = ?";

        String updateSQL =
            "UPDATE Book SET Availability = ? " +
            "WHERE BookID = ?";

        try {

            System.out.print("Enter Book ID to issue: ");
            int id = sc.nextInt();

            // Check book availability
            PreparedStatement checkPS =
                con.prepareStatement(checkSQL);

            checkPS.setInt(1, id);

            ResultSet rs =
                checkPS.executeQuery();

            if (!rs.next()) {

                System.out.println(
                    "Book not found!"
                );

            } else {

                String availability =
                    rs.getString("Availability");

                if (availability.equalsIgnoreCase(
                    "Available")) {

                    PreparedStatement updatePS =
                        con.prepareStatement(updateSQL);

                    updatePS.setString(1, "Issued");
                    updatePS.setInt(2, id);

                    int result =
                        updatePS.executeUpdate();

                    if (result > 0) {

                        System.out.println(
                            "Book issued successfully!"
                        );
                    }

                    updatePS.close();

                } else {

                    System.out.println(
                        "Book is already issued."
                    );
                }
            }

            rs.close();
            checkPS.close();

        } catch (SQLException e) {

            System.out.println(
                "Error issuing book: " +
                e.getMessage()
            );
        }
    }

    // Main method
    public static void main(String[] args) {

        connectDatabase();

        // Stop if connection failed
        if (con == null) {

            System.out.println(
                "\nPlease make sure MySQL Server is running."
            );

            return;
        }

        int choice;

        do {

            System.out.println(
                "\n===== BOOK MANAGEMENT SYSTEM ====="
            );

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
                        "Thank you!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice!"
                    );
            }

        } while (choice != 5);

        try {

            con.close();

        } catch (SQLException e) {

            System.out.println(
                "Error closing database."
            );
        }

        sc.close();
    }
}
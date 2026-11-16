import javax.swing.*;
import java.awt.*;

public class EmployeeManagementPortal {

    
    static class EmployeeModel {

        private String username = "admin";
        private String password = "admin123";

        private String employeeId;
        private String employeeName;
        private String department;

        boolean validateLogin(String user, String pass) {
            return username.equals(user) &&
                   password.equals(pass);
        }

        boolean changePassword(
                String oldPassword,
                String newPassword,
                String confirmPassword) {

            if (!password.equals(oldPassword))
                return false;

            if (!newPassword.equals(confirmPassword))
                return false;

            password = newPassword;
            return true;
        }

        void addEmployee(
                String id,
                String name,
                String dept) {

            employeeId = id;
            employeeName = name;
            department = dept;
        }

        String getEmployeeDetails() {

            if (employeeId == null)
                return "No employee added";

            return "Employee ID: " + employeeId +
                   "\nName: " + employeeName +
                   "\nDepartment: " + department;
        }
    }

    
    static class LoginView extends JFrame {

        JTextField usernameField;
        JPasswordField passwordField;
        JButton loginButton;

        LoginView() {

            setTitle("Employee Management Portal");
            setSize(400, 250);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            setLayout(new GridLayout(3, 2, 10, 10));

            add(new JLabel("Username:"));

            usernameField = new JTextField();
            add(usernameField);

            add(new JLabel("Password:"));

            passwordField = new JPasswordField();
            add(passwordField);

            loginButton = new JButton("Login");
            add(loginButton);

            setLocationRelativeTo(null);
            setVisible(true);
        }
    }

    
    static class MainView extends JFrame {

        JMenuItem addEmployee;
        JMenuItem viewEmployee;
        JMenuItem changePassword;
        JMenuItem logout;
        JMenuItem exitApplication;

        MainView() {

            setTitle("Employee Management Portal");
            setSize(600, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JMenuBar menuBar = new JMenuBar();

            JMenu employee = new JMenu("Employee");
            JMenu tools = new JMenu("Tools");
            JMenu exit = new JMenu("Exit");

            addEmployee = new JMenuItem("Add Employee");
            viewEmployee = new JMenuItem("View Employee");
            changePassword = new JMenuItem("Change Password");

            logout = new JMenuItem("Logout");
            exitApplication = new JMenuItem("Exit Application");

            employee.add(addEmployee);
            employee.add(viewEmployee);

            tools.add(changePassword);

            exit.add(logout);
            exit.add(exitApplication);

            menuBar.add(employee);
            menuBar.add(tools);
            menuBar.add(exit);

            setJMenuBar(menuBar);

            add(new JLabel(
                "Welcome to Employee Management Portal",
                SwingConstants.CENTER));

            setLocationRelativeTo(null);
        }
    }

    
    static class Controller {

        EmployeeModel model;
        LoginView loginView;
        MainView mainView;

        Controller(EmployeeModel model, LoginView loginView) {

            this.model = model;
            this.loginView = loginView;

            loginView.loginButton.addActionListener(
                e -> login());
        }

        void login() {

            String username =
                loginView.usernameField.getText();

            String password =
                new String(
                    loginView.passwordField.getPassword());

            if (model.validateLogin(username, password)) {

                JOptionPane.showMessageDialog(
                    loginView,
                    "Login Successful");

                loginView.dispose();

                mainView = new MainView();
                mainView.setVisible(true);

                addListeners();

            } else {

                JOptionPane.showMessageDialog(
                    loginView,
                    "Invalid Username or Password");
            }
        }

        void addListeners() {

            mainView.addEmployee.addActionListener(
                e -> addEmployee());

            mainView.viewEmployee.addActionListener(
                e -> viewEmployee());

            mainView.changePassword.addActionListener(
                e -> changePassword());

            mainView.logout.addActionListener(
                e -> logout());

            mainView.exitApplication.addActionListener(
                e -> System.exit(0));
        }

        void addEmployee() {

            JTextField id = new JTextField();
            JTextField name = new JTextField();
            JTextField dept = new JTextField();

            JPanel panel = new JPanel(
                new GridLayout(3, 2));

            panel.add(new JLabel("Employee ID:"));
            panel.add(id);

            panel.add(new JLabel("Employee Name:"));
            panel.add(name);

            panel.add(new JLabel("Department:"));
            panel.add(dept);

            int result = JOptionPane.showConfirmDialog(
                mainView,
                panel,
                "Add Employee",
                JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {

                model.addEmployee(
                    id.getText(),
                    name.getText(),
                    dept.getText());

                JOptionPane.showMessageDialog(
                    mainView,
                    "Employee Added Successfully");
            }
        }

        void viewEmployee() {

            JOptionPane.showMessageDialog(
                mainView,
                model.getEmployeeDetails());
        }

        void changePassword() {

            JPasswordField oldPass =
                new JPasswordField();

            JPasswordField newPass =
                new JPasswordField();

            JPasswordField confirmPass =
                new JPasswordField();

            JPanel panel = new JPanel(
                new GridLayout(3, 2));

            panel.add(new JLabel("Old Password:"));
            panel.add(oldPass);

            panel.add(new JLabel("New Password:"));
            panel.add(newPass);

            panel.add(new JLabel("Confirm Password:"));
            panel.add(confirmPass);

            int result = JOptionPane.showConfirmDialog(
                mainView,
                panel,
                "Change Password",
                JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {

                boolean success =
                    model.changePassword(
                        new String(oldPass.getPassword()),
                        new String(newPass.getPassword()),
                        new String(confirmPass.getPassword()));

                if (success)
                    JOptionPane.showMessageDialog(
                        mainView,
                        "Password Changed Successfully");
                else
                    JOptionPane.showMessageDialog(
                        mainView,
                        "Invalid old password or passwords do not match");
            }
        }

        void logout() {

            mainView.dispose();

            LoginView newLogin =
                new LoginView();

            new Controller(model, newLogin);
        }
    }

    public static void main(String[] args) {

        EmployeeModel model =
            new EmployeeModel();

        LoginView view =
            new LoginView();

        new Controller(model, view);
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentRegistration extends JFrame {

    JTextField name, regno;
    JRadioButton male, female;
    JComboBox<String> dept;
    JButton submit;

    StudentRegistration() {

        setTitle("Student Registration");
        setSize(400, 350);
        setLayout(new GridLayout(5, 2, 10, 10));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new JLabel("Student Name:"));
        name = new JTextField();
        add(name);

        add(new JLabel("Register Number:"));
        regno = new JTextField();
        add(regno);

        add(new JLabel("Gender:"));

        JPanel panel = new JPanel();
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");

        ButtonGroup group = new ButtonGroup();
        group.add(male);
        group.add(female);

        panel.add(male);
        panel.add(female);
        add(panel);

        add(new JLabel("Department:"));

        String departments[] = {
            "CSE", "ECE", "EEE", "Mechanical", "Civil"
        };

        dept = new JComboBox<>(departments);
        add(dept);

        submit = new JButton("Submit");
        add(submit);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String gender = "";

                if (male.isSelected())
                    gender = "Male";
                else if (female.isSelected())
                    gender = "Female";

                JOptionPane.showMessageDialog(
                    StudentRegistration.this,
                    "Name: " + name.getText()
                    + "\nRegister No: " + regno.getText()
                    + "\nGender: " + gender
                    + "\nDepartment: " + dept.getSelectedItem()
                );
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new StudentRegistration();
    }
}
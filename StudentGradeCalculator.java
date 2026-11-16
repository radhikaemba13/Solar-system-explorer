import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentGradeCalculator {

    // MODEL
    static class StudentModel {
        private String name;
        private int mark1, mark2, mark3;

        public void setDetails(String name, int mark1, int mark2, int mark3) {
            this.name = name;
            this.mark1 = mark1;
            this.mark2 = mark2;
            this.mark3 = mark3;
        }

        public int getTotal() {
            return mark1 + mark2 + mark3;
        }

        public double getAverage() {
            return getTotal() / 3.0;
        }

        public String getGrade() {
            double avg = getAverage();

            if (avg >= 90)
                return "A";
            else if (avg >= 75)
                return "B";
            else if (avg >= 60)
                return "C";
            else if (avg >= 50)
                return "D";
            else
                return "F";
        }
    }

    
    static class StudentView extends JFrame {
        JTextField nameField;
        JTextField mark1Field;
        JTextField mark2Field;
        JTextField mark3Field;

        JButton calculateButton;

        JLabel totalLabel;
        JLabel averageLabel;
        JLabel gradeLabel;

        StudentView() {
            setTitle("Student Grade Calculator");
            setSize(400, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new GridLayout(7, 2, 10, 10));

            add(new JLabel("Student Name:"));
            nameField = new JTextField();
            add(nameField);

            add(new JLabel("Subject 1:"));
            mark1Field = new JTextField();
            add(mark1Field);

            add(new JLabel("Subject 2:"));
            mark2Field = new JTextField();
            add(mark2Field);

            add(new JLabel("Subject 3:"));
            mark3Field = new JTextField();
            add(mark3Field);

            calculateButton = new JButton("Calculate Result");
            add(calculateButton);
            add(new JLabel(""));

            add(new JLabel("Total:"));
            totalLabel = new JLabel();
            add(totalLabel);

            add(new JLabel("Average:"));
            averageLabel = new JLabel();
            add(averageLabel);

            add(new JLabel("Grade:"));
            gradeLabel = new JLabel();
            add(gradeLabel);

            setLocationRelativeTo(null);
            setVisible(true);
        }
    }

    
    static class StudentController {
        StudentModel model;
        StudentView view;

        StudentController(StudentModel model, StudentView view) {
            this.model = model;
            this.view = view;

            view.calculateButton.addActionListener(e -> calculateResult());
        }

        void calculateResult() {
            try {
                String name = view.nameField.getText();

                int m1 = Integer.parseInt(view.mark1Field.getText());
                int m2 = Integer.parseInt(view.mark2Field.getText());
                int m3 = Integer.parseInt(view.mark3Field.getText());

                model.setDetails(name, m1, m2, m3);

                view.totalLabel.setText(
                    String.valueOf(model.getTotal()));

                view.averageLabel.setText(
                    String.format("%.2f", model.getAverage()));

                view.gradeLabel.setText(model.getGrade());

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                    view, "Enter valid marks");
            }
        }
    }

    public static void main(String[] args) {
        StudentModel model = new StudentModel();
        StudentView view = new StudentView();

        new StudentController(model, view);
    }
}
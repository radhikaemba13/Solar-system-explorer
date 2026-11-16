import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class CourseManagement extends JFrame {

    JList<String> courseList;
    JTable table;
    DefaultTableModel model;
    CourseManagement() {

        setTitle("Student Course Management");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String courses[] = {
            "Java Programming",
            "Data Structures",
            "Database Management",
            "Computer Networks",
            "Operating Systems"
        };

        courseList = new JList<>(courses);
        JScrollPane listScroll = new JScrollPane(courseList);

        model = new DefaultTableModel(
            new String[]{"Student Name", "Course", "Status"}, 0
        );

        table = new JTable(model);
        JScrollPane tableScroll = new JScrollPane(table);

        JButton add = new JButton("Add Course");
        JButton remove = new JButton("Remove Course");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(add);
        buttonPanel.add(remove);

        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String course = courseList.getSelectedValue();

                if (course != null) {
                    model.addRow(
                        new Object[]{"Student", course, "Enrolled"}
                    );
                } else {
                    JOptionPane.showMessageDialog(
                        CourseManagement.this,
                        "Please select a course"
                    );
                }
            }
        });

        remove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int row = table.getSelectedRow();

                if (row != -1) {
                    model.removeRow(row);
                }
            }
        });

        add(listScroll, BorderLayout.WEST);
        add(tableScroll, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new CourseManagement();
    }
}
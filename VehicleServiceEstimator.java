import javax.swing.*;
import java.awt.*;

public class VehicleServiceEstimator {

    
    static class ServiceModel {

        public int calculateCost(
                boolean general,
                boolean oil,
                boolean brake,
                boolean battery) {

            int cost = 0;

            if (general)
                cost += 1000;

            if (oil)
                cost += 800;

            if (brake)
                cost += 1200;

            if (battery)
                cost += 500;

            return cost;
        }
    }

    
    static class ServiceView extends JFrame {

        JTextField registrationField;

        JRadioButton twoWheeler;
        JRadioButton car;

        JCheckBox generalService;
        JCheckBox oilChange;
        JCheckBox brakeService;
        JCheckBox batteryCheck;

        JButton calculateButton;

        JLabel resultLabel;

        ServiceView() {

            setTitle("Vehicle Service Cost Estimator");
            setSize(450, 450);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new GridLayout(10, 2, 10, 10));

            add(new JLabel("Registration Number:"));
            registrationField = new JTextField();
            add(registrationField);

            add(new JLabel("Vehicle Type:"));

            JPanel vehiclePanel = new JPanel();

            twoWheeler = new JRadioButton("Two Wheeler");
            car = new JRadioButton("Car");

            ButtonGroup group = new ButtonGroup();
            group.add(twoWheeler);
            group.add(car);

            vehiclePanel.add(twoWheeler);
            vehiclePanel.add(car);

            add(vehiclePanel);

            add(new JLabel("Services:"));
            add(new JLabel(""));

            generalService =
                new JCheckBox("General Service - Rs.1000");
            add(generalService);
            add(new JLabel(""));

            oilChange =
                new JCheckBox("Oil Change - Rs.800");
            add(oilChange);
            add(new JLabel(""));

            brakeService =
                new JCheckBox("Brake Service - Rs.1200");
            add(brakeService);
            add(new JLabel(""));

            batteryCheck =
                new JCheckBox("Battery Check - Rs.500");
            add(batteryCheck);
            add(new JLabel(""));

            calculateButton =
                new JButton("Calculate Cost");

            add(calculateButton);
            add(new JLabel(""));

            add(new JLabel("Total Cost:"));
            resultLabel = new JLabel("Rs. 0");
            add(resultLabel);

            setLocationRelativeTo(null);
            setVisible(true);
        }
    }

    
    static class ServiceController {

        ServiceModel model;
        ServiceView view;

        ServiceController(ServiceModel model, ServiceView view) {

            this.model = model;
            this.view = view;

            view.calculateButton.addActionListener(
                e -> calculateCost());
        }

        void calculateCost() {

            int cost = model.calculateCost(
                view.generalService.isSelected(),
                view.oilChange.isSelected(),
                view.brakeService.isSelected(),
                view.batteryCheck.isSelected()
            );

            view.resultLabel.setText("Rs. " + cost);
        }
    }

    public static void main(String[] args) {

        ServiceModel model = new ServiceModel();
        ServiceView view = new ServiceView();

        new ServiceController(model, view);
    }
}
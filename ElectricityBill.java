import java.util.*;
import java.util.stream.*;

class ElectricityBill {

    
    static double calculateBill(double units) {
        return units * 6;
    }

    public static void main(String[] args) {
        List<Double> consumption =
            Arrays.asList(8.0, 12.0, 15.0, 7.0, 20.0);

        
        List<Double> highConsumption = consumption.stream()
            .filter(u -> u > 10)
            .collect(Collectors.toList());

        System.out.println("Consumption above 10 units: "
            + highConsumption);

        
        List<Double> dailyCost = consumption.stream()
            .map(u -> calculateBill(u))
            .collect(Collectors.toList());

        System.out.println("Daily electricity cost: " + dailyCost);

        
        double totalUnits = consumption.stream()
            .reduce(0.0, (a, b) -> a + b);

        System.out.println("Total consumption: " + totalUnits);

        
        double totalBill = calculateBill(totalUnits);

        System.out.println("Total electricity bill: Rs."
            + totalBill);
    }
}
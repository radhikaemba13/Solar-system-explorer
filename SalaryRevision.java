import java.util.*;
import java.util.stream.*;

class SalaryRevision {
    public static void main(String[] args) {
        List<Integer> salaries =
            Arrays.asList(30000, 45000, 35000, 50000, 25000);

        
        List<Integer> revised = salaries.stream()
            .map(s -> s < 40000 ? (int)(s * 1.10) : s)
            .collect(Collectors.toList());

        System.out.println("Revised salaries: " + revised);

        
        List<Integer> eligible = salaries.stream()
            .filter(s -> s < 40000)
            .collect(Collectors.toList());

        System.out.println("Eligible salaries: " + eligible);

        
        int total = revised.stream()
            .reduce(0, (a, b) -> a + b);

        System.out.println("Total salary expenditure: Rs." + total);
    }
}
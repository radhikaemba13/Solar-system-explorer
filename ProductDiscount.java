import java.util.*;
import java.util.stream.*;

class ProductDiscount {

    
    static double discountedPrice(double price) {
        if (price > 1000) {
            return price * 0.80;
        }
        return price;
    }

    public static void main(String[] args) {
        List<Double> prices =
            Arrays.asList(500.0, 1200.0, 2000.0, 800.0, 1500.0);

    
        List<Double> discounted = prices.stream()
            .map(ProductDiscount::discountedPrice)
            .collect(Collectors.toList());

        System.out.println("Discounted prices: " + discounted);

        
        List<Double> eligible = prices.stream()
            .filter(p -> p > 1000)
            .collect(Collectors.toList());

        System.out.println("Eligible products: " + eligible);

        
        System.out.println("Original prices: " + prices);
    }
}
class Temperature {
    double celsius;

    void convertAndDisplay() {
        double fahrenheit = (9.0 / 5.0) * celsius + 32;
        
        System.out.println("Temperature in Celsius: " + celsius + "°C");
        System.out.println("Temperature in Fahrenheit: " + fahrenheit + "°F");
    }

    public static void main(String[] args) {
        Temperature temp = new Temperature();
        temp.celsius = 25.0;
        
        temp.convertAndDisplay();
    }
}
class Geometry {
    void area(int side) {
        int a = side * side;
        System.out.println("Area of Square : " + a);
    }
    void area(int length, int breadth) {
        int a = length * breadth;
        System.out.println("Area of Rectangle : " + a);
    }
    void area(double radius) {
        double a = 3.14 * radius * radius;
        System.out.println("Area of Circle : " + a);
     }
    public static void main(String[] args) {

        System.out.println("Name : Inbakumar");
        System.out.println("Reg No : RA2512701010010");
        System.out.println();

        Geometry g = new Geometry();

        g.area(5);        
        g.area(10, 5);    
        g.area(7.0);      
     }
}
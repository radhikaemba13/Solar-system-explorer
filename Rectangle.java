class Rectangle {
    double length;
    double breadth;

    void calculateAndDisplayArea() {
        double area = length * breadth;
        System.out.println("Length: " + length);
        System.out.println("Breadth: " + breadth);
        System.out.println("Calculated Area: " + area);
    }

    public static void main(String[] args) {
        Rectangle room = new Rectangle();
        room.length = 12.5;
        room.breadth = 10.0;
        
        room.calculateAndDisplayArea();
    }
}

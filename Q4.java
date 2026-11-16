public class Q4 {

    public static void main(String[] args) {

        int roll1 = 12, roll2 = 10;

        System.out.println("Before swap: roll1=" + roll1 + ", roll2=" + roll2);

        int temp = roll1;
        roll1 = roll2;
        roll2 = temp;

        System.out.println("After swap (with temp): roll1=" + roll1 + ", roll2=" + roll2);

        roll1 = roll1 + roll2;
        roll2 = roll1 - roll2;
        roll1 = roll1 - roll2;

        System.out.println("After swap (no temp): roll1=" + roll1 + ", roll2=" + roll2);
    }
}

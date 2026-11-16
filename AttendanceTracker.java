import java.util.Scanner;

public class AttendanceTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] attendance = new int[7];
        int presentCount = 0;
        
        for (int i = 0; i < attendance.length; i++) {
            attendance[i] = scanner.nextInt();
            if (attendance[i] == 1) {
                presentCount++;
            }
        }
        
        System.out.println("name: E.R.INBAKUMAR");
        System.out.println("reg no: RA2512701010010");
        
        double percentage = ((double) presentCount / attendance.length) * 100;
        
        if (percentage >= 75) {
            System.out.println("Eligible for Exam");
        } else {
            System.out.println("Not Eligible");
        }
        
        scanner.close();
    }
}
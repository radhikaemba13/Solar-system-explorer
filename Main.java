class RemainingTime implements Runnable {

    public void run() {
        for (int i = 5; i >= 1; i--) {
            System.out.println(Thread.currentThread().getName()
                    + " - Remaining time: " + i + " minutes");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

class AutoSave implements Runnable {

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - Auto-saving answers");

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

class NetworkCheck implements Runnable {

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - Checking network connection");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        RemainingTime timeTask = new RemainingTime();
        AutoSave saveTask = new AutoSave();
        NetworkCheck networkTask = new NetworkCheck();

        Thread t1 = new Thread(timeTask);
        Thread t2 = new Thread(saveTask);
        Thread t3 = new Thread(networkTask);

        t1.setName("Time Monitor");
        t2.setName("Auto Save");
        t3.setName("Network Checker");

        t1.start();
        t2.start();
        t3.start();
    }
}
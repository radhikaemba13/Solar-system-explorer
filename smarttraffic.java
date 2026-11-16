class TrafficJunction extends Thread {

    private String trafficStatus;
    private int delay;

    public TrafficJunction(String name, String trafficStatus, int delay) {
        super(name);
        this.trafficStatus = trafficStatus;
        this.delay = delay;
    }

    public void run() {

        for (int i = 1; i <= 3; i++) {

            System.out.println(Thread.currentThread().getName()
                    + " - Traffic Status: " + trafficStatus
                    + " - Report " + i);

            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class smarttraffic {

    public static void main(String[] args) {

        TrafficJunction junction1 =
            new TrafficJunction("Junction 1", "Heavy Traffic", 1000);

        TrafficJunction junction2 =
            new TrafficJunction("Junction 2", "Moderate Traffic", 1500);

        TrafficJunction junction3 =
            new TrafficJunction("Junction 3", "Low Traffic", 2000);

        junction1.setName("Chennai Central Junction");
        junction2.setName("Tambaram Junction");
        junction3.setName("Guindy Junction");

        junction1.start();
        junction2.start();
        junction3.start();
    }
}
class TransactionProcessing implements Runnable {

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - Processing transaction - Execution " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

class BalanceUpdating implements Runnable {

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - Updating balance - Execution " + i);

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

class SMSNotification implements Runnable {

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - Sending SMS notification - Execution " + i);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class mains {
    public static void main(String[] args) {

        TransactionProcessing transaction = new TransactionProcessing();
        BalanceUpdating balance = new BalanceUpdating();
        SMSNotification sms = new SMSNotification();

        Thread t1 = new Thread(transaction);
        Thread t2 = new Thread(balance);
        Thread t3 = new Thread(sms);

        t1.setName("Transaction Thread");
        t2.setName("Balance Thread");
        t3.setName("SMS Thread");

        t1.start();
        t2.start();
        t3.start();
    }
}
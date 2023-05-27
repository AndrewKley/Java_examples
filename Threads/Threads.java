class MyRunnable implements Runnable {
    public void run() {
        start();
    }

    private void start() {
        end();
    }

    private void end() {
        System.out.println("Top of the stack");
    }
}

public class Threads {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main method");
    }
}
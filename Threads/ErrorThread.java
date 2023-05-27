class BankAccount {
    private int _balance = 100;

    public int getBalance() {
        return _balance;
    }

    public void withdraw(int amount) {
        _balance -= amount;
    }
}

public class ErrorThread implements Runnable {
    private BankAccount account = new BankAccount();

    public static void main(String[] args) {
        ErrorThread task = new ErrorThread();
        Thread one = new Thread(task);
        Thread two = new Thread(task);
        one.setName("Bob");
        two.setName("Klem");
        one.start();
        two.start();
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            makeWithdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("Exceeding the litim");
            }
        }
    }

    public void makeWithdrawal(int amount) {
        if (account.getBalance() >= amount) {
            try {
                System.out.println(Thread.currentThread().getName() + " goes to sleep");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " wake up");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " ends the transaction");
        } else {
            System.out.println("Sorry, there is not enough money for " + Thread.currentThread().getName() + "'s client");
        }
    }
}

/**
 * Program based on concurrent operation.
 */
public class ListDemo {
    /**
     * Class Lista8Demo
     * @param args threads executing the program specified by the Counter, Numbers, SharedBank, WithdrawThread, WithdrawThreadSynchronized classes
     * @throws InterruptedException when a thread is interrupted
     */
    public static void main(String[] args) throws InterruptedException {
        // Task 2
        Counter counter = new Counter();
        Thread thread1 = new Thread(new Numbers(counter));
        Thread thread2 = new Thread(new Numbers(counter));
        Thread thread3 = new Thread(new Numbers(counter));
        Thread thread4 = new Thread(new Numbers(counter));
        Thread thread5 = new Thread(new Numbers(counter));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        System.out.println(counter.getCount());
        System.out.println(" ");
        // Task 3a
        System.out.println("Task 3 - threads without synchronization");
        SharedBank bank = new SharedBank(10000);
        WithdrawThread withdraw1 = new WithdrawThread(bank, 1500);
        WithdrawThread withdraw2 = new WithdrawThread(bank, 6500);
        Thread threadw1 = new Thread(withdraw1);
        Thread threadw2 = new Thread(withdraw2);
        threadw1.start();
        threadw2.start();

        threadw1.join();
        threadw2.join();

        System.out.println(" ");
        // Task 3b
        System.out.println("Task 3 - synchronized threads");
        SharedBank bank2 = new SharedBank(10000);
        WithdrawSynchronizedThread withdraw3 = new WithdrawSynchronizedThread(bank2, 3000);
        WithdrawSynchronizedThread withdraw4 = new WithdrawSynchronizedThread(bank2, 4000);
        Thread threadw3 = new Thread(withdraw3);
        Thread threadw4 = new Thread(withdraw4);
        threadw3.start();
        threadw4.start();
    }
}





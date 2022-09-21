public class ThreadTest {
    public static void main(String[] args) {

        //create 3 threads
        PrintThread thread1 = new PrintThread("thread1");
        PrintThread thread2 = new PrintThread("thread2");
        PrintThread thread3 = new PrintThread("thread3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
class PrintThread extends Thread {
    private int sleepTime;

    public PrintThread(String name) {
        super(name);

        //pick random sleep time betweem 0-5 seconds
        sleepTime = (int) (Math.random() * 5001);

    }
    public void run(){
        //put the thread to sleep for sleepTime amount of time.
        try {
            System.err.println(getName() + " going to sleep for " + sleepTime);
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) { //if thread interrupted during sleep print stack trace
            e.printStackTrace();
        }
        System.err.println(getName() + " done sleeping");

    }
}



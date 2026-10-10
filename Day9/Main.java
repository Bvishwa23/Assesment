package Day9;

public class Main {
    public static void main(String args[]) throws InterruptedException {
        SauseVerify e=new SauseVerify();
        e.executor("OPEN_BROWSER");
        Thread.sleep(2000);
        e.executor("OPEN_URL");
        Thread.sleep(2000);
        e.executor("USERNAME");
        Thread.sleep(2000);
        e.executor("PASSWORD");
        Thread.sleep(2000);
        e.executor("LOGIN");
        Thread.sleep(2000);
        e.executor("CLOSE_BROWSER");


    }
}

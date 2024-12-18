package thread.control.join;

import static util.Logger.log;
import static util.ThreadUtil.sleep;

public class JoinMainV0 {

    public static void main(String[] args) throws InterruptedException {
        log("main start");

        Thread thread1 = new Thread(new Job(), "t-1");
        Thread thread2 = new Thread(new Job(), "t-2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        log("main end");
    }

    static class Job implements Runnable {

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);
            log("작업 완료");
        }

    }
}

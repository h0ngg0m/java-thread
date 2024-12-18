package thread.control.interrupt;

import static util.Logger.log;
import static util.ThreadUtil.sleep;

public class ThreadStopMainV3 {

    public static void main(String[] args) {
        log("main start");

        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "t-1");
        thread.start();

        sleep(100);
        log("작업 중지 지시");
        thread.interrupt();
        log("task interrupted 상태1: " + thread.isInterrupted());
        log("main end");
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                log("작업 중");
            }
            log("task interrupted 상태2: " + Thread.currentThread().isInterrupted());
            log("작업 완료");
        }

    }

}

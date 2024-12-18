package thread.control.interrupt;

import static util.Logger.log;
import static util.ThreadUtil.sleep;

public class ThreadStopMainV1 {

    public static void main(String[] args) {
        log("main start");

        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "t-1");
        thread.start();

        sleep(4000);
        log("작업 중지 지시");
        myTask.running = false;

        log("main end");

    }

    static class MyTask implements Runnable {

        volatile boolean running = true;

        @Override
        public void run() {
            while (running) {
                log("작업 중");
                sleep(3000);
            }
            log("작업 완료");
        }

    }

}

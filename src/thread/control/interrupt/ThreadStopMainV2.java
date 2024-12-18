package thread.control.interrupt;

import static util.Logger.log;
import static util.ThreadUtil.sleep;

public class ThreadStopMainV2 {

    /*
     * interrupt() 메서드를 호출했다고 즉각 InterruptedException 예외가 발생하는 것은 아니고
     * 오직 sleep(), wait(), join() 처럼 InterruptedException 예외를 던지는 메서드를 호출하거나 호출 중일 때 예외가 발생한다.
     * 예외가 발생하면 interrupted 상태는 false로 초기화되고, Thread status는 Runnable 상태로 변경된다.
     *
     */

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
            while (!Thread.currentThread().isInterrupted()) {
                log("작업 중");
            }
            log("task interrupted 상태2: " + Thread.currentThread().isInterrupted());
            log("작업 완료");
        }

    }

}

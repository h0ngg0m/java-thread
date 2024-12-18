package thread.lock;

import java.util.concurrent.locks.LockSupport;

import static util.Logger.log;
import static util.ThreadUtil.sleep;

public class LockSupportMainV1 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new ParkTest());
        thread1.start();

        sleep(1000);
        log("thread1 state: " + thread1.getState());

        log("main -> unpark(thread1)");
//        LockSupport.unpark(thread1); // 1. unpark 사용
        thread1.interrupt(); // 2. interrupt 사용
    }

    static class ParkTest implements Runnable {

        @Override
        public void run() {
            log("park 시작");
            LockSupport.park();
            log("park 종료, state: " + Thread.currentThread().getState());
            log("인터럽트 상태: " + Thread.currentThread().isInterrupted());

        }

    }
}
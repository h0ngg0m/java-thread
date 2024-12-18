package thread.control;

import util.Logger;

public class ThreadStateMain {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable(), "myThread");
        Logger.log("myThread state1: " + thread.getState()); // NEW
        Logger.log("myThread.start()");
        thread.start();
        Thread.sleep(1000);
        Logger.log("myThread state3: " + thread.getState()); // TIMED_WAITING
        Thread.sleep(4000);
        Logger.log("myThread state5: " + thread.getState()); // TERMINATED
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            try {
                Logger.log("start");
                Logger.log("myThread state2: " + Thread.currentThread().getState()); // RUNNABLE
                Logger.log("sleep() start");
                Thread.sleep(3000);
                Logger.log("sleep() end");
                Logger.log("myThread state4: " + Thread.currentThread().getState()); // RUNNABLE
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}

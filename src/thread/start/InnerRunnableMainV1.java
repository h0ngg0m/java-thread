package thread.start;

import util.Logger;

public class InnerRunnableMainV1 {

    public static void main(String[] args) {
        Logger.log("main() start");

        Runnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        Logger.log("main() end");
    }

    static class MyRunnable implements Runnable {

        @Override
        public void run() {
            Logger.log("HelloRunnable.run()");
        }

    }
}

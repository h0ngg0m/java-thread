package thread.start;

import util.Logger;

public class InnerRunnableMainV2 {

    public static void main(String[] args) {
        Logger.log("main() start");

        Runnable myRunnable = new Runnable(){
            @Override
            public void run() {
                Logger.log("HelloRunnable.run()");
            }
        };
        Thread thread = new Thread(myRunnable);
        thread.start();

        Logger.log("main() end");
    }
}

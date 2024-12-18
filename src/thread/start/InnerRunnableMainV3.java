package thread.start;

import util.Logger;

public class InnerRunnableMainV3 {

    public static void main(String[] args) {
        Logger.log("main() start");
        Thread thread = new Thread(() -> Logger.log("HelloRunnable.run()"));
        thread.start();

        Logger.log("main() end");
    }
}

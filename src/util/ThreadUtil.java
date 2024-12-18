package util;

public abstract class ThreadUtil {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Logger.log("인터럽트 발생, " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

package thread.control.volatile1;

import static util.Logger.log;
import static util.ThreadUtil.sleep;

public class VolatileCountMain {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task);
        thread.start();

        sleep(1000);

        task.flag = false;
        log("main end: " + "flag = " + task.flag + ", count = " + task.count);
    }

    static class MyTask implements Runnable {

//        boolean flag = true;
//        long count;
        volatile boolean flag = true;
        volatile long count;


        @Override
        public void run() {
            while (flag) {
                count++;
                // 1억 번째마다 출력
                if (count % 100_000_000 == 0) {
                    log("flag = " + flag + ", count = " + count);
                }
            }
            log("flag = " + flag + ", count = " + count + "종료");
        }

    }
}

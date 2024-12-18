package thread.control.volatile1;

import static util.Logger.log;
import static util.ThreadUtil.sleep;

public class VolatileFlagMain {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task);

        log("running: " + task.running);
        thread.start();

        sleep(1000);
        log("running to false");
        task.running = false;
        log("running: " + task.running);
        log("main end");
    }

    static class MyTask implements Runnable {

//        boolean running = true; // 캐시 메모리에 접근하기 때문에 예상한 동작: task start -> task end 가 되지 않고 while 무한 루프에 빠짐
         volatile boolean running = true; // 메인 메모리에 접근하기 때문에 예상한 동작: task start -> task end 대로 진행


        @Override
        public void run() {
            log("task start");
            while (running) {

            }
            log("task end");
        }

    }
}

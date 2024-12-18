package thread.control.join;

import static util.Logger.log;
import static util.ThreadUtil.sleep;

public class JoinMainV2 {

    public static void main(String[] args) throws InterruptedException {
        log("main start");


        SumTask sumTask1 = new SumTask(1, 50);
        Thread thread1 = new Thread(sumTask1, "t-1");
        thread1.start();

        thread1.join(1000);

        log("sumTask1.result: " + sumTask1.result);

        log("main end");
    }

    static class SumTask implements Runnable {

        int startValue;
        int endValue;
        int result;

        public SumTask(int startValue, int endValue) {
            this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;
            log("작업 완료 result: " + result);
        }

    }
}

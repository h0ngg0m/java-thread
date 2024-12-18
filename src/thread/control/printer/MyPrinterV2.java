package thread.control.printer;

import java.util.Deque;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;

import static util.Logger.log;
import static util.ThreadUtil.sleep;

public class MyPrinterV2 {

    public static void main(String[] args) {
        Printer printerRunnable = new Printer();
        Thread printerThread = new Thread(printerRunnable, "printer");
        printerThread.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            log("문서 입력(종료: exit): ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                printerThread.interrupt();
                break;
            }
            printerRunnable.q.offer(input);
        }
    }

    static class Printer implements Runnable {

        Deque<String> q = new ConcurrentLinkedDeque<>();

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                if (!q.isEmpty()) {
                    try {
                        String msg = q.poll();
                        log("출력 시작: " + msg + ", 대기 문서: " + q);
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        log("프린터 인터럽트");
                        break;
                    }
                }
            }
            log("프린터 종료");
        }

    }

}

package thread.control.printer;

import java.util.Deque;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;

import static util.Logger.log;
import static util.ThreadUtil.sleep;

public class MyPrinterV1 {

    public static void main(String[] args) {
        Printer printer = new Printer();
        new Thread(printer, "printer").start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            log("문서 입력(종료: exit): ");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                printer.running = false;
                break;
            }
            printer.q.offer(input);
        }
    }

    static class Printer implements Runnable {

        volatile boolean running = true;
        Deque<String> q = new ConcurrentLinkedDeque<>();

        @Override
        public void run() {
            while (running) {
                if (!q.isEmpty()) {
                    String msg = q.poll();
                    log("출력 시작: " + msg + ", 대기 문서: " + q);
                    sleep(3000);
                }
            }
            log("프린터 종료");
        }

    }

}

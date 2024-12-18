package thread.start;

public class HelloThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");
        new HelloThread().start();
        System.out.println(Thread.currentThread().getName() + ": main() end");
    }
}

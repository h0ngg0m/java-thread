package thread.sync;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.Logger.log;
import static util.ThreadUtil.sleep;

public class BankAccountV4 implements BankAccount {

    private int balance;

    private final Lock lock = new ReentrantLock();

    public BankAccountV4(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());

        lock.lock(); // lock을 획득한다.

        try {
            log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);
            if (balance < amount) {
                log("[검증 실패] 출금액: " + amount + ", 잔액: " + balance);
                return false;
            }
            log("[검증 성공] 출금액: " + amount + ", 잔액: " + balance);

            sleep(1000);
            balance -= amount;

            log("[출금 완료] 출금액: " + amount + ", 잔액: " + balance);
        } finally {
            lock.unlock(); // lock을 해제한다.
        }

        log("거래 종료: " + getClass().getSimpleName());
        return true;
    }

    @Override
    public int getBalance() {
        lock.lock();
        try {
            return balance;
        } finally {
            lock.unlock();
        }
    }
}

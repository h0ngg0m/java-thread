### 쓰레드의 상태
- `NEW`: 쓰레드가 생성되었지만, 아직 `start()` 메소드가 호출되지 않은 상태
- `RUNNABLE`: 실행 중 또는 실행 가능한 상태
- 일시 중지 상태들
  - `BLOCKED`: 쓰레드가 동기화 락을 기다리는 상태
  - `WAITING`: 쓰레드가 무기한으로 다른 쓰레드의 작업을 기다리는 상태
  - `TIMED_WAITING`: 쓰레드가 다른 쓰레드의 작업을 `n` 밀리초 동안 기다리는 상태
- `TERMINATED`: 쓰레드의 실행이 완료된 상태

### BLOCKED vs WAITING (TIMED_WAITING)
인터럽트
- `BLOCKED` 상태는 인터럽트가 걸려도 대기 상태를 빠져나오지 못한다. 여전히 `BLOCKED` 상태다.
- `WAITING` 또는 `TIMED_WAITING` 상태는 인터럽트가 걸리면 대기 상태를 빠져나와서 실행 가능한 `RUNNABLE` 상태가 된다.

용도
- `BLOCKED` 상태는 자바의 `synchronized`에서 락을 획득하기 위해 대기할 때 사용된다.
- `WAITING` 또는 `TIMED_WAITING` 상태는 다른 쓰레드가 특정 조건이나 시간 동안 대기할 때 발생하는 상태이다.
- `WAITING` 상태는 다양한 상황에서 사용된다. 예를 들어, `Object.wait()`, `Thread.join()`, `LockSupport.park()`와 같은 메서드 호출 시
`WAITING` 상태가 된다.
- `TIMED_WAITING` 상태는 `Thread.sleep(ms)`, `Object.wait(long timeout)`, `Thread.join(long millis)`, `LockSupport.parkNanos(ns)`
등과 같은 시간 제한이 있는 대기 메서드를 호출할 때 발생한다.
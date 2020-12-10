package HomeWork_3_05;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GasPool {
    private float fuelReserve = 200f;
    private final ReentrantReadWriteLock lock1 = new ReentrantReadWriteLock();

    public float request(float amount) {
        lock1.writeLock().lock();
        try {
            if ((gasPoolInfo() - amount) >= 0) {
                fuelReserve -= amount;
                return amount;
            }
            return 0;
        } finally {
            lock1.writeLock().unlock();
        }
    }

    public float gasPoolInfo() {
        return fuelReserve;
    }
}

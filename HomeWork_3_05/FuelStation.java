package HomeWork_3_05;

import java.util.concurrent.Semaphore;

public class FuelStation {
    private GasPool gasPool;
    private Semaphore semaphore;

    public FuelStation() {
        this.semaphore = new Semaphore(3);
        this.gasPool = new GasPool();
    }

    public float refuel(float amount, String idName) {
        try {
            System.out.println(String.format("%s ожидает заправки", idName));
            semaphore.acquire();
            if(gasPool.gasPoolInfo() > amount) {
                System.out.println(String.format("%s заправляется...", idName));
                Thread.sleep(5000);
                System.out.println(String.format("На заправке отсталось %s топлива", gasPool.gasPoolInfo()));
                return gasPool.request(amount);
            }
            System.out.println(String.format("Недостаточно топлива для %s", idName));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
        return 0f;
    }
}

package HomeWork_3_05;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        FuelStation fuelStation = new FuelStation();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(new Car("Car_01",fuelStation));
        executorService.submit(new Car("Car_02",fuelStation));
        executorService.submit(new Car("Car_03",fuelStation));
        executorService.submit(new Car("Car_04",fuelStation));
        executorService.submit(new Truck("Truck_1",fuelStation));
        executorService.submit(new Truck("Truck_2",fuelStation));
        executorService.submit(new Truck("Truck_3",fuelStation));
        executorService.submit(new Truck("Truck_4",fuelStation));
        executorService.submit(new Bus("Bus_01",fuelStation));
        executorService.submit(new Bus("Bus_02",fuelStation));
        executorService.shutdown();
    }
}
package HomeWork_3_05;

public abstract class Vehicle implements Runnable {
    protected FuelStation fuelStation;
    protected String idName;
    protected float volumeFuel;
    protected float currentVolume;
    protected float fuelConsumption;

    public void drive() {
        try {
            while (currentVolume > fuelConsumption) {
                System.out.println(String.format(" %s едет, в баке %s", idName, currentVolume));
                Thread.sleep(3000);
                currentVolume -= fuelConsumption;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean refuel() {
        System.out.println(String.format("%s необходимо заправиться" , idName));
        float beforeVolume = currentVolume;
        currentVolume = fuelStation.refuel(volumeFuel - currentVolume, idName);
        if (currentVolume > beforeVolume) {
            System.out.println(String.format("%s заправлено", idName));
            return true;
        }

        return false;
    }

    @Override
    public void run() {
        do {
            drive();
        }
        while ( refuel());
    }
}

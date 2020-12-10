package HomeWork_3_05;

public class Car  extends Vehicle {
    public Car(String idName, FuelStation fuelStation) {
        this.idName = idName;
        this.volumeFuel = 20f;
        this.currentVolume = 20f;
        this.fuelConsumption = 2.5f;
        this.fuelStation = fuelStation;
    }

}

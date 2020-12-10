package HomeWork_3_05;

public class Truck extends Vehicle {
    public Truck(String idName, FuelStation fuelStation) {
        this.idName = idName;
        this.volumeFuel = 60f;
        this.currentVolume = 60f;
        this.fuelConsumption = 15f;
        this.fuelStation = fuelStation;
    }

}

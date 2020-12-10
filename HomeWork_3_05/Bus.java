package HomeWork_3_05;

public class Bus extends Vehicle {
    public Bus(String idName, FuelStation fuelStation) {
        this.idName = idName;
        this.volumeFuel = 40f;
        this.currentVolume = 40f;
        this.fuelConsumption = 7.5f;
        this.fuelStation = fuelStation;
    }

}

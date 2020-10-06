package HomeWork_06;

public class Dog extends Animal {

    public Dog(){
        maxLengthRun = (int) (500 * getCoefficientOfPhysicalCapabilities());
        maxLengthSwim = (int) (10 * getCoefficientOfPhysicalCapabilities());
        double val = 0.5 * getCoefficientOfPhysicalCapabilities();
        maxHeightJumpOver = ((int) (val * 100)) / 100D;
    }
}

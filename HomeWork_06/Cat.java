package HomeWork_06;

public class Cat extends Animal {

    public Cat() {
        maxLengthRun = (int) (200 * getCoefficientOfPhysicalCapabilities());
        double val = 2.0 * getCoefficientOfPhysicalCapabilities();
        maxHeightJumpOver = ((int) (val * 100)) / 100D;
    }

    @Override
    public void swim(int length) {
        System.out.println("кот не умеет плавать");
    }
}

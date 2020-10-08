package HomeWork_06;

class Cat extends Animal {

    Cat() {
        maxLengthRun = (int) (200 * getCoefficientOfPhysicalCapabilities());
        double val = 2.0 * getCoefficientOfPhysicalCapabilities();
        maxHeightJumpOver = ((int) (val * 100)) / 100D;
    }

    @Override
    void swim(int length) {
        System.out.println("кот не умеет плавать");
    }
}

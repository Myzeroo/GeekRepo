package HomeWork_06;

class Dog extends Animal {
    {
        super.maxLengthRun = (int) (500 * getCoefficientOfPhysicalCapabilities());
        super.maxLengthSwim = (int) (10 * getCoefficientOfPhysicalCapabilities());

        double val = 0.5 * getCoefficientOfPhysicalCapabilities();
        // усекаем до 2-ух знаков после запятой
        super.maxHeightJumpOver = ((int) (val * 100)) / 100D;
    }
}

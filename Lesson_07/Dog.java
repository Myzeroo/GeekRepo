package Lesson_07;

class Dog extends Animal {

    Dog(){
        maxLengthRun = (int) (500 * getCoefficientOfPhysicalCapabilities());
        maxLengthSwim = (int) (10 * getCoefficientOfPhysicalCapabilities());
        double val = 0.5 * getCoefficientOfPhysicalCapabilities();
        maxHeightJumpOver = ((int) (val * 100)) / 100D;
    }

    @Override
    protected String showTypeAnimal() {
        return null;
    }
}

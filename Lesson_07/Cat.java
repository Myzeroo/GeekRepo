package Lesson_07;

class Cat extends Animal {

    @Override
    protected String showTypeAnimal() {
        return "Cat " + this.name + " ";
    }

    Cat(String name) {
        this.name = name;
        maxLengthRun = (int) (200 * getCoefficientOfPhysicalCapabilities());
        double val = 2.0 * getCoefficientOfPhysicalCapabilities();
        maxHeightJumpOver = ((int) (val * 100)) / 100D;
    }

    @Override
    void swim(int length) {
        System.out.println("кот не умеет плавать");
    }
}

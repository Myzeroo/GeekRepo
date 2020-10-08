package HomeWork_06;

import java.util.Random;

abstract class Animal {

    protected int maxLengthRun;
    protected int maxLengthSwim;
    protected double maxHeightJumpOver;

    void run(int length) {
        boolean result = maxLengthRun > length ? true : false;
        System.out.println("результат: run: " + result);
    }

    void swim(int length) {
        boolean result = maxLengthSwim > length ? true : false;
        System.out.println("результат: swim: " + result);
    }

    void jumpOver(double height) {
        boolean result = maxHeightJumpOver > height ? true : false;
        System.out.println("результат: jumpOver: " + result);
    }

    protected double getCoefficientOfPhysicalCapabilities() {
        // вычисление коэффициента от 0.8 до 1.2, разброс в 20%
        return 0.8 + (new Random().nextInt(41)) / 100D;
    }
}

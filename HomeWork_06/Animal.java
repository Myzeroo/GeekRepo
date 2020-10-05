package HomeWork_06;

import java.util.Random;

// как и в прошлый раз, модификаторы доустпа паблик были убраны намерернно,
// т.к. в задании не указывается необходимость использования дыннх классов в других пакетах
abstract class Animal {

    int maxLengthRun;
    int maxLengthSwim;
    double maxHeightJumpOver;

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

    double getCoefficientOfPhysicalCapabilities() {
        // вычисление коэффициента от 0.8 до 1.2, разброс в 20%
        return 0.8 + (new Random().nextInt(41)) / 100D;
    }
}

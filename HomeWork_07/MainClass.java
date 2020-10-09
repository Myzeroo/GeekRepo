package HomeWork_07;

public class MainClass {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 160);
        Plate plate = new Plate(100);

        plate.info();
        cat.eat(plate);
        cat.isSatiety();
        plate.info();
        cat.eat(plate);
        plate.info();
    }
}

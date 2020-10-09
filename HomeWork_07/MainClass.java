package HomeWork_07;

public class MainClass {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik", 25);
        Cat cat2 = new Cat("Pushok", 25);
        Cat cat3 = new Cat("Mursik", 25);
        Cat cat4 = new Cat("Vas'ka", 25);
        Cat cat5 = new Cat("Ryzhik", 25);

        Cat[] cats = {cat1, cat2, cat3, cat4, cat5};

        Plate plate = new Plate(100);

        for (Cat cat: cats) {
            cat.eat(plate);
        }
        for (Cat cat: cats) {
            cat.isSatiety();
        }
    }
}

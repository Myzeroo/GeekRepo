package HomeWork_3_01.BigTask;

public class Main {
    public static void main(String[] args) {

        Box<Apple> boxApple1 = new Box<>();
        Box<Orange> boxOrange1 = new Box<>();
        Box<Orange> boxOrange2 = new Box<>();

        boxApple1.addFruitsInBox(new Apple(), 6);
        System.out.println(boxApple1.getWeight());

        boxOrange1.addFruitsInBox(new Orange(), 3);
        boxOrange2.addFruitsInBox(new Orange(), 1);

        boxOrange1.pourFruits(boxOrange2);

        System.out.println(boxOrange1.getWeight());

        System.out.println(boxApple1.compare(boxOrange2));


    }
}

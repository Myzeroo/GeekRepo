package HomeWork_2_01;

public class Main {
    public static void main(String[] args) {
       Moveable mv1 = new Human();
       Moveable mv2 = new Cat();
       Moveable mv3 = new Robot();
        mv1.run();
        mv2.run();
        mv3.run();

        Treadmill.doRun(mv1, true);
        Treadmill.doRun(mv2, false);
    }
}

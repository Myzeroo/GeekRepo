package HomeWork_2_01;

public class Main {
    public static void main(String[] args) {
       Moveable mv1 = new Human();
       Moveable mv2 = new Cat();
       Moveable mv3 = new Robot();




        Treadmill.doRun(mv1, true);
        Treadmill.doRun(mv2, false);
    }
}

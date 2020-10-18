package HomeWork_2_01;

public class Robot implements Moveable {
    @Override
    public void run() {
        System.out.println("robot run");
    }

    @Override
    public void jump() {
        System.out.println("robot jump");
    }
}

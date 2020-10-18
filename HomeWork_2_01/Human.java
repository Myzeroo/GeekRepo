package HomeWork_2_01;

public class Human implements Moveable {

    @Override
    public void run() {
        System.out.println("Human run");
    }

    @Override
    public void jump() {
        System.out.println("Human jump");
    }
}

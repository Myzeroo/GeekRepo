package HomeWork_2_01;

public class Cat implements Moveable {
    @Override
    public void run() {
        System.out.println("Cat run");
    }

    @Override
    public void jump() {
        System.out.println("Cat jump");
    }
}

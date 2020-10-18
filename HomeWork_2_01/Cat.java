package HomeWork_2_01;

public class Cat implements Moveable {
    private int maxDistance;
    private int maxHeight;

    public Cat(int maxDistance, int maxHeight){
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }

    @Override
    public int run() {
        System.out.println("Кот бежит");
        return maxDistance;
    }

    @Override
    public int jump() {
        System.out.println("Кот прыгает");
        return maxHeight;
    }
}

package HomeWork_2_01;

public class Robot implements Moveable {
    private int maxDistance;
    private int maxHeight;

    public Robot(int maxDistance, int maxHeight){
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }

    @Override
    public int run() {
        System.out.println("Робот бежит");
        return maxDistance;
    }

    @Override
    public int jump() {
        System.out.println("Робот прыгает");
        return maxHeight;
    }
}

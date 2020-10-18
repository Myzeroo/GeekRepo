package HomeWork_2_01;

public class Cat implements Moveable {
    private int maxDistance;
    private int maxHeight;
    private boolean descent = false;

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

    @Override
    public boolean isDescent() {
        return descent;
    }

    @Override
    public void setDescent(boolean val) {
        descent = val;
    }
}

package HomeWork_2_01;

public class Human implements Moveable {
    private int maxDistance;
    private int maxHeight;
    private boolean descent = false;


    public Human(int maxDistance, int maxHeight){
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }

    @Override
    public int run() {
        System.out.println("Человек бежит");
        return maxDistance;
    }

    @Override
    public int jump() {
        System.out.println("Человек прыгает");
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

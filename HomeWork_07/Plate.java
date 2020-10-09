package HomeWork_07;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        if ((food - n) > 0) food -= n;
        else System.out.println("Недостаточно еды в тарелке");
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}

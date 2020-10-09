package HomeWork_07;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if ((food - n) > 0) {
            food -= n;
            return true;
        } else {
            System.out.println("Недостаточно еды в тарелке");
            return false;
        }
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}

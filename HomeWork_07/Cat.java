package HomeWork_07;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public void isSatiety() {
        System.out.println("Сытость кота " + name + " " + satiety);;
    }

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate p) {
        satiety = p.decreaseFood(appetite);
    }


}

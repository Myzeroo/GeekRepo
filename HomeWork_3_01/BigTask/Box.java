package HomeWork_3_01.BigTask;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    ArrayList<T> storageFruits;

    public Box() {
        storageFruits = new ArrayList<>();
    }

    public void addFruitsInBox(T fruit, int count){
        for (int i = 0; i < count; i++) {
            storageFruits.add(fruit);
        }
    }

    public float getWeight(){
        float weight = 0;
        for(T fruit : storageFruits){
            weight += fruit.weight;
        }
        return weight;
    }

    public boolean compare(Box otherBox){
        return this.getWeight() == otherBox.getWeight();
    }

    public void pourFruits(Box<T> otherBox){
        this.storageFruits.forEach(fruit -> otherBox.storageFruits.add(fruit));
        this.storageFruits.clear();
    }
}

package Model;


import java.util.concurrent.atomic.AtomicInteger;

public class ModelToy {
    private static AtomicInteger num = new AtomicInteger();
    private int id;
    private String name;
    private int quantity;
    private int weight;

    public ModelToy() {
    }

    public ModelToy(String name, int quantity, int weight) {
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
        this.id = num.incrementAndGet();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }



    @Override
    public String toString() {
        return "Toy [id=" + id + ", название=" + name + ", количество=" + quantity + ", частота выпадения(%)=" + weight + "]";
    }
}

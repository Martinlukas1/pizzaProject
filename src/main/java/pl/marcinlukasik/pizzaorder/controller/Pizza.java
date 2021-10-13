package pl.marcinlukasik.pizzaorder.controller;

import java.util.Objects;

public class Pizza {
    private String name;
    private String desc;
    private int pizzaId;
    private String img;
    private double prize;
    private int amount;

    public Pizza() {
    }

    public Pizza(String name) {
        this.name = name;
    }

    public Pizza(String name, String desc, int pizzaId, String img, double prize) {
        this.name = name;
        this.desc = desc;
        this.pizzaId = pizzaId;
        this.img = img;
        this.prize = prize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(int pizzaId) {
        this.pizzaId = pizzaId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", pizzaId=" + pizzaId +
                ", img='" + img + '\'' +
                ", prize=" + prize +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return pizzaId == pizza.pizzaId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, desc, pizzaId, img, prize);
    }
}

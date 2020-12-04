package com.company;

public class Car {
    private String brand;
    private int price;
    private int maxSpeed;

    public Car(String brand, int price, int maxSpeed) {
        this.brand = brand;
        this.price = price;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Car{" + brand + '\'' +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}

package oop.reflection;

public class Human {
    private int age;
    private double heigth;

    private Human (double heigth) {
        this.heigth = heigth;
    }

    public void printAge() {
        System.out.println(age);
    }

    public void grow() {
        this.heigth += 0.2;
    }

    public void grow(double value) {
        this.heigth += value;
    }

    public double getHeigth() {
        return heigth;
    }

    private void simplePrivate() {
        System.out.println("I'm private");
    }
}
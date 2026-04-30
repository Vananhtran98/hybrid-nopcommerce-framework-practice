package javaBasic;

public abstract class Animal {

    // Constructor
    public Animal(String animalName) {
        System.out.println("Animal Running....");
    }
    // Thể hiện tính chất trừu tượng trong OOP (Abstraction)

    public abstract void sleep();

    public void eat() {
        System.out.println("Eating....");

    }

}

package javaBasic;

import org.openqa.selenium.WebDriver;

public class Dog extends Animal {

    String animalName; // Biến Global

    public Dog(String animalName) { // Biến Local
        super(animalName); // Gọi tới Constructor của lớp cha Animal
        this.animalName = animalName;

    }
    @Override
    public void sleep() {
        System.out.println("Sleeping....");

    }
    // Thể hiện tính chất kế thừa trong OOP (Inheritance)



}

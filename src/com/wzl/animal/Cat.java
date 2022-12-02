package com.wzl.animal;

public class Cat extends Animal{

    public Cat() {
    }

    public Cat(String animalName, int animalAge, String animalGender) {
        super(animalName, animalAge, animalGender, 200);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "animalName='" + animalName + '\'' +
                ", animalAge=" + animalAge +
                ", animalGender='" + animalGender + '\'' +
                ", animalPrice=" + animalPrice +
                '}';
    }
}

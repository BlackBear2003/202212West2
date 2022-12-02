package com.wzl.animal;


public abstract class Animal {

    public String animalName;
    public int animalAge;
    public String animalGender;
    public double animalPrice;

    public Animal() {
    }

    public Animal(String animalName, int animalAge, String animalGender, double animalPrice) {
        this.animalName = animalName;
        this.animalAge = animalAge;
        this.animalGender = animalGender;
        this.animalPrice = animalPrice;
    }


    @Override
    public abstract String toString();



}

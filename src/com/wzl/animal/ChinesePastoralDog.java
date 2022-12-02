package com.wzl.animal;

public class ChinesePastoralDog extends Animal{

    private Boolean isVaccineInjected;

    public ChinesePastoralDog() {
    }


    public ChinesePastoralDog(Boolean isVaccineInjected) {
        this.isVaccineInjected = isVaccineInjected;
    }

    public ChinesePastoralDog(String animalName, int animalAge, String animalGender, Boolean isVaccineInjected) {
        super(animalName, animalAge, animalGender, 100);
        this.isVaccineInjected = isVaccineInjected;
    }

    @Override
    public String toString() {
        return "ChinesePastoralDog{" +
                "animalName='" + animalName + '\'' +
                ", animalAge=" + animalAge +
                ", animalGender='" + animalGender + '\'' +
                ", animalPrice=" + animalPrice +
                ", isVaccineInjected=" + isVaccineInjected +
                '}';
    }

    public Boolean getVaccineInjected() {
        return isVaccineInjected;
    }

    public void setVaccineInjected(Boolean vaccineInjected) {
        isVaccineInjected = vaccineInjected;
    }
}

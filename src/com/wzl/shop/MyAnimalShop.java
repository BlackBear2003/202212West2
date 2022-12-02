package com.wzl.shop;

import com.wzl.animal.Animal;
import com.wzl.customer.Customer;
import com.wzl.exception.AnimalNotFoundException;
import com.wzl.exception.InsufficientBalanceException;

import java.time.LocalDate;
import java.util.ArrayList;

public class MyAnimalShop implements AnimalShop{

    private double money;
    private ArrayList<Animal> animalArrayList;
    private ArrayList<Customer> customerArrayList;
    private Boolean isWork;

    public MyAnimalShop(double money, ArrayList<Animal> animalArrayList, ArrayList<Customer> customerArrayList, Boolean isWork) {
        this.money = money;
        this.animalArrayList = animalArrayList;
        this.customerArrayList = customerArrayList;
        this.isWork = isWork;
    }

    @Override
    public String toString() {
        return "MyAnimalShop{" +
                "money=" + money +
                ", animalArrayList=" + animalArrayList +
                ", customerArrayList=" + customerArrayList +
                ", isWork=" + isWork +
                '}';
    }

    public MyAnimalShop() {

    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public ArrayList<Animal> getAnimalArrayList() {
        return animalArrayList;
    }

    public void setAnimalArrayList(ArrayList<Animal> animalArrayList) {
        this.animalArrayList = animalArrayList;
    }

    public ArrayList<Customer> getCustomerArrayList() {
        return customerArrayList;
    }

    public void setCustomerArrayList(ArrayList<Customer> customerArrayList) {
        this.customerArrayList = customerArrayList;
    }

    public Boolean getWork() {
        return isWork;
    }

    public void setWork(Boolean work) {
        isWork = work;
    }

    @Override
    public Boolean buyAnimal(Animal animal) {

        if(money<animal.animalPrice){
            throw new InsufficientBalanceException("没钱了");
        }else{
            money-=animal.animalPrice;
            animalArrayList.add(animal);
            return true;
        }
    }

    @Override
    public void welcome(Customer customer) {

        System.out.println("welcome!!!!!!!!!\n"+customer);
        customer.setArriveTimes(customer.getArriveTimes()+1);
        customerArrayList.add(customer);

        if(animalArrayList.isEmpty()){
            throw new AnimalNotFoundException("没动物了!");
        }else{
            Animal animal = animalArrayList.get(0);
            animalArrayList.remove(0);
            money+=animal.animalPrice;
            customer.setConsume(customer.getConsume()+animal.animalPrice);
            System.out.println("谢谢老板，出售动物:"+animal);
        }

    }

    @Override
    public void close() {
        LocalDate closeDate = LocalDate.now();
        double profit = 0;
        for (Customer customer:
             customerArrayList) {
            if(closeDate.isEqual(customer.getArrivalDate())){
                System.out.println(customer);
                profit+=customer.getConsume();
            }
        }
        System.out.println("今天赚了这些钱："+profit);
    }
}

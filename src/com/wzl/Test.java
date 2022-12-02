package com.wzl;

import com.wzl.animal.Animal;
import com.wzl.animal.Cat;
import com.wzl.animal.ChinesePastoralDog;
import com.wzl.customer.Customer;
import com.wzl.regex.MyRegex;
import com.wzl.shop.MyAnimalShop;
import com.wzl.exception.AnimalNotFoundException;
import com.wzl.exception.InsufficientBalanceException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    ChinesePastoralDog dog1 = new ChinesePastoralDog("wzl",18,"male",true);
    ChinesePastoralDog dog2 = new ChinesePastoralDog("hk",18,"male",true);
    ChinesePastoralDog dog3 = new ChinesePastoralDog("cyj",18,"male",true);
    ChinesePastoralDog dog4 = new ChinesePastoralDog("xjr",18,"male",true);
    ChinesePastoralDog dog5 = new ChinesePastoralDog("bzy",18,"male",true);

    Cat cat1 = new Cat("wzl",15,"male");
    Cat cat2 = new Cat("wzl",15,"male");
    Cat cat3 = new Cat("wzl",15,"male");

    Customer customer1 = new Customer("1",0, LocalDate.now(),0);
    Customer customer2 = new Customer("2",0, LocalDate.now(),0);
    Customer customer3 = new Customer("3",0, LocalDate.now(),0);

    MyAnimalShop myAnimalShop = new MyAnimalShop();

    public static void main(String[] args) {
        Test test = new Test();

        //test.init();
        //test.testBuy();
        //test.testWelcome();
        //test.testClose();

        //test.testRegex();

        test.testThread();
    }
    void init(){
        myAnimalShop.setAnimalArrayList(new ArrayList<Animal>());
        myAnimalShop.setCustomerArrayList(new ArrayList<Customer>());
        myAnimalShop.setMoney(500);
    }

    void testBuy(){
        try{
            myAnimalShop.buyAnimal(dog1);
            myAnimalShop.buyAnimal(dog2);
            myAnimalShop.buyAnimal(dog3);
            myAnimalShop.buyAnimal(dog4);
            myAnimalShop.buyAnimal(dog5);

        } catch (InsufficientBalanceException e) {
            e.printStackTrace();
        }
        System.out.println(myAnimalShop.getAnimalArrayList());
    }

    void testWelcome(){
        System.out.println("提示：开始招待客人\n");
        try{
            myAnimalShop.welcome(customer1);
            myAnimalShop.welcome(customer2);
            myAnimalShop.welcome(customer3);

        } catch (AnimalNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(myAnimalShop.getAnimalArrayList());
    }

    void testClose(){
        myAnimalShop.close();
    }

    public void testRegex(){
        MyRegex regex = new MyRegex();
        String[] emails = {
                "102101244@fzu.edu.cn",
                "348358584@qq.com",
                "Fzu_luke0125@outlook.com",
                "102101244@fzu.edu..cn",
                "102@101244@fzu.edu.cn"
        };
        for (String email:
                emails) {
            System.out.println(email+" -> "+regex.matches(email));
        }
    }

    public static Lock lock = new ReentrantLock();
    int i = 0;
    Boolean flag = false;
    void testThread(){
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12};


        new Thread(() -> {
            while (i < 10) {

                try {
                    lock.lock();
                    while (!flag) {
                        System.out.println(Thread.currentThread().getName()
                                + "----" + arr[i++]);
                        flag = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();

        new Thread(() -> {
            while (i< 10) {

                try {
                    lock.lock();
                    while (flag) {
                        System.out.println(Thread.currentThread().getName()
                                + "----" + arr[i++]);
                        flag = false;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }).start();
    }
    int getI(){
        return i++;
    }
    void reverseFlag(){
        flag=!flag;
    }

}

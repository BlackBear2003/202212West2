package com.wzl.shop;

import com.wzl.animal.Animal;
import com.wzl.customer.Customer;

public interface AnimalShop {

    Boolean buyAnimal(Animal animal);

    void welcome(Customer customer);

    void close();

}

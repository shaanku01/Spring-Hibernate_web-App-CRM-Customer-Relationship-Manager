package com.springdemo.service;

import com.springdemo.entity.Customer;

import java.util.List;


public interface CustomerService {

    public void saveCustomer(Customer customer);
    public List<Customer> getCustomers();

    Customer getCustomer(int id);
}

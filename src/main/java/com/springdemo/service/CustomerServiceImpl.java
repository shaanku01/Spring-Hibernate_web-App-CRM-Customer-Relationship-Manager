package com.springdemo.service;

import com.springdemo.dao.CustomerDAO;
import com.springdemo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;


    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
         customerDAO.saveCustomer(customer);
    }

    @Override
    @Transactional
    public List<Customer> getCustomers() {

        return customerDAO.getCustomers();
    }

    @Override
    @Transactional
    public Customer getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }
}

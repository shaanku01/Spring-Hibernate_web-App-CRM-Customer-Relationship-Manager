package com.springdemo.dao;

import com.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
       public List<Customer> getCustomers() {
        // get the current hibernate Session
        Session session = sessionFactory.getCurrentSession();
        //Create a query
        Query<Customer> theQuery = session.createQuery("from Customer order by lastName" , Customer.class);
        //execute the Query and get the list
        List<Customer> customers = theQuery.getResultList();

        // return the result

        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
        // get the hibernate Session
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);

        //Save the customer
    }

    @Override
    public Customer getCustomer(int id) {

        Session session = sessionFactory.getCurrentSession();

        Customer customer = session.get(Customer.class,id);

        return customer;

    }
}






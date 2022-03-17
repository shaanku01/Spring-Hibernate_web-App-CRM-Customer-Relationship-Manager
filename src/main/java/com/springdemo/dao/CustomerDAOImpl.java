package com.springdemo.dao;

import com.springdemo.entity.Customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    @Override
    public void deleteCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Customer where id=:customerId");
        query.setParameter("customerId",id);
        query.executeUpdate();



    }

    @Override
    public void deleteCustomers(int[] checkboxValue) {
        Session session = sessionFactory.getCurrentSession();

        for(int i : checkboxValue){
            Query query = session.createQuery("delete from Customer where id=:customerId");
            query.setParameter("customerId",i);
            query.executeUpdate();

        }


    }

    @Override
    public List<Customer> searchCustomers(String searchName) {
        Session session = sessionFactory.getCurrentSession();
        Query theQuery = null;
        if(searchName !=null && searchName.trim().length()>0){
            theQuery = session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName",Customer.class);
            theQuery.setParameter("theName","%"+searchName.toLowerCase()+"%" );
        }
        else{
            theQuery = session.createQuery("from Customer",Customer.class);
        }
        List<Customer> customers = theQuery.getResultList();

        return customers;
    }


}






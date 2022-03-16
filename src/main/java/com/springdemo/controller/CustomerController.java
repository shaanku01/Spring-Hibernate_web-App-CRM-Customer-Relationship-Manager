package com.springdemo.controller;

import com.springdemo.dao.CustomerDAO;
import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @GetMapping("/list")
    public String listCustomers(Model model){

        // get customers from service
        List<Customer> theCustomers  =customerService.getCustomers();

        //add the customers to thr Spring MVC model:
        model.addAttribute("Customers",theCustomers);

        //

        return "list-customer";
    }

    @GetMapping("/showFormForAdd")
    public String showFromForAdd(Model model){

        Customer customer = new Customer();
        model.addAttribute("customer",customer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){

        customerService.saveCustomer(customer);


        return"redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int id,Model model){

        // get customer from service:
        Customer customer = customerService.getCustomer(id);

        //set customer to model attribute to pre-populate the form
        model.addAttribute("customer",customer);

        //send over to the form.
        return "customer-form";


    }
}

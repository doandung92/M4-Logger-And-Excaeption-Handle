package com.codegym.controller;

import com.codegym.exception.NotFoundException;
import com.codegym.model.Customer;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping
    public String showListCustomers(Model model){
        Iterable<Customer> customers = customerService.findAll();
        model.addAttribute("customers",customers);
        return "list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("customer", new Customer());
        return "create";
    }
    @PostMapping("/create")
    public String saveCustomer(Customer customer){
        customerService.save(customer);
        return "redirect:/customers";
    }
    @GetMapping("/{id}")
    public String showDetailCustomer(@PathVariable("id") Long id, Model model) throws NotFoundException {
        Customer customer = customerService.findById(id);
        model.addAttribute("customer", customer);
        return "detail";
    }
    @ExceptionHandler(NotFoundException.class)
    public String handleCustomerNotFound(){
        return "show404";
    }
}

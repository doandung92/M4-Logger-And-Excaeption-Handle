package com.codegym.service.customer;

import com.codegym.exception.NotFoundException;
import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService implements ICustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) throws NotFoundException {
        Customer customer = customerRepository.findOne(id);
        if (customer == null) throw new NotFoundException("Customer with id= " +id +" is not found");
        return customer;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.delete(id);
    }
}

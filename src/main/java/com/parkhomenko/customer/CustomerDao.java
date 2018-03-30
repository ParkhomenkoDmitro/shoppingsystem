/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.customer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dmytro
 */
@Repository
public class CustomerDao implements CustomerDaoInterface {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerDao(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public List<CustomerDto> getCustomers(Pageable pageable) {
        Page<Customer> customers = customerRepo.findAll(pageable);
        List<CustomerDto> result = customers.stream()
                .map(Customer::buildToDto)
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public CustomerDto getCustomer(long id) {
        Optional<Customer> customerOptional = customerRepo.findById(id);

        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return customer.buildToDto();
        }

        return null;
    }

    @Override
    public void signUpByPassword(CustomerDto customerDto) {
        customerRepo.save(new Customer(customerDto));
    }

    @Override
    public CustomerDto findByLogin(String login) {
        Customer customer = customerRepo.findByLogin(login);

        if (customer == null) {
            return null;
        }

        return customer.buildToDto();
    }

}

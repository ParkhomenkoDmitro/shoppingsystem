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
                .map(item -> {
                    final CustomerDto dto = new CustomerDto();
                    dto.customerId = item.getId();
                    dto.login = item.getLogin();
                    return dto;
                }).collect(Collectors.toList());
        return result;
    }

    @Override
    public CustomerDto getCustomer(long id) {
        Optional<Customer> customer = customerRepo.findById(id);

        if (customer.isPresent()) {
            CustomerDto dto = new CustomerDto();
            dto.customerId = customer.get().getId();
            dto.login = customer.get().getLogin();
            return dto;
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
        CustomerDto dto = new CustomerDto();
        dto.customerId = customer.getId();
        dto.login = customer.getLogin();
        return dto;
    }

}

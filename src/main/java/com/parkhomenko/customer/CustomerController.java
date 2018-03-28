/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.customer;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dmytro
 */
@RestController
@RequestMapping(value="/customers")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
    
    @GetMapping
    public List<CustomerDto> getCustomers(Pageable pageable) {
        return customerService.getCustomers(pageable);
    }
    
    @GetMapping("/{customerId}")
    public CustomerDto getCustomer(@PathVariable Long customerId) {
        return customerService.getCustomer(customerId);
    }
    
    /**
     * The simplest authentication method by login & password
     * @param customerDto contains login & password
     */
    @PostMapping("/sign-up")
    public void signUpByPassword(@RequestBody CustomerDto customerDto) {
        customerService.signUpByPassword(customerDto);
    }
}

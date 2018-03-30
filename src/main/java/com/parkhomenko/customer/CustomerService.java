/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.customer;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author dmytro
 */

@Service
@Transactional
public class CustomerService {

    private final CustomerDaoInterface customerDaoInterface;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public CustomerService(CustomerDaoInterface customerDaoInterface, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.customerDaoInterface = customerDaoInterface;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public List<CustomerDto> getCustomers(Pageable pageable) {
        return customerDaoInterface.getCustomers(pageable);
    }
    
    public CustomerDto getCustomer(long id) {
        return customerDaoInterface.getCustomer(id);
    }
    
    public void signUpByPassword(CustomerDto customerDto) {
        String encodedPassword = bCryptPasswordEncoder.encode(customerDto.getPassword());
        CustomerDto customerWithHashedPassword = CustomerDto.createBuilder(
                customerDto.getLogin(), 
                encodedPassword, 
                customerDto.getPhone())
                .build();
        
        customerDaoInterface.signUpByPassword(customerWithHashedPassword);
    }
}

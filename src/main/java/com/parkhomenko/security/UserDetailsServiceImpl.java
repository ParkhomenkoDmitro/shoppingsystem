/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.security;

import com.parkhomenko.customer.CustomerDao;
import com.parkhomenko.customer.CustomerDto;
import static java.util.Collections.emptyList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
/**
 *
 * @author dmytro
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final CustomerDao customerDao;

    @Autowired
    public UserDetailsServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    
    @Override
    public UserDetails loadUserByUsername(String customerLogin) throws UsernameNotFoundException {
        CustomerDto customer = customerDao.findByLogin(customerLogin);
        if(customer == null) {
            throw new UsernameNotFoundException(customerLogin);
        }
        
        return new User(customer.login, customer.password, emptyList());
    }
}

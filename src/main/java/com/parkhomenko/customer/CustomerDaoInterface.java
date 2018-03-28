/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.customer;

import java.util.List;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author dmytro
 */
public interface CustomerDaoInterface {
    List<CustomerDto> getCustomers(Pageable pageable);
    CustomerDto getCustomer(long id);
    void signUpByPassword(CustomerDto customerDto);
    CustomerDto findByLogin(String login);
}

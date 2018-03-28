/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.customer;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dmytro
 */

public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Customer findByLogin(String login);
}

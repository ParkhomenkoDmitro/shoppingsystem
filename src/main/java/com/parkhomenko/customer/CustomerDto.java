/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.customer;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * @author dmytro
 */

@ToString
@EqualsAndHashCode
public class CustomerDto {
    public Long customerId;
    public String login;
    public String password;
    public String phone;
}

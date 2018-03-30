/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.customer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author dmytro
 */

@ToString
@EqualsAndHashCode
@Getter
public class CustomerDto {

    private final Long customerId;
    private final String login;
    private final String password;
    private final String phone;
    private final Boolean isBlocked;

    public static Builder createBuilder(String login, String password, String phone) {
        return new Builder(login, password, phone);
    }
    
    public static class Builder {
        // Required parameters
        private final String login;
        private final String password;
        private final String phone;
        // Optional parameters - initialized to default values
        private Long customerId = -1L;
        private Boolean isBlocked = false;

        public Builder(String login, String password, String phone) {
            this.login = login;
            this.password = password;
            this.phone = phone;
        }

        public Builder customerId(long val) {
            customerId = val;
            return this;
        }

        public Builder isBlocked(boolean val) {
            isBlocked = val;
            return this;
        }

        public CustomerDto build() {
            return new CustomerDto(this);
        }
    }

    private CustomerDto(Builder builder) {
        customerId = builder.customerId;
        login = builder.login;
        password = builder.password;
        isBlocked = builder.isBlocked;
        phone = builder.phone;
    }

    /**
     * For Jackson deserialize process.
     * Jackson need default construct to deserialize object. 
     * Jackson will then fill the fields via reflection even if they are 
     * private final.
     */
    private CustomerDto() {
        this.customerId = -1L;
        this.login = "";
        this.password = "";
        this.phone = "";
        this.isBlocked = false;
    }
}

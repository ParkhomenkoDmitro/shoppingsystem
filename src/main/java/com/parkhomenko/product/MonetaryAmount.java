/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.product;

import java.util.Currency;

/**
 *
 * @author dmytro
 */
public interface MonetaryAmount extends Comparable<MonetaryAmount> {
    Object getValue();
    Currency getCurrency();
    MonetaryAmount add(MonetaryAmount monetaryAmount);
    MonetaryAmount multiply(int count);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkhomenko.product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;

/**
 *
 * @author dmytro
 */
public final class DecimalMonetaryAmount implements MonetaryAmount, Serializable {

    private final BigDecimal value;
    private final Currency currency;

    /**
     *
     * @param value - string presentation of money from JSON or XML
     * @param currency
     */
    public DecimalMonetaryAmount(String value, Currency currency) {
        this.value = new BigDecimal(value);
        this.currency = currency;
    }

    DecimalMonetaryAmount(BigDecimal value, Currency currency) {
         this.value = value;
         this.currency = currency;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

    @Override
    public MonetaryAmount add(MonetaryAmount monetaryAmount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MonetaryAmount multiply(int count) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(MonetaryAmount o) {
        if (isCurrencyEqual(o.getCurrency())) {
            return value.compareTo((BigDecimal) o.getValue());
        } else {
            throw new UnsupportedOperationException("Diff currency values. Not supported yet.");
        }
    }

    private boolean isCurrencyEqual(Currency currency) {
        return this.currency.getCurrencyCode().equals(currency.getCurrencyCode());
    }

}

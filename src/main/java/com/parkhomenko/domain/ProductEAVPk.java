//
// This file was generated by the Jeddict
//
package com.parkhomenko.domain;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class ProductEAVPk implements Serializable {

    private Long productProperty;

    private Long product;

    public ProductEAVPk() {
    }

    public ProductEAVPk(Long productProperty, Long product) {
        this.productProperty = productProperty;
        this.product = product;
    }

    public Long getProductProperty() {
        return this.productProperty;
    }

    public void setProductProperty(Long productProperty) {
        this.productProperty = productProperty;
    }

    public Long getProduct() {
        return this.product;
    }

    public void setProduct(Long product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!java.util.Objects.equals(getClass(), obj.getClass())) {
            return false;
        }
        final ProductEAVPk other = (ProductEAVPk) obj;
        if (!java.util.Objects.equals(this.getProductProperty(), other.getProductProperty())) {
            return false;
        }
        if (!java.util.Objects.equals(this.getProduct(), other.getProduct())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.getProductProperty() != null ? this.getProductProperty().hashCode() : 0);
        hash = 29 * hash + (this.getProduct() != null ? this.getProduct().hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "ProductEAVPk{" + " productProperty=" + productProperty + ", product=" + product + '}';
    }

}
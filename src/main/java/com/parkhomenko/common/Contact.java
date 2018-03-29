/**
 * This file was generated by the Jeddict
 */
package com.parkhomenko.common;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dmytro
 */
@NoArgsConstructor
@Data
@Embeddable
public class Contact {

    @Column(unique = true, nullable = false)
    @Basic
    private String phone;

    @Column(unique = true)
    @Basic
    private String email;

    @Basic
    private String city;

    @Basic
    private String street;

    @Basic
    private String flat;

    @Basic
    private String fax;

    @Basic
    private String postalCode;

    @Basic
    private String entrance;

    @Basic
    private String attribute;

    @Embedded
    private GeoCoordinate geoCoordinate;
}
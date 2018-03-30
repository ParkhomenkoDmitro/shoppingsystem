package com.parkhomenko.customer;

import com.parkhomenko.common.Contact;
import com.parkhomenko.common.GeoCoordinate;
import com.parkhomenko.common.Language;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author dmytro
 */

@NoArgsConstructor
@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Basic
    private String login;

    @Column(nullable = false)
    @Basic
    private String password;

    @Basic
    private String status;

    @Column(nullable = true)
    @Basic
    private boolean isBlocked;

    @Embedded
    private Contact contact;

    @OneToOne(targetEntity = Language.class)
    private Language defaultLanguage;

    @OneToMany(targetEntity = Session.class)
    @JoinColumn(name = "CUSTOMER_ID")
    private List<Session> sessions;

    public Customer(CustomerDto customerDto) {
        login = customerDto.getLogin();
        password = customerDto.getPassword();
        contact = new Contact();
        contact.setGeoCoordinate(new GeoCoordinate());
        contact.setPhone(customerDto.getPhone());
    }
    
    public CustomerDto buildToDto() {
         return CustomerDto.createBuilder(
                login,
                password,
                contact.getPhone())
                .customerId(id)
                .isBlocked(isBlocked)
                .build();
    }
 
    public void addSession(Session session) {
        getSessions().add(session);
    }

    public void removeSession(Session session) {
        getSessions().remove(session);
    }
}
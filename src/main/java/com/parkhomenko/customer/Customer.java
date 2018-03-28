package com.parkhomenko.customer;

import com.parkhomenko.common.Contact;
import com.parkhomenko.common.Language;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * @author dmytro
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String login;

    @Basic
    private String password;

    @Basic
    private String status;

    @Basic
    private boolean isBlocked;

    @Embedded
    private Contact contact;

    @OneToOne(targetEntity = Language.class)
    private Language defaultLanguage;

    @OneToMany(targetEntity = Session.class)
    @JoinColumn(name = "CUSTOMER_ID")
    private List<Session> sessions;

    public Customer() {
    }

    public Customer(CustomerDto customerDto) {
        this.login = customerDto.login;
        this.password = customerDto.password;
    }
    
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isIsBlocked() {
        return this.isBlocked;
    }

    public void setIsBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public Contact getContact() {
        return this.contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Language getDefaultLanguage() {
        return this.defaultLanguage;
    }

    public void setDefaultLanguage(Language defaultLanguage) {
        this.defaultLanguage = defaultLanguage;
    }

    public List<Session> getSessions() {
        if (sessions == null) {
            sessions = new ArrayList<>();
        }
        return this.sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }

    public void addSession(Session session) {
        getSessions().add(session);
    }

    public void removeSession(Session session) {
        getSessions().remove(session);
    }

}
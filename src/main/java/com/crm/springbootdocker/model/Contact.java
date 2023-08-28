package com.crm.springbootdocker.model;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Contact {
    private @Id @GeneratedValue Long id;
    private String firstName;
    private String lastName;
    private String email;

    //private Contact() {}

    public Contact(String name, String lname, String eName) {

        this.firstName = name;
        this.lastName = lname;
        this.email = eName;
    }
}

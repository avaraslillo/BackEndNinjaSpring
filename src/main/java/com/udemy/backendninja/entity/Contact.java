package com.udemy.backendninja.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="contact")
public class Contact {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    @Column(name="firstname")
    private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="telephone")
    private String telephone;
    @Column(name="city")
    private String city;

    

    public String getFirstname() {
        return firstname;
    }



    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }



    public String getLastname() {
        return lastname;
    }



    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



    public String getTelephone() {
        return telephone;
    }



    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }



    public String getCity() {
        return city;
    }



    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }
    







    public Contact(int id, String firstname, String lastname, String telephone, String city) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.telephone = telephone;
        this.city = city;
    }



    public Contact(){

    }





    
    
}

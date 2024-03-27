package com.udemy.backendninja.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="user_role",uniqueConstraints = @UniqueConstraint(
    columnNames={"role","username"}))
public class UserRole {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_role_id",unique=true,nullable=false)
    private Integer userRoleId;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="username",nullable=false)
    private User user;
    @Column(name="role",nullable=false,length=45)
    private String role;
    public UserRole(User user, String role) {
        this.user = user;
        this.role = role;
    }

    public UserRole(){
        
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    
}

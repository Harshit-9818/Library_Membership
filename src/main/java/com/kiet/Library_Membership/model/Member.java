package com.kiet.Library_Membership.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate joinDate;

    private int issuedBooks;

    private boolean active;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public int getIssuedBooks() {
        return issuedBooks;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public void setIssuedBooks(int issuedBooks) {
        this.issuedBooks = issuedBooks;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}

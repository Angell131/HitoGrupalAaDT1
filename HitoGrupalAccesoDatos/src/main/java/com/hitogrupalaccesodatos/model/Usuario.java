package com.hitogrupalaccesodatos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "LOGIN", nullable = false, length = 12)
    private String id;

    @Column(name = "PASS", length = 40)
    private String pass;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Usuario(String id, String pass) {
        this.id = id;
        this.pass = pass;
    }
    public Usuario(){}
}
package com.hitogrupalaccesodatos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "recomendacion")
public class Recomendacion {
    @Id
    @Column(name = "IDRECOMENDACION", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOGIN")
    private Usuario login;

    @Column(name = "Juego", length = 200)
    private String juego;

    @Column(name = "Genero", length = 100)
    private String genero;

    @Column(name = "Valoracion")
    private Integer valoracion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getLogin() {
        return login;
    }

    public void setLogin(Usuario login) {
        this.login = login;
    }

    public String getJuego() {
        return juego;
    }

    public void setJuego(String juego) {
        this.juego = juego;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

}
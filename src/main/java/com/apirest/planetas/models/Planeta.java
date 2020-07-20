package com.apirest.planetas.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;

@Document
public class Planeta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    private String nome;

    private String clima;

    private long terreno;

    public Planeta(Integer id, String nome, String clima, long terreno) {
        this.id = id;
        this.nome = nome;
        this.clima = clima;
        this.terreno = terreno;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public Long getTerreno() {
        return terreno;
    }

    public void setTerreno(Long terreno) {
        terreno = terreno;
    }

    @Override
    public String toString() {
        return "Planeta{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", clima='" + clima + '\'' +
                ", terreno=" + terreno +
                '}';
    }
}

package com.apirest.planetas.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class Planeta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    private String nome;

    private String clima;

    private String terreno;

    private Integer qtdFilmes;

    public Planeta(Integer id, String nome, String clima, String terreno, Integer qtdFilmes) {
        this.id = id;
        this.nome = nome;
        this.clima = clima;
        this.terreno = terreno;
        this.qtdFilmes = qtdFilmes;
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

    public String getTerreno() {
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

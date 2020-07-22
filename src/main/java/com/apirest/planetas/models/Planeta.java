package com.apirest.planetas.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Bárbara Castro
 */
@Document
public class Planeta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private ObjectId _id;
    private Integer id;
    private String nome;
    private String clima;
    private String terreno;
    private Integer qtdFilmes;

    public Planeta() {

    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
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

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public Integer getQtdFilmes() {
        return qtdFilmes;
    }

    public void setQtdFilmes(Integer qtdFilmes) {
        this.qtdFilmes = qtdFilmes;
    }

    @Override
    public String toString() {
        return "Planeta{" +
                "_id=" + _id +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", clima='" + clima + '\'' +
                ", terreno='" + terreno + '\'' +
                ", qtdFilmes=" + qtdFilmes +
                '}';
    }
}

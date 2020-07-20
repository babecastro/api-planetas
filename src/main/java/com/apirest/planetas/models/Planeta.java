package com.apirest.planetas.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Planeta")
public class Planeta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Integer id;

    private String nome;

    private String clima;

    private Long Terreno;

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
        return Terreno;
    }

    public void setTerreno(Long terreno) {
        Terreno = terreno;
    }
}

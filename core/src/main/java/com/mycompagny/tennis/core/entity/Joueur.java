package com.mycompagny.tennis.core.entity;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * @author k.milet
 */
@Entity
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private Character sexe;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Character getSexe() {
        return sexe;
    }

    public void setSexe(Character sexe) {
        this.sexe = sexe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Joueur joueur)) return false;
        return getId().equals(joueur.getId()) && getNom().equals(joueur.getNom()) && getPrenom().equals(joueur.getPrenom()) && getSexe().equals(joueur.getSexe());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNom(), getPrenom(), getSexe());
    }
}

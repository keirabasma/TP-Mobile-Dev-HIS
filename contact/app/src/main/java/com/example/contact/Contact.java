package com.example.contact;

import java.io.Serializable;

public class Contact implements Serializable {
    private String nom;
    private String prenom;
    private String telephone;
    private int photo;

    public Contact(String nom, String prenom, String telephone, int photo) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.photo = photo;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public int getPhoto() {
        return photo;
    }
}

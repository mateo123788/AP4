/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author m.sage
 */
public class User {

    //atribue
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String initial;

    //construteur
    public User(int id, String nom, String prenom, String email, String initial) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.initial = initial;
    }

    //methode
    //get
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getInitial() {
        return initial;
    }

    //set
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    //toString
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", initial=" + initial + '}';
    }

}

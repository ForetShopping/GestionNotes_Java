/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnotes.ConnexionBDD;

import java.util.Date;

/**
 *
 * @author JOSEPH_POLA
 */
public class Eleves {
    private String matricule;
    private String nom;
    private String prenom;
    private String nomPere;
    private String nomMere;
    private Date   dateNaissance;
    private String niveau;
    private String photo;

    public Eleves() {
    }

       
    public Eleves(String matricule,String nom, String prenom, String nomPere, String nomMere, Date dateNaissance, String niveau, String photo) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.nomPere = nomPere;
        this.nomMere = nomMere;
        this.dateNaissance = dateNaissance;
        this.niveau = niveau;
        this.photo = photo;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNomPere() {
        return nomPere;
    }

    public String getNomMere() {
        return nomMere;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getNiveau() {
        return niveau;
    }

    public String getPhoto() {
        return photo;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNomPere(String nomPere) {
        this.nomPere = nomPere;
    }

    public void setNomMere(String nomMere) {
        this.nomMere = nomMere;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    
}

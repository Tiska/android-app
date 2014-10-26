package caisseapp.tiskacorp.fr.caisseapp.beans;

import com.orm.SugarRecord;

import java.util.Date;


/**
 * Created by Tiska on 15/07/2014.
 */
public class Client extends SugarRecord<Client> {

    private String nom;
    private String prenom;
    private Integer phone;
    private String adresse;
    private String codePostal;
    private String ville;
    private String email;
    private Date birthday;

    public Client() {
    }

    public Client(String nom, String prenom, Integer phone, String adresse, String codePostal, String ville, String email, Date birthday) {
        this.nom = nom;
        this.prenom = prenom;
        this.phone = phone;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.email = email;
        this.birthday = birthday;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return this.ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}

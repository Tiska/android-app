package caisseapp.tiskacorp.fr.caisseapp.beans;

import com.orm.SugarRecord;

/**
 * Created by Tiska on 15/07/2014.
 */
public class PrestationValue extends SugarRecord<PrestationValue> {

    private Long idPrestationType;
    private String libelle;
    private Float prix;
    private Long duree;
    //signifie que le produit n'est plus vendu
    private boolean obsolete;

    public PrestationValue() {
    }

    public PrestationValue(Long idPrestationType, String libelle, Float prix, Long duree, boolean obsolete) {
        this.idPrestationType = idPrestationType;
        this.libelle = libelle;
        this.prix = prix;
        this.duree = duree;
        this.obsolete = obsolete;
    }

    public Long getIdPrestationType() {
        return idPrestationType;
    }

    public void setIdPrestationType(Long idPrestationType) {
        this.idPrestationType = idPrestationType;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Long getDuree() {
        return duree;
    }

    public void setDuree(Long duree) {
        this.duree = duree;
    }

    public boolean isObsolete() {
        return obsolete;
    }

    public void setObsolete(boolean obsolete) {
        this.obsolete = obsolete;
    }
}

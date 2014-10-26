package caisseapp.tiskacorp.fr.caisseapp.beans;

import com.orm.SugarRecord;

/**
 * Created by Tiska on 15/07/2014.
 */
public class ProduitValue extends SugarRecord<ProduitValue> {

    private Long idProduitType;
    private String libelle;
    private Float prixAchat;
    private Float prixVente;
    private Integer stock;
    //signifie que le produit n'est plus vendu
    private boolean obsolete;
    //utilisé pour calculé le prix de vente
    private Float coefficiant;

    public ProduitValue() {
    }

    public ProduitValue(Long idProduitType, String libelle, Float prixAchat, Float prixVente, Integer stock, boolean obsolete, Float coefficiant) {
        this.idProduitType = idProduitType;
        this.libelle = libelle;
        this.prixAchat = prixAchat;
        this.prixVente = prixVente;
        this.stock = stock;
        this.obsolete = obsolete;
        this.coefficiant = coefficiant;
    }

    public Long getIdProduitType() {
        return idProduitType;
    }

    public void setIdProduitType(Long idProduitType) {
        this.idProduitType = idProduitType;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Float getPrixAchat() {
        return prixAchat;
    }

    public void setPrixAchat(Float prixAchat) {
        this.prixAchat = prixAchat;
    }

    public Float getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(Float prixVente) {
        this.prixVente = prixVente;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public boolean isObsolete() {
        return obsolete;
    }

    public void setObsolete(boolean obsolete) {
        this.obsolete = obsolete;
    }

    public Float getCoefficiant() {
        return coefficiant;
    }

    public void setCoefficiant(Float coefficiant) {
        this.coefficiant = coefficiant;
    }
}

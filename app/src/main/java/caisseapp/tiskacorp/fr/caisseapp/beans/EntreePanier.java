package caisseapp.tiskacorp.fr.caisseapp.beans;

import com.orm.SugarRecord;

/**
 * Created by Tiska on 15/07/2014.
 */
public class EntreePanier extends SugarRecord<EntreePanier> {

    private Long idProduit;
    private Long idPanier;
    private Float prixAvecReduction;
    private Integer quantite;
    private Float reduction;
    private Integer typeReduction;

    public EntreePanier(Long idProduit,Long idPanier, Float prixAvecReduction, Integer quantite, Float reduction, Integer typeReduction) {
        this.idProduit = idProduit;
        this.prixAvecReduction = prixAvecReduction;
        this.quantite = quantite;
        this.reduction = reduction;
        this.typeReduction = typeReduction;
        this.idPanier=idPanier;
    }

    public EntreePanier() {
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public Float getPrixAvecReduction() {
        return prixAvecReduction;
    }

    public void setPrixAvecReduction(Float prixAvecReduction) {
        this.prixAvecReduction = prixAvecReduction;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Float getReduction() {
        return reduction;
    }

    public void setReduction(Float reduction) {
        this.reduction = reduction;
    }

    public Integer getTypeReduction() {
        return typeReduction;
    }

    public void setTypeReduction(Integer typeReduction) {
        this.typeReduction = typeReduction;
    }

    public Long getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(Long idPanier) {
        this.idPanier = idPanier;
    }
}

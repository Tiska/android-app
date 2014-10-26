package caisseapp.tiskacorp.fr.caisseapp.beans;

import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by Tiska on 15/07/2014.
 */
public class ProduitType extends SugarRecord<ProduitType> {

    private String libelle;
    private List<ProduitValue> prestations;

    public ProduitType() {
    }

    public ProduitType(String libelle, List<ProduitValue> prestations) {
        this.libelle = libelle;
        this.prestations = prestations;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<ProduitValue> getPrestations() {
        return prestations;
    }

    public void setPrestations(List<ProduitValue> prestations) {
        this.prestations = prestations;
    }
}

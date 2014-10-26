package caisseapp.tiskacorp.fr.caisseapp.beans;

import com.orm.SugarRecord;

import java.sql.Date;
import java.util.List;

/**
 * Created by Tiska on 15/07/2014.
 */
public class PrestationType extends SugarRecord<PrestationType> {

    private String libelle;
    private List<PrestationValue> prestations;

    public PrestationType() {
    }

    public PrestationType(String libelle, List<PrestationValue> prestations) {
        this.libelle = libelle;
        this.prestations = prestations;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<PrestationValue> getPrestations() {
        return prestations;
    }

    public void setPrestations(List<PrestationValue> prestations) {
        this.prestations = prestations;
    }
}

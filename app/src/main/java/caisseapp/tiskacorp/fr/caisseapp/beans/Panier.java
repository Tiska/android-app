package caisseapp.tiskacorp.fr.caisseapp.beans;

import com.orm.SugarRecord;

import java.sql.Date;
import java.util.List;

/**
 * Created by Tiska on 15/07/2014.
 */
public class Panier extends SugarRecord<Panier> {

    private Long idClient;
    private Float total;
    private Integer typePaiement;
    private Date date;
    private List<EntreePanier> produits;

    public Panier(Float total, Integer typePaiement, Date date, List<EntreePanier> produits, Long idClient) {
        this.total = total;
        this.typePaiement = typePaiement;
        this.date = date;
        this.produits = produits;
        this.idClient=idClient;
    }

    public Panier() {
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Integer getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(Integer typePaiement) {
        this.typePaiement = typePaiement;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<EntreePanier> getProduits() {
        return produits;
    }

    public void setProduits(List<EntreePanier> produits) {
        this.produits = produits;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }
}

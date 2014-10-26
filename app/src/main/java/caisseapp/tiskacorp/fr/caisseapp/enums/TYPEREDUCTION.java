package caisseapp.tiskacorp.fr.caisseapp.enums;

/**
 * Created by Tiska on 16/07/2014.
 */
public enum TYPEREDUCTION {
    POURCENTAGE(0,"pourcentage"),
    VALEUR(1,"valeur");

    private int key;
    private String value;

    TYPEREDUCTION(int key, String value) {
        this.key=key;
        this.value=value;
    }

    public TYPEREDUCTION getByKey(int key){
        for(TYPEREDUCTION type : TYPEREDUCTION.values()){
            if (type.getKey()==key){
                return type;
            }
            else{
                return null;
            }
        }
        return null;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}

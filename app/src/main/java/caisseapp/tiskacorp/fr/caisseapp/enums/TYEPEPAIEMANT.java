package caisseapp.tiskacorp.fr.caisseapp.enums;

/**
 * Created by Tiska on 16/07/2014.
 */
public enum TYEPEPAIEMANT {
    CARTE(0,"carte"),
    CHEQUE(1,"cheque"),
    LIQUIDE(2,"liquide");

    private int key;
    private String value;

    TYEPEPAIEMANT(int key, String value) {
        this.key=key;
        this.value=value;
    }

    public TYEPEPAIEMANT getByKey(int key){
        for(TYEPEPAIEMANT type : TYEPEPAIEMANT.values()){
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

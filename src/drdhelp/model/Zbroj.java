/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;



/*******************************************************************************
 * Instance třídy {@code Zbroj} představují určitou zbroj nebo štít se světa
 * Dračího Doupěte
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class Zbroj implements IPopis {

//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT AND VARIABLE INSTANCE ATTRIBUTES =================================

/** Id - primární id z databáze */
    private final int ID;

    /** Název výbavy */
    private final String NAZEV;

    /** Druh výbavy */
    private final String DRUH;

    /** Kvalita zbroje */
    private final int KVALITA;

    /** Vaha pro tvory velikosti A */
    private final int VAHA_A;

    /** Vaha pro tvory velikosti B */
    private final int VAHA_B;

    /** Vaha pro tvory velikosti C */
    private final int VAHA_C;

    /** Cena pro tvory velikosti A */
    private final int CENA_A;

    /** Cena pro tvory velikosti B */
    private final int CENA_B;

    /** Cena pro tvory velikosti C */
    private final int CENA_C;

    /** Popis výbavy */
    private String popis;

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Konstruktor - instance zbroje.
     *
     * @param id Identifikační číslo řádku v databázi
     * @param nazev Název zbroje
     * @param kvalita Kvalita zbroje
     * @param druh Druh zbroje(běžné/magické).
     * @param vahaA Váha zbroje pro postavu velikosti A
     * @param vahaB Váha zbroje pro postavu velikosti B
     * @param vahaC Váha zbroje pro postavu velikosti C
     * @param cenaA Cena zbroje pro postavu velikosti A
     * @param cenaB Cena zbroje pro postavu velikosti B
     * @param cenaC Cena zbroje pro postavu velikosti C
     * @param poznamka Poznámka.
     */
    public Zbroj(int id, String nazev, int kvalita, String druh, int vahaA, int vahaB,
                int vahaC, int cenaA, int cenaB, int cenaC, String poznamka) {
        this.ID = id;
        this.NAZEV = nazev;
        this.DRUH = druh;
        this.KVALITA = kvalita;
        this.VAHA_A = vahaA;
        this.VAHA_B = vahaB;
        this.VAHA_C = vahaC;
        this.CENA_A = cenaA;
        this.CENA_B = cenaB;
        this.CENA_C = cenaC;
        this.popis = poznamka;
    }



//== ABSTRACT METHODS ==========================================================

    @Override
    public String getPodrobnyPopis() {
        return "Název:   " + getNazev() + "\n" +
               "Druh: " + getDruh() + "\n" +
               "Kvalita zbroje:   " + getKvalita() + "\n" +
               "Cena(A/B/C):   " + cenaVypisABC() + "\n" +
               "Vaha(A/B/C:   " + vahaVypisABC() +
               vratPopis();
    }

//== INSTANCE GETTERS AND SETTERS ==============================================

    public int getId() {
        return ID;
    }

    public String getNazev() {
        return NAZEV;
    }

    public String getDruh() {
        return DRUH;
    }

    public int getKvalita() {
        return KVALITA;
    }

    public String getPopis() {
        return popis;
    }

    public int getVahaA() {
        return VAHA_A;
    }

    public int getVahaB() {
        return VAHA_B;
    }

    public int getVahaC() {
        return VAHA_C;
    }

    public int getCenaA() {
        return CENA_A;
    }

    public int getCenaB() {
        return CENA_B;
    }


    public int getCenaC() {
        return CENA_C;
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

private String cenaVypisABC() {
    return CENA_A + "/" + CENA_B + "/" + CENA_C;
}

private String vahaVypisABC() {
    return VAHA_A + "/" + VAHA_B + "/" + VAHA_C;
}

    /**
     * Vrátí popis ve travru "Popis:   " + popis. Pokud je popis nevyplněný (""),
     * vrátí prázdný řetezec "".
     */
    protected String vratPopis() {
        if (!this.popis.equals("") && this.popis != null) {
            return "\n\nPoznámka:\n" + this.popis;
        }
        return "";
    }

//##############################################################################
//== NESTED DATA TYPES =========================================================
}

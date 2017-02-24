/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;





/*******************************************************************************
 * Instance třídy {@code Vybaveni} představují výbavu.
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2016-09-25
 */
public class Vybava implements IPopis {

//== VARIABLE AND CONSTANT CLASS ATTRIBUTES ====================================

    /** název tabulky s atributy instancí v databázi drddesk_db */
    private static final String TABULKA = "vybava";

    /** Uchovává aktuální polozku typu Odkaz, buď prohlíženou, nebo upravovanou */
    private static Odkaz upravaPolozkyVybavy = null;

    /** Uchovává editovanou položku */



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================

    public static Odkaz getUpravaPolozkaVybavy() {
        return upravaPolozkyVybavy;
    }

    public static void setUpravaPolozkaVybavy(Odkaz polozkaVybavy) {
        Vybava.upravaPolozkyVybavy = polozkaVybavy;
    }

    public static String getTabulka() {
        return TABULKA;
    }



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

    /** Váha výbavy */
    private final int VAHA;

    /** Cena výbavy - zlaťáky */
    private final Integer ZLATAKY;

    /** Cena výbavy - stříbrňáky */
    private final Integer STRIBRNAKY;

    /** Cena výbavy - měďáky */
    private final Integer MEDAKY;

    /** Popis výbavy */
    private String popis;

//    //***********BINDING**************
//
//    // String property pro název
//    private final StringProperty nazev = new SimpleStringProperty();



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Konstruktor - instance kusu výbavy.
     *
     * @param id Identifikační číslo řádku v databázi.
     * @param nazev Název vybavení.
     * @param druh Druh vybavení(běžné, magické, lektvar, ...).
     * @param vaha Váha vybavení.
     * @param zlataky Cena vybavení - zlaťáky
     * @param stribrnaky Cena vybavení - stříbrňáky
     * @param medaky Cena vybavení - měďáky
     * @param popis Popis výbavy.
     */
    public Vybava(int id, String nazev, String druh, int vaha, int zlataky,
                                    int stribrnaky, int medaky, String popis) {
        this.ID = id;
        this.NAZEV = nazev;
        this.DRUH = druh;
        this.VAHA = vaha;
        this.ZLATAKY = zlataky;
        this.STRIBRNAKY = stribrnaky;
        this.MEDAKY = medaky;
        this.popis = popis;
    }



//== ABSTRACT METHODS ==========================================================

    @Override
    public String getPodrobnyPopis() {
        return "Název:   " + getNazev() + "\n" +
                "Druh:   " + getDruh() + "\n" +
                "Cena:   " + getCenaVypis() + "\n" +
                "Vaha:   " + getVaha() +
                vratPopis();

        }

//== INSTANCE GETTERS AND SETTERS ==============================================


    public int getId() {
        return ID;
    }

//    public StringProperty nazevProperty() {
//        return nazev;
//    }

    public String getNazev() {
        return NAZEV;
    }

    public String getDruh() {
        return DRUH;
    }

    public int getVaha() {
        return VAHA;
    }

    public int getZlataky() {
        return ZLATAKY;
    }

    public int getStribrnaky() {
        return STRIBRNAKY;
    }

    public int getMedaky() {
        return MEDAKY;
    }

    public String getPopis() {
        return popis;
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    public String getVahaString() {
        return String.format("%dmn",VAHA);
    }

    /** vypíše cenu ve tvaru ?zl ?st ?md */
    public String getCenaVypis() {
        String cena = "";
        if (ZLATAKY > 0) cena += ZLATAKY + "zl ";
        if (STRIBRNAKY > 0) cena += STRIBRNAKY + "st ";
        if (MEDAKY > 0) cena += MEDAKY + "md";
        if (cena.equals("")) cena = "neurčitá";
        return cena;
    }

    @Override
    public String toString() {
        return "název: \t" + getNazev() + "\n" +
               "druh: \t" + getDruh() + "\n" +
               "cena: \t" + getCenaVypis()+ "\n" +
               "vaha: \t" + getVaha() +
               vratPopis();
    }

    /** Vrátí číslo se znaménkem i pro kladná čísla a 0 ve String */
    public String getStringSeZnamenkem(int hodnota) {
        return String.format("%+d",hodnota);
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

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

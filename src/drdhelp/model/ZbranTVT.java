/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;



/*******************************************************************************
 * Instance třídy {@code ZbranTVT} představují zbraně tváří v tvář.
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class ZbranTVT extends Vybava implements IPopis {

//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================

    /** název tabulky s atributy instancí v databázi drddesk_db */
    public static final String tabulka = "zbran_tvt";



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================

    public static String getTabulka() {
        return tabulka;
    }



//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT AND VARIABLE INSTANCE ATTRIBUTES =================================

    /** Uchovává údaj, zda se zbraň drží v jedné ruce nebo obouruč. */
    private final String DRZENI;

    /** Síla zbraně. */
    private final int SILA;

    /** Útočnost zbraně. */
    private final int UTOCNOST;

    /** Obrana zbraně.*/
    private final int OBRANA;

    /** Délka zbraně */
    private final String DELKA;


//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Konstruktor - instance zbraně tváří v tvář.
     *
     * @param id Identifikační číslo řádku v databázi.
     * @param nazev Název zbraně tváří v tvář.
     * @param druh Druh zbraně (lehká/střední/těžká)
     * @param drzeni Údaj, zda se zbraň drží v jedné ruce nebo obouruč.
     * @param sila Síla zbraně.
     * @param utocnost Útočnost zbraně.
     * @param obrana Obrana zbraně.
     * @param delka Délka zbraně, určje dosah zbraně.
     * @param vaha Váha zbraně.
     * @param zlataky Cena vybavení - zlaťáky
     * @param stribrnaky Cena vybavení - stříbrňáky
     * @param medaky Cena vybavení - měďáky
     * @param popis Popis.
     */
    public ZbranTVT(int id, String nazev, String druh, String drzeni, int sila,
                  int utocnost, int obrana, String delka, int vaha, int zlataky,
                                    int stribrnaky, int medaky, String popis) {

        super(id, nazev, druh, vaha, zlataky, stribrnaky, medaky, popis);
        this.DRZENI = drzeni;
        this.SILA = sila;
        this.UTOCNOST = utocnost;
        this.OBRANA = obrana;
        this.DELKA = delka;
    }


//== ABSTRACT METHODS ==========================================================

//== INSTANCE GETTERS AND SETTERS ==============================================

    public String getDrzeni() {
        return DRZENI;
    }

    public int getSila() {
        return SILA;
    }

    public int getUtocnost() {
        return UTOCNOST;
    }

    public int getObrana() {
        return OBRANA;
    }

    public String getDelka() {
        return DELKA;
    }


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    @Override
    public String getPodrobnyPopis() {
        return    "Název:   " + super.getNazev() + "\n"
                + "Druh:   " + super.getDruh() + " " + DRZENI + "\n"
                + "Síla zbraně:   " + SILA + "\n"
                  + "Útočnost:   " + getStringSeZnamenkem(UTOCNOST)+ "\n"
                  + "Obrana zbraně:   " + getStringSeZnamenkem(OBRANA) + "\n"
                + "Délka:   " + DELKA + "\n"
                + "Váha:   " + super.getVaha() + " mn\n"
                + "Cena:   " + super.getCenaVypis()
                + super.vratPopis();
    }

    public String getPopisDoRadku() {
        return super.getNazev() + " " + SILA + " " + super.getStringSeZnamenkem(
                UTOCNOST) + " " + getStringSeZnamenkem(OBRANA) + " " + super
                .getVaha() + " mn";
    }

    @Override
    public String toString() {
        return getNazev();
    }


//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================


//##############################################################################
//== NESTED DATA TYPES =========================================================

}

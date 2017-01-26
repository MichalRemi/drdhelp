/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;



/*******************************************************************************
 * Instance výčtového typu {@code TabulkaDB} reprezentují Název tabulky v
 * databázi drddesk_db a příslušný název s diakritikou. 
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2016-12-19
 */
public enum TabulkaDB {
//== VALUES OF THE ENUMERATION TYPE ============================================
//

    POSTAVA("postava", "Postava"),
    NESTVURA("nestvura", "Nestvůra"),
    ZBRAN_TVT("zbran_tvt", "Zbraň tváří v tvář"),
    ZBRAN_SAV("zbran_sav", "Zbraň střel. a vrhací"),
    ZBROJ("zbroj", "Zbroj"),
    VYBAVA("vybava", "Výbava"),
    POVOLANI("povolani", "Povolání"),
    RASA("rasa", "Rasa"),
    UZIVATEL("uzivatel", "Uživatel");



//##############################################################################
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    private final String tabulka;
    private final String nazev;



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    private TabulkaDB(String tabulka, String nazev) {
        this.tabulka = tabulka;
        this.nazev = nazev;
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    public String getNazev() {
        return this.nazev;
    }

    public String getTabNazev() {
        return this.tabulka;
    }


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    @Override
    public String toString() {
        return tabulka;
    }


//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}

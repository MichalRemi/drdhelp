/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;





/*******************************************************************************
 * Instance třídy {@code Odkaz} představují název a id z různých tabulek.
 *
 * @author  Michal Remišovský
 * @version 0.02.0000 — 2016-12-22
 */
public class Odkaz implements Comparable<Odkaz>{

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

    private final int poradi;
    private final int id;
    protected String nazev;
    private final String tabulka;



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /**
     * Konstruktor
     *
     * @param poradi - Pořadové číslo v kolekci instancí Nazev.
     * @param id - Jedinečné id v tabulce.
     * @param nazev - Název položky v tabulce.
     * @param tabulka - název tabulky, ze které jsou id a nazev.
     */
    public Odkaz(int poradi, int id, String nazev, String tabulka) {
        this.poradi = poradi;
        this.id = id;
        this.nazev = nazev;
        this.tabulka = tabulka;
        }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    public int getPoradi() {
        return poradi;
    }

    public int getId() {
        return id;
    }

    public String getNazev() {
        return nazev;
    }

    public String getTabulka() {
        return tabulka;
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    public int compareTo(Odkaz o) {

		/**
         * Navrať záporné číslo, nulu nebo kladné číslo, pokud je tento objekt
         * menší, stejný nebo větší než "o"
         */
		return getNazev().compareTo(o.getNazev());
	}

//    /**
//     * Vrátí ArrayList-String názvů.
//     *
//     * @param nazvy Kolekce Odkaz.
//     * @return ArrayList String
//     */
//    public ArrayList<String> nazvyListString(ArrayList<Odkaz> nazvy) {
//        ArrayList<String> nazvyString = new ArrayList<>();
//        for (Odkaz n : nazvy) nazvyString.add(n.toString());
//        return nazvyString;
//    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================


    @Override
    public String toString() {
        return nazev;
    }



}

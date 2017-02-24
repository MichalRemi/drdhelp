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

    private final int id;
    private final String nazev;
    private final String tabulka;
    private int pocet = 1;


//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /**
     * Konstruktor
     *
     * @param id - Jedinečné id v tabulce.
     * @param nazev - Řádkový popis položky z tabulce začínající názvem.
     * @param tabulka - název tabulky, ze které jsou id a nazev.
     */
    public Odkaz(int id, String nazev, String tabulka) {
        this.id = id;
        this.nazev = nazev;
        this.tabulka = tabulka;
        }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    public int getId() {
        return id;
    }

    public String getNazev() {
        return nazev;
    }

    public String getTabulka() {
        return tabulka;
    }

    public int getPocet() {
        return pocet;
    }

    public void setPocet(int pocet) {
        this.pocet = pocet;
    }





//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    public int compareTo(Odkaz o) {

		/**
         * Navrať záporné číslo, nulu nebo kladné číslo, pokud je tento objekt
         * menší, stejný nebo větší než "o"
         */
		return getNazev().compareTo(o.getNazev());
	}


//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================


    @Override
    public String toString() {
        return nazev;
    }



}

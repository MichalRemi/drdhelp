/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model.logika;

import drdhelp.model.SeznamOdkazu;
import drdhelp.model.Tvor;





/*******************************************************************************
 *
 * @author  Michal Remišovský
 * @version 0.00.0000 — 2017-01-20
 */
public abstract class Logika {

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



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public Logika() {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================


    /** Ověří platnost názvu, zda není null a zda je jeho délka v rozsahu 1-50 znaků */
    protected boolean jeNazevValidni(String nazev) {
        return jeStringValidni(nazev, 1, 50);
    }


    /**
     * Vrátí id upravovaného odkazu (SeznamOdkazu.upravit), pokud je odkaz null,
     * vrátí null
     */
    protected Integer vratIdOdkazu() {
        if (SeznamOdkazu.getUpravit() != null) {
            return SeznamOdkazu.getUpravit().getId();
        } else return null;
    }

    /** Ověří, zda není String null, a zda je jeho délka v mezích včetně */
    protected boolean jeStringValidni(String text, int dolniMez, int horniMez) {
        if (text != null) {
            int delka = text.length();
            if ((delka >= dolniMez) && (delka <= horniMez)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Otestuje, zda je v atributu text číslo v uzavřeném intervalu od dolniMez
     * do dohorniMez
     */
    protected boolean zvalidujStringCislo(String text, int dolniMez, int horniMez) {
        Integer cislo = StringNaCislo(text);
        return ((cislo != null) && (cislo >= dolniMez) && (cislo <= horniMez));
    }

    /** Vrátí číslo ze Stringu, při vyjímce vrátí null */
    protected Integer StringNaCislo(String text) {
        try {
            return Integer.parseInt(text);
        } catch (Exception e) {
            return null;
        }
    }

     /**
     * Vyhodnotí, zda je hodnota v poli. Pokud ano, vrátí ho
     * v int. Pokud ne, vrátí 0.
     * @param hodnota libovolný String
     * @return String
     */
    protected Integer vyhodnotAVratInt(String hodnota) {
        if (hodnota != null) {
            for (String s : Tvor.HODNOTY) {
                if (hodnota.equals(s)) {
                    if (s.equals("N/A")) return 0;
                    else return Integer.parseInt(s);
                }
            }
        }
        return null;
    }

    /**
     * Pokud je hodnota v poly Tvor.HODNOTY_NA, vrátí ji, jinak vrátí "N/A".
     * @param hodnota libovolný String
     * @return String
     */
    protected String vyhodnotAVratString(Integer hodnota) {
        return vyhodnotAVratString(hodnota, Tvor.HODNOTY_NA);
    }

    /**
     * Vyhodnotí, zda je hodnota v poli. Pokud ano, vrátí ho
     * ve String. Pokud ne, nebo pro hodnotu 0 vrátí "N/A".
     * @param hodnota
     * @param pole
     * @return
     */
    protected String vyhodnotAVratString(Integer hodnota, String[] pole) {
        String hodnotaString = String.valueOf(hodnota);
        if (hodnotaString.equals("0")) return "N/A";
        for (String s : pole) {
            if (hodnotaString.equals(s)) return hodnotaString;
        }
        return "N/A";
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}

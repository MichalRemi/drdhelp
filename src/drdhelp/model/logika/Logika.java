/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model.logika;

import drdhelp.model.Odkaz;
import drdhelp.model.SeznamOdkazu;
import drdhelp.model.Tvor;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.collections.ObservableList;





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
        if (SeznamOdkazu.getAktualniOdkaz()!= null) {
            return SeznamOdkazu.getAktualniOdkaz().getId();
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
        try {
            if (text != null) {
                Integer cislo = prevedNaInteger(text);
                if (cislo != null) {
                    return ((cislo >= dolniMez) && (cislo <= horniMez));
                }
            }
        }
        catch (ParseException ex) {
        }
        return false;
    }

    private Integer prevedNaInteger(String text) throws ParseException {
        if (!text.equals("")) {
            Integer cislo = Integer.parseInt(text);
            return cislo;
        }
        return null;
    }

    /** Převede String na arrayList, oddělovač je ",". */
    protected ArrayList<String> stringToArrayList(String text) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(text.split(",")));
        return arrayList;
    }

    protected String observableListToString(ObservableList<Odkaz> list) {
        String vyslednyText = "";
        for (Odkaz odkaz : list) {
            vyslednyText += odkaz.getNazev();
        }
        int delka = vyslednyText.length();
        // vrátí vyslednyText bez poslední čárky
        return vyslednyText.substring(0, delka-2);
    }

     /**
     * Vyhodnotí, zda je hodnota v poli. Pokud ano, vrátí ho
     * v int. Pokud ne, vrátí 0.
     * @param hodnota libovolný String
     * @return String
     */
    protected Integer vyhodnotAVratInt(String hodnota) {
        if (hodnota != null) {
            for (String s : Tvor.hodnotyArray) {
                if (hodnota.equals(s)) {
                    if (s.equals("N/A")) return 0;
                    else return Integer.parseInt(s);
                }
            }
        }
        return 0;
    }

    /**
     * Pokud je hodnota v poly Tvor.HODNOTY_NA, vrátí ji, jinak vrátí "N/A".
     * @param hodnota libovolný String
     * @return String
     */
    protected String vyhodnotAVratString(Integer hodnota) {
        return vyhodnotAVratString(hodnota, Tvor.hodnotyArray);
    }

    /**
     * Vyhodnotí, zda je hodnota v poli. Pokud ano, vrátí ho ve String. Pokud ne
     * vrátí "N/A".
     * @param hodnota
     * @param pole
     * @return
     */
    protected String vyhodnotAVratString(Integer hodnota, String[] pole) {
        if (hodnota != null) {
            String hodnotaString = String.valueOf(hodnota);
            if (hodnotaString.equals("0")) return "N/A";
            for (String s : pole) {
                if (hodnotaString.equals(s)) return hodnotaString;
            }
        }
        return "N/A";
    }

    /** Pokud je text null, "", nebo "nic" vrátí null, jinak vrátí text */
    protected String vyhodnotAVratString(String text) {
        if (text == null || text.equals("") || text.equals("nic")) return null;
        return text;
    }

    /** Převede prázdný řetězec "" nebo "nic" na null. */
    protected String prazdnyStringNaNull(String text) {
        if (text.equals("") || text.equals("nic")) return null;
        return text;
    }


//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}

/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model.io;

import drdhelp.model.TabulkaDB;
import java.sql.Connection;





/*******************************************************************************
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2016-09-13
 */
public abstract class Data
{
//== CONSTANT CLASS ATTRIBUTES =================================================


    protected static final String HESLO = "onIeawubX7mrKQKc";
    protected static final String USER = "root";
    protected static final String URL = "jdbc:mysql://localhost/drddesk_db" +
                                    "?useUnicode=true&characterEncoding=UTF-8";
    protected static Connection db;
    protected static final String CHYBA = "Chyba při komunikaci s databází!\n";

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
    public Data() {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================,

    /**
     * Porovná předaný název tabulky se seznamem platných tabulek - enum
     * TabulkaDB. Pokud je název tabulky platný, vrátí true, jinak false.
     *
     * @param tabName String
     * @return boolean
     */
    public boolean isTabOk(String tabName) {
        for (TabulkaDB t : TabulkaDB.values()) {
            if (t.getTabNazev().equals(tabName)) return true;
        }
        return false;
    }
    

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}

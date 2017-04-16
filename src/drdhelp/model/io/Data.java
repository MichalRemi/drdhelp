/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model.io;

import drdhelp.ChyboveHlaseni;
import drdhelp.model.TabulkaDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;





/*******************************************************************************
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public abstract class Data
{
//== CONSTANT CLASS ATTRIBUTES =================================================


    protected static final String HESLO = "michal";
    protected static final String USER = "root";
    protected static final String URL = "jdbc:mysql://localhost/drddesk_db" +
                                    "?useUnicode=true&characterEncoding=UTF-8";
    protected static final String CHYBA = "Chyba při komunikaci s databází!\n";
    protected static final String CHYBA_DB = "Chyba spojení s databází!\n";

//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    ChyboveHlaseni chyboveHlaseni = new ChyboveHlaseni();


//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================


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

    protected Connection vytvorSpojeniDB() {
        try {
            Connection db = DriverManager.getConnection(URL, USER, HESLO);
            return db;
        } catch (SQLException ex) {
<<<<<<< HEAD
=======
            System.out.println("Nelze se připojit k databázi!");
            System.out.println("chyba: " + ex);
>>>>>>> origin/master
            chyboveHlaseni.chybaSpojeniDatabaze();
            System.exit(1);
        }
        return null;
    }


//##############################################################################
//== NESTED DATA TYPES =========================================================
}

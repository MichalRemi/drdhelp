/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model.io;

import drdhelp.model.Nestvura;
import drdhelp.model.Odkaz;
import drdhelp.model.Vybava;
import drdhelp.model.ZbranSAV;
import drdhelp.model.ZbranTVT;
import drdhelp.model.Zbroj;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/*******************************************************************************
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2016-10-04
 */
public class SetData extends Data {

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
    public SetData() {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================


//********************************* INSERT *************************************


    /**
     * Vloží novou nestvůru do databáze drddesk_db.
     *
     * @param nestvura Nestvůra
     * @return boolean
     */
    public boolean vlozNestvura(Nestvura nestvura) {
        try {
            db = DriverManager.getConnection(URL, USER, HESLO);
            String sql = "INSERT INTO nestvura (nazev, zivotaschopnost, utok," +
                    " obrana, sila, obratnost, odolnost, inteligence, charisma," +
                    " velikost, bojovnost, zranitelnost, skupiny_zranitelnost," +
                    " pohyblivost, skupiny_pohyblivost, vytrvalost, skupiny_vytrvalost," +
                    " manevr_schopnost, zakl_sila_mysli, ochoceni, presvedceni," +
                    " poklady, zkusenost, poznamka) VALUES (?, ?, ?, ?, ?, ?, ?," +
                    " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement dotaz = db.prepareStatement(sql);

            dotaz.setString(1, nestvura.getNazev());
            dotaz.setInt(2, nestvura.getZivotaschopnost());
            dotaz.setString(3, nestvura.getUtok());
            dotaz.setInt(4, nestvura.getObrana());
            dotaz.setInt(5, nestvura.getVlastnosti().getVlastnost(0).getHodnota());
            dotaz.setInt(6, nestvura.getVlastnosti().getVlastnost(1).getHodnota());
            dotaz.setInt(7, nestvura.getVlastnosti().getVlastnost(2).getHodnota());
            dotaz.setInt(8, nestvura.getVlastnosti().getVlastnost(3).getHodnota());
            dotaz.setInt(9, nestvura.getVlastnosti().getVlastnost(4).getHodnota());
            dotaz.setString(10, nestvura.getZranitelnost());
            dotaz.setString(11, nestvura.getSkupinaZranitelnost());
            dotaz.setInt(12, nestvura.getPohyblivost().getHodnota());
            dotaz.setString(13, nestvura.getSkupinaPohyblivost());
            dotaz.setInt(14, nestvura.getVytrvalost().getHodnota());
            dotaz.setString(15, nestvura.getSkupinaVytrvalost());
            dotaz.setInt(16, nestvura.getManevrSchopnost());
            dotaz.setInt(17, nestvura.getZaklSilaMysli());
            dotaz.setString(18, nestvura.getPresvedceni());
            dotaz.setString(19, nestvura.getPoklady());
            dotaz.setInt(20, nestvura.getZkusenost());
            dotaz.setInt(21, nestvura.getOchoceni());
            dotaz.setString(22, nestvura.getPoznamka());
            dotaz.executeUpdate();
            return true;
        } catch (SQLException ex) {
        System.err.println(CHYBA + ex);
        return false;
        }
    }

    /**
     * Vloží novou zbraň tváří v tvář do databáze drddesk_db.
     *
     * @param zbranTvT ZbranTVT
     * @return boolean
     */
    public boolean vlozZbranTVT(ZbranTVT zbranTvT) {
        try {
            db = DriverManager.getConnection(URL, USER, HESLO);
            String sql = "INSERT INTO zbran_tvt (nazev, druh, drzeni, sila," +
            " utocnost, obrana, delka, vaha, zlataky, stribrnaky, medaky," +
                    " poznamka) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement dotaz = db.prepareStatement(sql);
            dotaz.setString(1, zbranTvT.getNazev());
            dotaz.setString(2, zbranTvT.getDrzeni());
            dotaz.setString(3, zbranTvT.getDruh());
            dotaz.setInt(4, zbranTvT.getSila());
            dotaz.setInt(5, zbranTvT.getUtocnost());
            dotaz.setInt(6, zbranTvT.getObrana());
            dotaz.setString(7, zbranTvT.getDelka());
            dotaz.setInt(8, zbranTvT.getVaha());
            dotaz.setInt(9, zbranTvT.getZlataky());
            dotaz.setInt(10, zbranTvT.getStribrnaky());
            dotaz.setInt(11, zbranTvT.getMedaky());
            dotaz.setString(12, zbranTvT.getPopis());
            dotaz.executeUpdate();
            return true;
        } catch (SQLException ex) {
        System.err.println(CHYBA + ex);
        return false;
        }
    }

    /**
     * Vloží novou střelnou nebo vrhací zbraň do databáze drddesk_db.
     *
     * @param zbranSaV
     * @return boolean
     */
    public boolean vlozZbranSAV(ZbranSAV zbranSaV) {
        try {
            db = DriverManager.getConnection(URL, USER, HESLO);
            String sql = "INSERT INTO zbran_sav (nazev, druh, sila, utocnost," +
                " dostrel, vaha, cena, poznamka)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement dotaz = db.prepareStatement(sql);
            dotaz.setString(1, zbranSaV.getNazev());
            dotaz.setString(2, zbranSaV.getDruh());
            dotaz.setInt(3, zbranSaV.getSila());
            dotaz.setInt(4, zbranSaV.getUtocnost());
            dotaz.setString(5, zbranSaV.getDostrel());
            dotaz.setInt(6, zbranSaV.getVaha());
            dotaz.setInt(7, zbranSaV.getZlataky());
            dotaz.setInt(8, zbranSaV.getStribrnaky());
            dotaz.setInt(9, zbranSaV.getMedaky());
            dotaz.setString(10, zbranSaV.getPopis());
            dotaz.executeUpdate();
            return true;
        } catch (SQLException ex) {
        System.err.println(CHYBA + ex);
        return false;
        }
    }

    /**
     * Vloží novou výbavu do databáze drddesk_db.
     *
     * @param vybava
     * @return boolean
     */
    public boolean vlozVybavu(Vybava vybava) {
        try {
            db = DriverManager.getConnection(URL, USER, HESLO);
            String sql = "INSERT INTO vybava (nazev, druh, vaha, cena," +
                    " poznamka) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement dotaz = db.prepareStatement(sql);
            dotaz.setString(1, vybava.getNazev());
            dotaz.setString(2, vybava.getDruh());
            dotaz.setInt(3, vybava.getVaha());
            dotaz.setInt(4, vybava.getZlataky());
            dotaz.setInt(5, vybava.getStribrnaky());
            dotaz.setInt(6, vybava.getMedaky());
            dotaz.setString(7, vybava.getPopis());
            dotaz.executeUpdate();
            return true;
        } catch (SQLException ex) {
        System.err.println(CHYBA + ex);
        return false;
        }
    }


    public boolean vlozZbroj(Zbroj zbroj) {

        try {
            db = DriverManager.getConnection(URL, USER, HESLO);
            String sql = "INSERT INTO zbroj (nazev, druh, kvalita, vaha_a," +
                    " vaha_b, vaha_c, cena_a, cena_b, cena_c, poznamka)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement dotaz = db.prepareStatement(sql);
            dotaz.setString(1, zbroj.getNazev());
            dotaz.setString(2, zbroj.getDruh());
            dotaz.setInt(3, zbroj.getKvalita());
            dotaz.setInt(4, zbroj.getVahaA());
            dotaz.setInt(5, zbroj.getVahaB());
            dotaz.setInt(6, zbroj.getVahaC());
            dotaz.setInt(7, zbroj.getCenaA());
            dotaz.setInt(8, zbroj.getCenaB());
            dotaz.setInt(9, zbroj.getCenaC());
            dotaz.setString(10, zbroj.getPopis());
            dotaz.setInt(11, zbroj.getId());
            dotaz.executeUpdate();
            return true;
        } catch (SQLException ex) {
        System.err.println(CHYBA + ex);
        return false;
        }
    }

//********************************** UPDATE ************************************

    /**
     * Upraví stávající nestvůru do databáze drddesk_db.
     *
     * @param nestvura Nestvůra
     * @return boolean
     */
    public boolean zmenNestvura(Nestvura nestvura) {
        try {
            db = DriverManager.getConnection(URL, USER, HESLO);
            String sql = "UPDATE nestvura SET nazev=?, zivotaschopnost=?, utok=?," +
                    " obrana=?, sila=?, obratnost=?, odolnost=?, inteligence=?, charisma=?," +
                    " velikost=?, bojovnost=?, zranitelnost=?, skupiny_zranitelnost=?," +
                    " pohyblivost=?, skupiny_pohyblivost=?, vytrvalost=?, skupiny_vytrvalost=?," +
                    " manevr_schopnost=?, zakl_sila_mysli=?, ochoceni=?, presvedceni=?," +
                    " poklady=?, zkusenost=?, poznamka=? WHERE id=?";
            PreparedStatement dotaz = db.prepareStatement(sql);

            dotaz.setString(1, nestvura.getNazev());
            dotaz.setInt(2, nestvura.getZivotaschopnost());
            dotaz.setString(3, nestvura.getUtok());
            dotaz.setInt(4, nestvura.getObrana());
            dotaz.setInt(5, nestvura.getSila());
            dotaz.setInt(6, nestvura.getObratnost());
            dotaz.setInt(7, nestvura.getOdolnost());
            dotaz.setInt(8, nestvura.getInteligence());
            dotaz.setInt(9, nestvura.getCharisma());
            dotaz.setString(10, nestvura.getVelikost());
            dotaz.setInt(11, nestvura.getBojovnost());
            dotaz.setString(12, nestvura.getZranitelnost());
            dotaz.setString(13, nestvura.getSkupinaZranitelnost());
            dotaz.setInt(14, nestvura.getPohyblivost().getHodnota());
            dotaz.setString(15, nestvura.getSkupinaPohyblivost());
            dotaz.setInt(16, nestvura.getVytrvalost().getHodnota());
            dotaz.setString(17, nestvura.getSkupinaVytrvalost());
            dotaz.setInt(18, nestvura.getManevrSchopnost());
            dotaz.setInt(19, nestvura.getZaklSilaMysli());
            dotaz.setInt(20, nestvura.getOchoceni());
            dotaz.setString(21, nestvura.getPresvedceni());
            dotaz.setString(22, nestvura.getPoklady());
            dotaz.setInt(23, nestvura.getZkusenost());
            dotaz.setString(24, nestvura.getPoznamka());
            dotaz.setInt(25, nestvura.getId());
            dotaz.executeUpdate();
            return true;
        } catch (SQLException ex) {
        System.err.println(CHYBA + ex);
        return false;
        }
    }

    /**
     * Upraví stávající zbraň tváří v tvář v databázi drddesk_db.
     *
     * @param zbranTVT ZbranTVT
     * @return boolean
     */
    public boolean zmenZbranTVT(ZbranTVT zbranTVT) {

        try {
            db = DriverManager.getConnection(URL, USER, HESLO);
            String sql = "UPDATE zbran_tvt SET nazev=?, druh=?, drzeni=?," +
                     " sila=?, utocnost=?, obrana=?, delka=?, vaha=?, " +
                     "zlataky=?, stribrnaky=?, medaky=?, poznamka=? WHERE id=?";
            PreparedStatement dotaz = db.prepareStatement(sql);
            dotaz.setString(1, zbranTVT.getNazev());
            dotaz.setString(2, zbranTVT.getDrzeni());
            dotaz.setString(3, zbranTVT.getDruh());
            dotaz.setInt(4, zbranTVT.getSila());
            dotaz.setInt(5, zbranTVT.getUtocnost());
            dotaz.setInt(6, zbranTVT.getObrana());
            dotaz.setString(7, zbranTVT.getDelka());
            dotaz.setInt(8, zbranTVT.getVaha());
            dotaz.setInt(9, zbranTVT.getZlataky());
            dotaz.setInt(10, zbranTVT.getStribrnaky());
            dotaz.setInt(11, zbranTVT.getMedaky());
            dotaz.setString(12, zbranTVT.getPopis());
            dotaz.setInt(13, zbranTVT.getId());
            dotaz.executeUpdate();
            return true;
        } catch (SQLException ex) {
        System.err.println(CHYBA + ex);
        return false;
        }
    }

    /**
     * Upraví stávající výbavu v databázi drddesk_db.
     *
     * @param vybava Vybava
     * @return boolean
     */
    public boolean zmenVybava(Vybava vybava) {

        try {
            db = DriverManager.getConnection(URL, USER, HESLO);
            String sql = "UPDATE vybava SET nazev=?, druh=?, vaha=?, zlataky=?," +
                            " stribrnaky=?, medaky=?, poznamka=? WHERE id=?";
            PreparedStatement dotaz = db.prepareStatement(sql);
            dotaz.setString(1, vybava.getNazev());
            dotaz.setString(2, vybava.getDruh());
            dotaz.setInt(3, vybava.getVaha());
            dotaz.setInt(4, vybava.getZlataky());
            dotaz.setInt(5, vybava.getStribrnaky());
            dotaz.setInt(6, vybava.getMedaky());
            dotaz.setString(7, vybava.getPopis());
            dotaz.setInt(9, vybava.getId());
            dotaz.executeUpdate();
            return true;
        } catch (SQLException ex) {
        System.err.println(CHYBA + ex);
        return false;
        }
    }

    /**
     * Upraví stávající zbroj v databázi drddesk_db.
     *
     * @param zbroj Zbroj
     * @return boolean
     */
    public boolean zmenZbroj(Zbroj zbroj) {

        try {
            db = DriverManager.getConnection(URL, USER, HESLO);
            String sql = "UPDATE zbroj SET nazev=?, druh=?, kvalita=?, vaha_a=?," +
                            " vaha_b=?, vaha_c=?, cena_a=?, cena_b=?, cena_c=?," +
                            " poznamka=? WHERE id=?";
            PreparedStatement dotaz = db.prepareStatement(sql);
            dotaz.setString(1, zbroj.getNazev());
            dotaz.setString(2, zbroj.getDruh());
            dotaz.setInt(3, zbroj.getKvalita());
            dotaz.setInt(4, zbroj.getVahaA());
            dotaz.setInt(5, zbroj.getVahaB());
            dotaz.setInt(6, zbroj.getVahaC());
            dotaz.setInt(7, zbroj.getCenaA());
            dotaz.setInt(8, zbroj.getCenaB());
            dotaz.setInt(9, zbroj.getCenaC());
            dotaz.setString(10, zbroj.getPopis());
            dotaz.setInt(11, zbroj.getId());
            dotaz.executeUpdate();
            return true;
        } catch (SQLException ex) {
        System.err.println(CHYBA + ex);
        return false;
        }
    }

    /**
     * Upraví stávající zbroj v databázi drddesk_db.
     *
     * @param zbranSAV ZbranSAV
     * @return boolean
     */
    public boolean zmenZbranSAV(ZbranSAV zbranSAV) {

        try {
            db = DriverManager.getConnection(URL, USER, HESLO);
            String sql = "UPDATE zbran_sav SET nazev=?, druh=?, typ=?, sila=?," +
                    " utocnost=?, maly_dostrel=?, stredni_dostrel=?, velky_dostrel=?," +
                    " vaha=?, zlataky=?, stribrnaky=?, medaky=?, poznamka=? WHERE id=?";
            PreparedStatement dotaz = db.prepareStatement(sql);
            dotaz.setString(1, zbranSAV.getNazev());
            dotaz.setString(2, zbranSAV.getDruh());
            dotaz.setString(3, zbranSAV.getTyp());
            dotaz.setInt(4, zbranSAV.getSila());
            dotaz.setInt(5, zbranSAV.getUtocnost());
            dotaz.setInt(6, zbranSAV.getMalyDostrel());
            dotaz.setInt(7, zbranSAV.getStredniDostrel());
            dotaz.setInt(8, zbranSAV.getVelkyDostrel());
            dotaz.setInt(9, zbranSAV.getVaha());
            dotaz.setInt(10, zbranSAV.getZlataky());
            dotaz.setInt(11, zbranSAV.getStribrnaky());
            dotaz.setInt(12, zbranSAV.getMedaky());
            dotaz.setString(13, zbranSAV.getPopis());
            dotaz.setInt(14, zbranSAV.getId());
            dotaz.executeUpdate();
            return true;
        } catch (SQLException ex) {
        System.err.println(CHYBA + ex);
        return false;
        }
    }

//********************************** DELETE ************************************

    /**
     * Smaže položku z databáze drddesk_db odpovídající Odkazu.
     *
     * @param odkaz
     * @return boolean
     */
    public boolean smazPolozkuDleOdkazu(Odkaz odkaz) {
        String tabulka = odkaz.getTabulka();
        if (isTabOk(tabulka)) {
            try {
                db = DriverManager.getConnection(URL, USER, HESLO);
                String sql = "DELETE FROM " + tabulka + " WHERE id=?";
                PreparedStatement dotaz = db.prepareStatement(sql);
                dotaz.setInt(1, odkaz.getId());
                dotaz.executeUpdate();
                return true;
            } catch (SQLException ex) {
            System.err.println(CHYBA + ex);
            return false;
            }
        } else {
        System.err.println("Chybný název tabulky v parametru tabulka:" +
            " SetData.smazPolozkuDleOdkazu(String tabulka)");
        return false;
        }
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}

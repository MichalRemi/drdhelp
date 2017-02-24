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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;


/*******************************************************************************
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2016-10-04
 */
public class DataIn extends Data {

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
    public DataIn() {
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
        String sql = "INSERT INTO nestvura (nazev, zivotaschopnost, konstanta_zvt," +
                " utok, obrana, sila, obratnost, odolnost, inteligence, charisma," +
                " velikost, bojovnost, zranitelnost, skupiny_zranitelnost," +
                " pohyblivost, skupiny_pohyblivost, vytrvalost, skupiny_vytrvalost," +
                " manevr_schopnost, zakl_sila_mysli, ochoceni, presvedceni," +
                " poklady, zkusenost, poznamka) VALUES (?, ?, ?, ?, ?, ?, ?," +
                " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql); )
        {
            dotaz.setString(1, nestvura.getNazev());
            dotaz.setInt(2, nestvura.getZivotaschopnost());
            vlozIntNeboNull(dotaz, 3,nestvura.getKonstantaZvt());
            dotaz.setString(4, nestvura.getUtok());
            dotaz.setInt(5, nestvura.getObrana());
            vlozIntNeboNull(dotaz, 6,
                    nestvura.getVlastnosti().getVlastnost(0).getHodnota());
            vlozIntNeboNull(dotaz, 7,
                    nestvura.getVlastnosti().getVlastnost(1).getHodnota());
            vlozIntNeboNull(dotaz, 8,
                    nestvura.getVlastnosti().getVlastnost(2).getHodnota());
            vlozIntNeboNull(dotaz, 9,
                    nestvura.getVlastnosti().getVlastnost(3).getHodnota());
            vlozIntNeboNull(dotaz, 10,
                    nestvura.getVlastnosti().getVlastnost(4).getHodnota());
            dotaz.setString(11, nestvura.getVelikost());
            vlozIntNeboNull(dotaz, 12, nestvura.getBojovnost());
            dotaz.setString(13, nestvura.getZranitelnost());
            dotaz.setString(14, nestvura.getSkupinaZranitelnost());
            dotaz.setInt(15, nestvura.getPohyblivost().getHodnota());
            dotaz.setString(16, nestvura.getSkupinaPohyblivost());
            dotaz.setInt(17, nestvura.getVytrvalost().getHodnota());
            dotaz.setString(18, nestvura.getSkupinaVytrvalost());
            vlozIntNeboNull(dotaz, 19, nestvura.getManevrSchopnost());
            vlozIntNeboNull(dotaz, 20, nestvura.getZaklSilaMysli());
            vlozIntNeboNull(dotaz, 21, nestvura.getOchoceni());
            dotaz.setString(22, nestvura.getPresvedceni());
            dotaz.setString(23, nestvura.getPoklady());
            dotaz.setInt(24, nestvura.getZkusenost());
            dotaz.setString(25, nestvura.getPoznamka());

            dotaz.executeUpdate();
            return true;
        } catch (SQLException | NullPointerException ex) {
        System.err.println("DataIn.vlozNestvura: " + CHYBA + ex);
        ex.printStackTrace();
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
        String sql = "INSERT INTO zbran_tvt (nazev, druh, drzeni, sila," +
            " utocnost, obrana, delka, vaha, zlataky, stribrnaky, medaky," +
                    " poznamka) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try ( Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql); )
        {
            dotaz.setString(1, zbranTvT.getNazev());
            dotaz.setString(2, zbranTvT.getDruh());
            dotaz.setString(3, zbranTvT.getDrzeni());
            dotaz.setInt(4, zbranTvT.getSila());
            dotaz.setInt(5, zbranTvT.getUtocnost());
            dotaz.setInt(6, zbranTvT.getObrana());
            dotaz.setString(7, zbranTvT.getDelka());
            dotaz.setInt(8, zbranTvT.getVaha());
            vlozIntNeboNull(dotaz, 9, zbranTvT.getZlataky());
            vlozIntNeboNull(dotaz, 10, zbranTvT.getStribrnaky());
            vlozIntNeboNull(dotaz, 11, zbranTvT.getMedaky());
            dotaz.setString(12, zbranTvT.getPopis());

            dotaz.executeUpdate();
            return true;
        } catch (SQLException | NullPointerException ex) {
        System.err.println("DataIn.vlozZbranTVT: " + CHYBA + ex);
        ex.printStackTrace();
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
        String sql = "INSERT INTO zbran_sav (nazev, druh, sila, utocnost," +
                " dostrel, vaha, cena, poznamka)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql); )
        {
            dotaz.setString(1, zbranSaV.getNazev());
            dotaz.setString(2, zbranSaV.getDruh());
            dotaz.setInt(3, zbranSaV.getSila());
            dotaz.setInt(4, zbranSaV.getUtocnost());
            dotaz.setString(5, zbranSaV.getDostrel());
            dotaz.setInt(6, zbranSaV.getVaha());
            vlozIntNeboNull(dotaz, 7, zbranSaV.getZlataky());
            vlozIntNeboNull(dotaz, 8, zbranSaV.getStribrnaky());
            vlozIntNeboNull(dotaz, 9, zbranSaV.getMedaky());
            dotaz.setString(10, zbranSaV.getPopis());

            dotaz.executeUpdate();
            return true;
        } catch (SQLException | NullPointerException ex) {
        System.err.println("DataIn.vlozZbranSAV(): " + CHYBA + ex);
        ex.printStackTrace();
        return false;
        }
    }

    /**
     * Vloží novou výbavu do databáze drddesk_db.
     *
     * @param vybava
     * @return boolean
     */
    public boolean vlozVybava(Vybava vybava) {
        String sql = "INSERT INTO vybava (nazev, druh, vaha, cena," +
                    " poznamka) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql); )
        {
            dotaz.setString(1, vybava.getNazev());
            dotaz.setString(2, vybava.getDruh());
            dotaz.setInt(3, vybava.getVaha());
            vlozIntNeboNull(dotaz, 4, vybava.getZlataky());
            vlozIntNeboNull(dotaz, 5, vybava.getStribrnaky());
            vlozIntNeboNull(dotaz, 6, vybava.getMedaky());
            dotaz.setString(7, vybava.getPopis());

            dotaz.executeUpdate();
            return true;
        } catch (SQLException | NullPointerException ex) {
        System.err.println("DataIn.vlozVybavu: " + CHYBA + ex);
        ex.printStackTrace();
        return false;
        }
    }

    public boolean vlozZbroj(Zbroj zbroj) {
        String sql = "INSERT INTO zbroj (nazev, druh, kvalita, vaha_a," +
                    " vaha_b, vaha_c, cena_a, cena_b, cena_c, poznamka)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try ( Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql); )
        {
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
        } catch (SQLException | NullPointerException ex) {
        System.err.println("DataIn.vlozZbroj: " + CHYBA + ex);
        ex.printStackTrace();
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
        String sql = "UPDATE nestvura SET nazev=?, zivotaschopnost=?," +
                    " konstanta_zvt=?, utok=?, obrana=?, sila=?, obratnost=?," +
                    " odolnost=?, inteligence=?, charisma=?, velikost=?, bojovnost=?," +
                    " zranitelnost=?, skupiny_zranitelnost=?, pohyblivost=?," +
                    " skupiny_pohyblivost=?, vytrvalost=?, skupiny_vytrvalost=?," +
                    " manevr_schopnost=?, zakl_sila_mysli=?, ochoceni=?," +
                    " presvedceni=?, poklady=?, zkusenost=?, poznamka=? WHERE id=?";
        try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql); )
        {
            dotaz.setString(1, nestvura.getNazev());
            dotaz.setInt(2, nestvura.getZivotaschopnost());
            vlozIntNeboNull(dotaz, 3, nestvura.getKonstantaZvt());
            dotaz.setString(4, nestvura.getUtok());
            dotaz.setInt(5, nestvura.getObrana());
            vlozIntNeboNull(dotaz, 6, nestvura.getSila());
            vlozIntNeboNull(dotaz, 7, nestvura.getObratnost());
            vlozIntNeboNull(dotaz, 8, nestvura.getOdolnost());
            vlozIntNeboNull(dotaz, 9, nestvura.getInteligence());
            vlozIntNeboNull(dotaz, 10, nestvura.getCharisma());
            dotaz.setString(11, nestvura.getVelikost());
            vlozIntNeboNull(dotaz, 12, nestvura.getBojovnost());
            dotaz.setString(13, nestvura.getZranitelnost());
            dotaz.setString(14, nestvura.getSkupinaZranitelnost());
            dotaz.setInt(15, nestvura.getPohyblivost().getHodnota());
            dotaz.setString(16, nestvura.getSkupinaPohyblivost());
            dotaz.setInt(17, nestvura.getVytrvalost().getHodnota());
            dotaz.setString(18, nestvura.getSkupinaVytrvalost());
            vlozIntNeboNull(dotaz, 19, nestvura.getManevrSchopnost());
            vlozIntNeboNull(dotaz, 20, nestvura.getZaklSilaMysli());
            vlozIntNeboNull(dotaz, 21, nestvura.getOchoceni());
            dotaz.setString(22, nestvura.getPresvedceni());
            dotaz.setString(23, nestvura.getPoklady());
            dotaz.setInt(24, nestvura.getZkusenost());
            dotaz.setString(25, nestvura.getPoznamka());
            dotaz.setInt(26, nestvura.getId());

            dotaz.executeUpdate();
            return true;
        } catch (SQLException | NullPointerException ex) {
        System.err.println("DataIn.zmenNestvura: " + CHYBA);
        ex.printStackTrace();
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
        String sql = "UPDATE zbran_tvt SET nazev=?, druh=?, drzeni=?," +
                     " sila=?, utocnost=?, obrana=?, delka=?, vaha=?, " +
                     "zlataky=?, stribrnaky=?, medaky=?, poznamka=? WHERE id=?";
        try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql); )
        {
            dotaz.setString(1, zbranTVT.getNazev());
            dotaz.setString(2, zbranTVT.getDruh());
            dotaz.setString(3, zbranTVT.getDrzeni());
            dotaz.setInt(4, zbranTVT.getSila());
            dotaz.setInt(5, zbranTVT.getUtocnost());
            dotaz.setInt(6, zbranTVT.getObrana());
            dotaz.setString(7, zbranTVT.getDelka());
            dotaz.setInt(8, zbranTVT.getVaha());
            vlozIntNeboNull(dotaz, 9, zbranTVT.getZlataky());
            vlozIntNeboNull(dotaz, 10, zbranTVT.getStribrnaky());
            vlozIntNeboNull(dotaz, 11, zbranTVT.getMedaky());
            dotaz.setString(12, zbranTVT.getPopis());
            dotaz.setInt(13, zbranTVT.getId());

            dotaz.executeUpdate();
            return true;
        } catch (SQLException | NullPointerException ex) {
        System.err.println("DataIn.zmenZbranTVT(): " + CHYBA + ex);
        ex.printStackTrace();
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
        String sql = "UPDATE vybava SET nazev=?, druh=?, vaha=?, zlataky=?," +
                            " stribrnaky=?, medaky=?, poznamka=? WHERE id=?";
        try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql); )
        {
            dotaz.setString(1, vybava.getNazev());
            dotaz.setString(2, vybava.getDruh());
            vlozIntNeboNull(dotaz, 3, vybava.getZlataky());
            vlozIntNeboNull(dotaz, 4, vybava.getStribrnaky());
            vlozIntNeboNull(dotaz, 5, vybava.getMedaky());
            dotaz.setString(7, vybava.getPopis());
            dotaz.setInt(9, vybava.getId());
            dotaz.executeUpdate();
            return true;
        } catch (SQLException | NullPointerException ex) {
        System.err.println("DataIn.zmenVybava(): " + CHYBA);
        ex.printStackTrace();
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
        String sql = "UPDATE zbroj SET nazev=?, druh=?, kvalita=?, vaha_a=?," +
                            " vaha_b=?, vaha_c=?, cena_a=?, cena_b=?, cena_c=?," +
                            " poznamka=? WHERE id=?";
        try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql); )
        {
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
        } catch (SQLException | NullPointerException ex) {
        System.err.println("DataIn.zmenZbroj(): " + CHYBA + ex);
        ex.printStackTrace();
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
        String sql = "UPDATE zbran_sav SET nazev=?, druh=?, typ=?, sila=?," +
                    " utocnost=?, maly_dostrel=?, stredni_dostrel=?, velky_dostrel=?," +
                    " vaha=?, zlataky=?, stribrnaky=?, medaky=?, poznamka=? WHERE id=?";
        try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql); )
        {
            dotaz.setString(1, zbranSAV.getNazev());
            dotaz.setString(2, zbranSAV.getDruh());
            dotaz.setString(3, zbranSAV.getTyp());
            dotaz.setInt(4, zbranSAV.getSila());
            dotaz.setInt(5, zbranSAV.getUtocnost());
            dotaz.setInt(6, zbranSAV.getMalyDostrel());
            dotaz.setInt(7, zbranSAV.getStredniDostrel());
            dotaz.setInt(8, zbranSAV.getVelkyDostrel());
            dotaz.setInt(9, zbranSAV.getVaha());
            vlozIntNeboNull(dotaz, 10, zbranSAV.getZlataky());
            vlozIntNeboNull(dotaz, 11, zbranSAV.getStribrnaky());
            vlozIntNeboNull(dotaz, 12, zbranSAV.getMedaky());
            dotaz.setInt(11, zbranSAV.getStribrnaky());
            dotaz.setInt(12, zbranSAV.getMedaky());
            dotaz.setString(13, zbranSAV.getPopis());
            dotaz.setInt(14, zbranSAV.getId());
            dotaz.executeUpdate();
            return true;
        } catch (SQLException | NullPointerException ex) {
        System.err.println("DataIn.zmenZbranSAV(): " + CHYBA + ex);
        ex.printStackTrace();
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
            String sql = "DELETE FROM " + tabulka + " WHERE id=?";
            try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
                PreparedStatement dotaz = db.prepareStatement(sql); )
            {
                dotaz.setInt(1, odkaz.getId());

                dotaz.executeUpdate();
                return true;
            } catch (SQLException ex) {
            System.err.println("DataIn.smazPolozkuDleOdkazu(): " + CHYBA + ex);
            ex.printStackTrace();
            return false;
            }
        } else {
        System.err.println("Chybný název tabulky v parametru tabulka:" +
            " DataIn.smazPolozkuDleOdkazu(String tabulka)");
        return false;
        }
    }



//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

    /**
     * Otestuje hodnotu Integer. Pokud není null, vloží do sql dotazu hodnotu int,
     * pokud je vloží null.
     */
    private void vlozIntNeboNull(PreparedStatement dotaz, int index, Integer hodnota) throws SQLException {
        if (hodnota != null || hodnota != 0) dotaz.setInt(index, hodnota);
        else dotaz.setNull(index, Types.INTEGER);
    }

//##############################################################################
//== NESTED DATA TYPES =========================================================
}

/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model.logika;

import drdhelp.model.io.GetData;
import drdhelp.model.IPopis;
import drdhelp.model.Nestvura;
import drdhelp.model.Odkaz;
import drdhelp.model.Postava;
import drdhelp.model.SeznamOdkazu;
import drdhelp.model.TabulkaDB;
import drdhelp.model.Vybava;
import drdhelp.model.ZbranSAV;
import drdhelp.model.ZbranTVT;
import drdhelp.model.Zbroj;



/*******************************************************************************
 * Instance třídy {@code HlavniLogika} představují logiku formuláře Hlanvi.fxml.
 *
 * @author  Michal Remišovský
 * @version 0.03.0000 — 2016-12-02
 */
public class MainLogika {

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

    GetData getData = new GetData();
    SeznamOdkazu seznamOdkazu = new SeznamOdkazu();


//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     *
     */
    public MainLogika() {

    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /**
     * Načte příslušný objekt z databáze podle odkazu a vrátí objekt typu
     * rozhraní IPopis. To slouží k implementaci podrobného popisu daných objektů.
     * @param odkaz Odkaz
     * @return IPopis
     */
    public IPopis ziskejOdkaz(Odkaz odkaz) {

        String tabulka = odkaz.getTabulka();
        int id = odkaz.getId();

        if (tabulka.equals(TabulkaDB.POSTAVA.getTabNazev())) {
            Postava postava = getData.getPostava(id);
            return postava;
        }
        if (tabulka.equals(TabulkaDB.NESTVURA.getTabNazev())) {
            Nestvura nestvura = getData.getNestvura(id);
            return nestvura;
        }
        if (tabulka.equals(TabulkaDB.ZBRAN_TVT.getTabNazev())) {
            ZbranTVT zbran = getData.getZbranTVT(id);
            return zbran;
        }
        if (tabulka.equals(TabulkaDB.ZBRAN_SAV.getTabNazev())) {
            ZbranSAV zbran = getData.getZbranSAV(id);
            return zbran;
        }
        if (tabulka.equals(TabulkaDB.ZBROJ.getTabNazev())) {
            Zbroj zbroj = getData.getZbroj(id);
            return zbroj;
        }
        if (tabulka.equals(TabulkaDB.VYBAVA.getTabNazev())) {
            Vybava vybava = getData.getVybava(id);
            return vybava;
        }
        return null;
    }

    /**
     * Vrátí příslušný název souboru fxml pro otevření stage odpovídající položce
     * předaného Odkazu
     * @param tabulka tabulka z databáze drddesk_db
     * @return String název příslušného souboru fxml
     */
    public String getNazevSouboruFxmlPodleOdkazu(String tabulka) {

        if (tabulka.equals(TabulkaDB.POSTAVA.getTabNazev())) {

            if (jeNovaPostava()) {
            return "Postava.fxml";
            }

            if (SeznamOdkazu.getAktualniOdkaz() != null) {
                return "Postava.fxml";
            } else return "NovaPostava.fxml";
        }

        if (tabulka.equals(TabulkaDB.NESTVURA.getTabNazev())) {
            return "Nestvura.fxml";
        }

        if (tabulka.equals(TabulkaDB.ZBRAN_TVT.getTabNazev())) {
            return "ZbranTVT.fxml";
        }

        if (tabulka.equals(TabulkaDB.ZBRAN_SAV.getTabNazev())) {
            return "ZbranSAV.fxml";
        }

        if (tabulka.equals(TabulkaDB.ZBROJ.getTabNazev())) {
            return "Zbroj.fxml";
        }

        if (tabulka.equals(TabulkaDB.VYBAVA.getTabNazev())) {
            return "Vybava.fxml";
        }

        System.err.println("MainLogika.getNazevSouboruFxmlPodleOdkazu:" +
                " Chybí implementace pro tuto tabulku");
        return null;
    }

    /** Ověří, zda se jedná o přidání nové postavy */
    public boolean jeNovaPostava() {
        return PostavaLogika.getNovaPostava() != null;
    }

    /** Vrátí název objektu z emun TabulkaDB odpovídající předané tabulce
     * @param tabulka Tabulka z emun TabulkaDB odpovídající databázi drddesk_db
     * @return String Název objektu
     */
    public String getNazevZTabulkaDB(String tabulka) {
        for (TabulkaDB t : TabulkaDB.values()) {
        if (t.getTabNazev().equals(tabulka)) return t.getNazev();
        }

        System.err.println("MainLogika.getNazevZTabulkaDB: Chybný název tabulky");
        return null;
    }

    /** Vrátí název objektu z emun TabulkaDB odpovídající předané tabulce
     * @param tabulka Tabulka z emun TabulkaDB odpovídající databázi drddesk_db
     * @return String Název objektu
     */
    public String getTabulkaZTabulkaDB(String tabulka) {
        for (TabulkaDB t : TabulkaDB.values()) {
        if (t.getTabNazev().equals(tabulka)) return t.getNazev();
        }

        System.err.println("MainLogika.getTabulkaZTabulkaDB: Chybný název tabulky");
        return null;
    }

    /** získá podrobný popis upravovane položky */
    public String ziskejPodrobnyPopis() {
        Odkaz odkaz = SeznamOdkazu.getAktualniOdkaz();
        if (odkaz != null) return ziskejOdkaz(odkaz).getPodrobnyPopis();
        else {
            System.err.println("MainLogika.ziskejPodrobnyPopis: Chyba, odkaz == null");
            return "";
        }
    }


//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}

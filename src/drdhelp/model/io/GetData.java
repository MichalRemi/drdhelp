/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model.io;

import drdhelp.model.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/*******************************************************************************
 * Instance třídy {@code GetData} načítají data z databáze drddesk_db.
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2016-09-18
 */
public class GetData extends Data {

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
    public GetData() {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /**
     * Načte naposledy otevřenou postavu z databáze drddesk_db ve tvaru n,jmeno,
     * kde n je jedinečné id Postavy z databáze drddesk_db.
     *
     * @return String
     */
    public String getIdPosledniPostavy() {
        try {
            db = DriverManager.getConnection(URL, USER, HESLO);
            String sql = "SELECT naposledy_otevrene FROM uzivatel";
            PreparedStatement dotaz = db.prepareStatement(sql);
            ResultSet data = dotaz.executeQuery();
            data.next();
            return data.getString("naposledy_otevrene");
        } catch (SQLException ex) {
         System.err.println(CHYBA + ex);
         return null;
        }
    }


    /**
     * Vrátí všechny id a názvy z tabulky zadané v parametru z databáze
     * drddesk_db ve formátu id,název. Seznam platných tabulek je v TabulkaDB.
     *
     * @param tabulka String
     * @return ArrayList String
     */
    public ArrayList<Odkaz> nactiOdkazy(String tabulka) {
        if (isTabOk(tabulka)) {
            try {
                db = DriverManager.getConnection(URL, USER, HESLO);
                String sql = "SELECT * FROM " + tabulka;
                PreparedStatement dotaz = db.prepareStatement(sql);
                ResultSet data = dotaz.executeQuery();
                ArrayList<Odkaz> vystup = new ArrayList<>();
                while (data.next()) {
                    Odkaz nazezv = new Odkaz(data.getInt("id"),
                                            data.getString("nazev"), tabulka);
                    vystup.add(nazezv);
                }
                return vystup;
            } catch (SQLException ex) {
            System.err.println(CHYBA + ex);
            return null;
            }
        } else {
            System.err.println("GetData.nactiOdkazy(): Chybný název tabulky" +
                    " v parametru tabulka!");
            return null;
        }
    }

    /**
     * Vrátí všechny názvy ze zadaného ArrayListu String, který je výstupem
     * metody getIdANazvy()
     *
     * @param seznamIdANazev ArrayList String
     * @return ArrayList String
     */
    private ArrayList<String> getNazvyString(ArrayList<String> seznamIdANazev) {
        ArrayList<String> nazvy = new ArrayList<>();
        for (String s : seznamIdANazev) {
            String[] idANazev = s.split(",");
            nazvy.add(idANazev[1]);
        }
        return nazvy;
    }

    /**
     * Načte všechna jména postav a příslušná id z databáze drddesk_db.
     *
     * @return Seznam id a jmen všech postav z databáze. V záznamu je první id
     * a od jména oddělené "," např.: "1,Killien"
     */
    public ArrayList<String> getNazevAIdPostav() {
        try {
            db = DriverManager.getConnection(URL, USER, HESLO);
            String sql = "SELECT * FROM postava";
            PreparedStatement dotaz = db.prepareStatement(sql);
            try (ResultSet data = dotaz.executeQuery()) {
                ArrayList<String> postava = new ArrayList<>();
                while (data.next()) {
                    String id = String.valueOf(data.getInt("id"));
                    String jmeno = data.getString("nazev");
                    postava.add(id + "," + jmeno);
                }
            return postava;
            }
        } catch (SQLException ex) {
         System.err.println(CHYBA + ex);
         return null;
        }
    }

    /**
     * Načte vlastnosti instance Rasa z databáze drddesk_db dle názvu rasy
     * a vrátí instanci Rasa.
     *
     * @param id Id v databazi drddesk_db.
     * @return Instance třídy Rasa.
     */
    public Rasa getRasa(int id) {
        try {
            db = DriverManager.getConnection(URL, USER, HESLO);
            String sql = "SELECT * FROM rasa WHERE id=?";
            PreparedStatement dotaz = db.prepareStatement(sql);
            dotaz.setInt(1, id);
            try (ResultSet vysledky = dotaz.executeQuery()) {
                vysledky.next();

                int[][] vlastnosti = {{vysledky.getInt("sila_min"),
                                       vysledky.getInt("obratnost_min"),
                                       vysledky.getInt("odolnost_min"),
                                       vysledky.getInt("inteligence_min"),
                                       vysledky.getInt("charisma_min")},
                                      {vysledky.getInt("sila_max"),
                                       vysledky.getInt("obratnost_max"),
                                       vysledky.getInt("odolnost_max"),
                                       vysledky.getInt("inteligence_max"),
                                       vysledky.getInt("charisma_max")}};

                int[] opravy = {vysledky.getInt("oprava_sila"),
                                vysledky.getInt("oprava_obratnost"),
                                vysledky.getInt("oprava_odolnost"),
                                vysledky.getInt("oprava_inteligence"),
                                vysledky.getInt("oprava_charisma")};

                int[] vyska = {vysledky.getInt("vyska_min"),
                               vysledky.getInt("vyska_max")};

                int[] vaha = {vysledky.getInt("vaha_min"),
                              vysledky.getInt("vaha_max")};

                Rasa rasaPomocna = new Rasa(
                        vysledky.getString("nazev"),
                        vlastnosti, opravy, vyska, vaha,
                        vysledky.getInt("pohyblivost"),
                        vysledky.getString("zvlastni_schopnosti"),
                        vysledky.getString("rodova_zbran"),
                        vysledky.getString("velikost"),
                        vysledky.getString("popis"));

                return rasaPomocna;
            }
        } catch (SQLException ex) {
        System.err.println(CHYBA + ex);
        return null;
        }
    }

    /**
     * Načte vlastnosti instance Povolání z databáze drddesk_db dle názvu
     * povolání a vrátí instanci Rasa.
     *
     * @param id Id v databazi drddesk_db
     * @return Instance třídy Povolani.
     */
    public Povolani getPovolani(int id) {
        try {
            db = DriverManager.getConnection(URL, USER, HESLO);
            String sql = "SELECT * FROM povolani WHERE id=?";
            PreparedStatement dotaz = db.prepareStatement(sql);
            dotaz.setInt(1, id);
            try (ResultSet vysledky = dotaz.executeQuery()) {
                vysledky.next();

                int[][] vlastnosti = {{vysledky.getInt("sila_min"),
                                       vysledky.getInt("obratnost_min"),
                                       vysledky.getInt("odolnost_min"),
                                       vysledky.getInt("inteligence_min"),
                                       vysledky.getInt("charisma_min")},
                                      {vysledky.getInt("sila_max"),
                                       vysledky.getInt("obratnost_max"),
                                       vysledky.getInt("odolnost_max"),
                                       vysledky.getInt("inteligence_max"),
                                       vysledky.getInt("charisma_max")}};

                Povolani povolaniPomocne = new Povolani(
                        vysledky.getString("nazev"),
                        vlastnosti,
                        vysledky.getInt("zivoty"),
                        vysledky.getString("zvlastni_schopnosti"),
                        vysledky.getString("popis"));

                return povolaniPomocne;
            }
        } catch (SQLException ex) {
        System.err.println(CHYBA + ex);
        return null;
        }
    }

    /**
     * Načte všechny údaje o postavě do instance Postava z databáze drddesk_db
     * dle jména postavy.
     *
     * @param id Primary key - identifikační číslo postavy v databázi.
     * @return Instance třídy Postava.
     */
    public Postava getPostava(int id) {
        try {
            db = DriverManager.getConnection(URL, USER, HESLO);
            String sql = "SELECT * FROM postava WHERE id=?";
            PreparedStatement dotaz = db.prepareStatement(sql);
            dotaz.setInt(1, id);
            try (ResultSet vysledky = dotaz.executeQuery()) {
                vysledky.next();

                Integer[] hodnotyVlastnosti = {vysledky.getInt("sila"),
                                           vysledky.getInt("obratnost"),
                                           vysledky.getInt("odolnost"),
                                           vysledky.getInt("inteligence"),
                                           vysledky.getInt("charisma")};
                Vlastnost pohyblivost = new Vlastnost("Pohyblivost", vysledky.
                                                        getInt("pohyblivost"));

                Postava postavaPomocna = new Postava(
                    vysledky.getInt("id"),
                    vysledky.getString("nazev"),
                    vysledky.getString("rasa"),
                    vysledky.getString("povolani"),
                    vysledky.getInt("zivoty"),
                    vysledky.getInt("zivoty_max"),
                    vysledky.getInt("magy"),
                    vysledky.getInt("magy_max"),
                    vysledky.getInt("uroven"),
                    vysledky.getInt("zkusenosti"),
                    vysledky.getInt("zk_dalsi_uroven"),
                    hodnotyVlastnosti,
                    pohyblivost,
                    vysledky.getInt("vyska"),
                    vysledky.getInt("vaha"),
                    vysledky.getString("zbran_sav"),
                    vysledky.getString("zbran_tvt"),
                    vysledky.getString("zbroj"),
                    vysledky.getString("vybaveni"),
                    vysledky.getString("rodova_zbran"),
                    vysledky.getString("velikost"),
                    vysledky.getString("zvlastni_schopnosti"),
                    vysledky.getString("poznamka"));

                return postavaPomocna;
            }
        } catch (SQLException ex) {
        System.err.println(CHYBA + ex);
        return null;
        }
    }

    private Integer getInteger(ResultSet vysledky, String sloupecVDB) {
        try {
            int hodnotaInt = vysledky.getInt(sloupecVDB);
            if (hodnotaInt != 0) return hodnotaInt;
        } catch (SQLException ex) {
            System.err.println("GetData.getInteger(): " + CHYBA + ex);
        }
        return null;
    }

    /**
     * Načte všechny údaje o nestvůře do instance Nestvůra z databáze drddesk_db
     * dle id.
     *
     * @param id Primary key - identifikační číslo nestvůry v databázi
     * @return Instance třídy Nestvura
     */
    public Nestvura getNestvura(int id) {
        try {
            db = DriverManager.getConnection(URL, USER, HESLO);
            String sql = "SELECT * FROM nestvura WHERE id=?";
            PreparedStatement dotaz = db.prepareStatement(sql);
            dotaz.setInt(1, id);
            try (ResultSet vysledky = dotaz.executeQuery()) {
                vysledky.next();

                Integer[] hodnotyVlastnosti = {
                        getInteger(vysledky, "sila"),
                        getInteger(vysledky, "obratnost"),
                        getInteger(vysledky, "odolnost"),
                        getInteger(vysledky, "inteligence"),
                        getInteger(vysledky, "charisma")};

                Vlastnost pohyblivost = new Vlastnost(
                        "Pohyblivost", vysledky.getInt("pohyblivost"));

                Vlastnost vytrvalost = new Vlastnost(
                        "Vytrvalost", vysledky.getInt("vytrvalost"));

                Nestvura nestvuraPomocna = new Nestvura(
                        vysledky.getInt("id"),
                        vysledky.getString("nazev"),
                        vysledky.getInt("zivotaschopnost"),
                        getInteger(vysledky, "konstanta_zvt"),
                        vysledky.getString("utok"),
                        vysledky.getInt("obrana"),
                        hodnotyVlastnosti,
                        vysledky.getString("velikost"),
                        getInteger(vysledky, "bojovnost"),
                        vysledky.getString("zranitelnost"),
                        vysledky.getString("skupiny_zranitelnost"),
                        pohyblivost,
                        vysledky.getString("skupiny_pohyblivost"),
                        vytrvalost,
                        vysledky.getString("skupiny_vytrvalost"),
                        getInteger(vysledky, "manevr_schopnost"),
                        getInteger(vysledky, "zakl_sila_mysli"),
                        vysledky.getString("presvedceni"),
                        vysledky.getString("poklady"),
                        vysledky.getInt("zkusenost"),
                        getInteger(vysledky, "ochoceni"),
                        vysledky.getString("poznamka"));
                return nestvuraPomocna;
            }
        } catch (SQLException ex) {
        System.err.println(CHYBA + ex);
        return null;
        }
    }

    /**
     * Z databáze drddesk_db načte hodnotu zkušeností potřebnou na další úroveň
     * dle povolání a úrovně.
     *
     * @param povolani Název povolání.
     * @param uroven Úroveň postavy.
     * @return Zkušenosti potřebné na další úroveň.
     */
    public int getZkusenosti(String povolani, int uroven) {
        try {
            db = DriverManager.getConnection(URL, USER, HESLO);
            String sql = "SELECT * FROM zkusenosti WHERE uroven=?";
            PreparedStatement dotaz = db.prepareStatement(sql);
            dotaz.setInt(1, uroven);
            try (ResultSet vysledky = dotaz.executeQuery()) {
                vysledky.next();
                switch (povolani) {
                    case "válečník": return vysledky.getInt("valecnik");
                    case "hraničář": return vysledky.getInt("hranicar");
                    case "alchymista": return vysledky.getInt("alchymista");
                    case "kouzelník": return vysledky.getInt("kouzelnik");
                    case "zloděj": return vysledky.getInt("zlodej");
                    default: return -1;
                }
            }
        } catch (SQLException ex) {
        System.err.println(CHYBA + ex);
        return -1;
        }
    }

    /**
     * Z databáze drddesk_db načte údaje pro zbraň pro boj tváří v tvář.
     *
     * @param id
     * @return ZbranTVT
     */
    public ZbranTVT getZbranTVT(int id) {
        try {
            db = DriverManager.getConnection(URL, USER, HESLO);
            String sql = "SELECT * FROM zbran_tvt WHERE id=?";
            PreparedStatement dotaz = db.prepareStatement(sql);
            dotaz.setInt(1, id);
            try (ResultSet vysledky = dotaz.executeQuery()) {
                vysledky.next();
                ZbranTVT zbran = new ZbranTVT(id,
                        vysledky.getString("nazev"),
                        vysledky.getString("druh"),
                        vysledky.getString("drzeni"),
                        vysledky.getInt("sila"),
                        vysledky.getInt("utocnost"),
                        vysledky.getInt("obrana"),
                        vysledky.getString("delka"),
                        vysledky.getInt("vaha"),
                        vysledky.getInt("zlataky"),
                        vysledky.getInt("stribrnaky"),
                        vysledky.getInt("medaky"),
                        vysledky.getString("poznamka"));
                return zbran;
            }
        } catch (SQLException ex) {
        System.err.println(CHYBA + ex);
        return null;
        }
    }

    /**
     * Z databáze drddesk_db načte údaje pro zbraň pro boj tváří v tvář.
     *
     * @param id
     * @return ZbranTVT
     */
    public ZbranSAV getZbranSAV(int id) {
        try {
            db = DriverManager.getConnection(URL, USER, HESLO);
            String sql = "SELECT * FROM zbran_sav WHERE id=?";
            PreparedStatement dotaz = db.prepareStatement(sql);
            dotaz.setInt(1, id);
            try (ResultSet vysledky = dotaz.executeQuery()) {
                vysledky.next();
                ZbranSAV zbran = new ZbranSAV(id,
                        vysledky.getString("nazev"),
                        vysledky.getString("druh"),
                        vysledky.getString("typ"),
                        vysledky.getInt("sila"),
                        vysledky.getInt("utocnost"),
                        vysledky.getInt("maly_dostrel"),
                        vysledky.getInt("stredni_dostrel"),
                        vysledky.getInt("velky_dostrel"),
                        vysledky.getInt("vaha"),
                        vysledky.getInt("zlataky"),
                        vysledky.getInt("stribrnaky"),
                        vysledky.getInt("medaky"),
                        vysledky.getString("poznamka"));
                return zbran;
            }
        } catch (SQLException ex) {
        System.err.println(CHYBA + ex);
        return null;
        }
    }

    /**
     * Z databáze drddesk_db načte údaje pro výbavu.
     *
     * @param id
     * @return Vybava
     */
    public Vybava getVybava(int id) {
        try {
            db = DriverManager.getConnection(URL, USER, HESLO);
            String sql = "SELECT * FROM vybava WHERE id=?";
            PreparedStatement dotaz = db.prepareStatement(sql);
            dotaz.setInt(1, id);
            try (ResultSet vysledky = dotaz.executeQuery()) {
                vysledky.next();
                Vybava vybava = new Vybava(id,
                        vysledky.getString("nazev"),
                        vysledky.getString("druh"),
                        vysledky.getInt("vaha"),
                        vysledky.getInt("zlataky"),
                        vysledky.getInt("stribrnaky"),
                        vysledky.getInt("medaky"),
                        vysledky.getString("poznamka"));
                return vybava;
            }
        } catch (SQLException ex) {
        System.err.println(CHYBA + ex);
        return null;
        }
    }

    /**
     * Z databáze drddesk_db načte údaje pro zbroj
     *
     * @param id
     * @return Vybava
     */
    public Zbroj getZbroj(int id) {
        try {
            db = DriverManager.getConnection(URL, USER, HESLO);
            String sql = "SELECT * FROM zbroj WHERE id=?";
            PreparedStatement dotaz = db.prepareStatement(sql);
            dotaz.setInt(1, id);
            try (ResultSet vysledky = dotaz.executeQuery()) {
                vysledky.next();
                Zbroj zbroj = new Zbroj(id,
                        vysledky.getString("nazev"),
                        vysledky.getInt("kvalita"),
                        vysledky.getString("druh"),
                        vysledky.getInt("vaha_a"),
                        vysledky.getInt("vaha_b"),
                        vysledky.getInt("vaha_c"),
                        vysledky.getInt("cena_a"),
                        vysledky.getInt("cena_b"),
                        vysledky.getInt("cena_c"),
                        vysledky.getString("poznamka"));
                return zbroj;
            }
        } catch (SQLException ex) {
        System.err.println(CHYBA + ex);
        return null;
        }


    }





//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================

}

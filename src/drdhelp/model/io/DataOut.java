/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model.io;

import drdhelp.model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;


/*******************************************************************************
 * Instance třídy {@code DataOut} načítají data z databáze drddesk_db.
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2016-09-18
 */
public class DataOut extends Data {

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
    public DataOut() {
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================
//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /**
     * Vrátí všechny id a názvy z tabulky zadané v parametru z databáze
     * drddesk_db ve formátu id,název. Seznam platných tabulek je v TabulkaDB.
     *
     * @param tabulka String
     * @return ArrayList String
     */
    public ArrayList<Odkaz> nactiOdkazy(String tabulka) {
        if (isTabOk(tabulka)) {
            String sql = "SELECT * FROM " + tabulka;
            try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
                PreparedStatement dotaz = db.prepareStatement(sql);
                ResultSet data = dotaz.executeQuery();)
            {
                ArrayList<Odkaz> vystup = new ArrayList<>();
                while (data.next()) {
                    Odkaz odkaz = vratOdkaz(data, tabulka);
                    vystup.add(odkaz);
                }
                return vystup;
            } catch (SQLException ex) {
                System.err.println("DataOut.nactiOdkazy: " + CHYBA);
                ex.printStackTrace();
            }
        } else {
            System.err.println("DataOut.nactiOdkazy(): Chybný název tabulky" +
                    " v parametru tabulka!");
        }
        return null;
    }

    /**
     * Vrátí všechny Kouzla z tabulky zadané v parametru z databáze drddesk_db.
     * Pokud nebude předána validní tabulky, vrátí null. Seznam platných tabulek
     * je v TabulkaDB.
     *
     * @param tabulka String
     * @return ArrayList String
     */
    public ArrayList<Kouzlo> getKouzla(String tabulka) {
        // pokud tabulka odpovídá kouzelnickým nebo přírodním kouzlům ...
        if (tabulka.equals(TabulkaDB.KOUZLO.getTabNazev())
                || tabulka.equals(TabulkaDB.PRIRODNI_KOUZLO.getTabNazev())) {
            String sql = "SELECT * FROM " + tabulka;
            try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
                PreparedStatement dotaz = db.prepareStatement(sql);
                ResultSet data = dotaz.executeQuery();)
            {
                ArrayList<Kouzlo> kouzlaList = new ArrayList<>();
                while (data.next()) {

                    Kouzlo kouzlo = new Kouzlo(
                            data.getInt("id"),
                            data.getString("nazev"),
                            data.getString("magy"));

                    kouzlaList.add(kouzlo);
                }
                return kouzlaList;
            } catch (SQLException ex) {
                System.err.println("DataOut.getKouzla: " + CHYBA);
                ex.printStackTrace();
            }
        } else {
            System.err.println("DataOut.getKouzla(): Chybný název tabulky" +
                    " v parametru tabulka!");
        }
        return null;
    }

    /**
     * Načte všechna jména postav a příslušná id z databáze drddesk_db.
     *
     * @return Seznam id a jmen všech postav z databáze. V záznamu je první id
     * a od jména oddělené "," např.: "1,Killien"
     */
    public ArrayList<String> getNazevAIdPostav() {
        String sql = "SELECT * FROM postava";
        try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql);
            ResultSet data = dotaz.executeQuery(); )
        {
            ArrayList<String> postava = new ArrayList<>();
            while (data.next()) {
                String id = String.valueOf(data.getInt("id"));
                String jmeno = data.getString("nazev");
                postava.add(id + "," + jmeno);
            }
            return postava;

        } catch (SQLException ex) {
            System.err.println("DataOut.getNazevAIdPostav(): " + CHYBA);
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Načte vlastnosti instance Rasa z databáze drddesk_db dle názvu rasy
     * a vrátí instanci Rasa.
     *
     * @param id Id v databazi drddesk_db.
     * @return Instance třídy Rasa.
     */
    public Rasa getRasa(int id) {
        String sql = "SELECT * FROM rasa WHERE id=?";
        try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql); )
        {
            dotaz.setInt(1, id);
            try (ResultSet vysledky = dotaz.executeQuery())
            {
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
            System.err.println("DataOut.getRasa(): " + CHYBA);
            ex.printStackTrace();
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
        String sql = "SELECT * FROM povolani WHERE id=?";
        try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql); )
        {
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
            System.err.println("DataOut.getPovolani(): " + CHYBA);
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Vrátí ArrayList se zvláštními schopnostmi povolání.
     *
     * @param povolani Název povolání z databaze drddesk_db.
     * @return ArrayList
     */
    public ArrayList<Odkaz> getZvlSchopnostiPovolani(String povolani) {
        ArrayList<Odkaz> zvlSchopnostiList = new ArrayList<>();
        String sql = "SELECT * FROM zvl_schopnost WHERE povolani=?";
        try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql); )
        {
            dotaz.setString(1, povolani);
            try (ResultSet vysledky = dotaz.executeQuery()) {
                vysledky.next();

                ArrayList<Odkaz> vystup = new ArrayList<>();
                while (vysledky.next()) {
                    Odkaz odkaz = vratOdkaz(vysledky, TabulkaDB.ZVL_SCHOPNOSTI
                            .getTabNazev());
                    vystup.add(odkaz);
                }
                return vystup;
            }
        } catch (SQLException ex) {
            System.err.println("DataOut.getZvlSchopnostiPovolani(): " + CHYBA);
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Vrátí String se zvláštní schopností podle rasy, pokud nějaké je, jinak
     * vrátí null.
     *
     * @param rasa Název Rasy z databaze drddesk_db
     * @return String
     */
    public Odkaz getZvlSchopnostiRasa(String rasa) {
        ArrayList<String> zvlSchopnostiList = new ArrayList<>();
        String sql = "SELECT * FROM zvl_schopnost WHERE rasa=?";
        try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql); )
        {
            dotaz.setString(1, rasa);
            try (ResultSet vysledky = dotaz.executeQuery()) {
                if (vysledky.next()) {
                    Odkaz zvlSchopnost = new Odkaz(vysledky.getInt("id"),
                                        vysledky.getString("nazev"),
                                        TabulkaDB.ZVL_SCHOPNOSTI.getTabNazev());
                   return zvlSchopnost;
                }
            }
        } catch (SQLException ex) {
            System.err.println("DataOut.getZvlSchopnostiRasa(): " + CHYBA);
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Vrátí ArrayList se zvláštními schopnostmi podle rasy a povolání.
     *
     * @param rasa Název rasy z databaze drddesk_db.
     * @param povolani Název povolaní z databaze drddesk_db.
     * @return ArrayList
     */
    public ArrayList<Odkaz> getZvlSchopnostiRasaAPovolani(String rasa,
                                                           String povolani) {
        ArrayList<Odkaz> zvlArrayList = new ArrayList<>();
        zvlArrayList.addAll(getZvlSchopnostiPovolani(povolani));
        Odkaz zvlRasa = getZvlSchopnostiRasa(rasa);
        if (zvlRasa != null) zvlArrayList.add(zvlRasa);
        return zvlArrayList;
    }

    /**
     * Načte všechny údaje o postavě do instance Postava z databáze drddesk_db.
     *
     * @param id Primary key - identifikační číslo postavy v databázi.
     * @return Instance třídy Postava.
     */
    public Postava getPostava(int id) {
        String sql = "SELECT * FROM postava WHERE id=?";
        try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql); )
        {
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
                    stringToArrayListOdkaz(vysledky.getString("zbran_tvt"),
                                           TabulkaDB.ZBRAN_TVT.getTabNazev()),
                    stringToArrayListOdkaz(vysledky.getString("zbran_sav"),
                                           TabulkaDB.ZBRAN_SAV.getTabNazev()),
                    stringToArrayListOdkaz(vysledky.getString("zbroj"),
                                           TabulkaDB.ZBROJ.getTabNazev()),
                    stringToArrayListOdkaz(vysledky.getString("vybaveni"),
                                           TabulkaDB.VYBAVA.getTabNazev()),
                    vysledky.getString("rodova_zbran"),
                    vysledky.getString("velikost"),
                    stringToArrayListOdkaz(vysledky.getString("zvlastni_schopnosti"),
                                           TabulkaDB.ZVL_SCHOPNOSTI.getTabNazev()),
                    stringToArrayListOdkaz(vysledky.getString("kouzla"),
                                           TabulkaDB.KOUZLO.getTabNazev()),
                    stringToArrayListOdkaz(vysledky.getString("prirodni_kouzla"),
                                           TabulkaDB.PRIRODNI_KOUZLO.getTabNazev()),
                    vysledky.getString("poznamka"));

                return postavaPomocna;
            }
        } catch (SQLException ex) {
            System.err.println("DataOut.getPostava(): " + CHYBA);
            ex.printStackTrace();
//        } catch (ParseException ex) {
//            System.err.println("CHYBA: DataOut.vratKouzla():");
//            System.err.println("Chybný formát dat v databázi drddesk_db, tabulka" +
//                    " postava, sloupec kouzla u položky id: " + id);
//            ex.printStackTrace();
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
        String sql = "SELECT * FROM nestvura WHERE id=?";
        try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql); )
        {
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
            System.err.println("DataOut.getNestvura(): " + CHYBA);
            ex.printStackTrace();
        }
        return null;
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
        String sql = "SELECT * FROM zkusenosti WHERE uroven=?";
        try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql); )
        {
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
            System.err.println("DataOut.getZkusenosti(): " + CHYBA);
            ex.printStackTrace();
        }
        return -1;
    }

    /**
     * Z databáze drddesk_db načte údaje pro zbraň pro boj tváří v tvář.
     *
     * @param id
     * @return ZbranTVT
     */
    public ZbranTVT getZbranTVT(int id) {
        String sql = "SELECT * FROM zbran_tvt WHERE id=?";
        try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql); )
        {
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
            System.err.println("DataOut.getZbranTVT(): " + CHYBA);
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Z databáze drddesk_db načte údaje pro zbraň pro boj tváří v tvář.
     *
     * @param id
     * @return ZbranSAV
     */
    public ZbranSAV getZbranSAV(int id) {
        String sql = "SELECT * FROM zbran_sav WHERE id=?";
        try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql); )
        {
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
            System.err.println("DataOut.getZbranSAV(): " + CHYBA);
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Z databáze drddesk_db načte údaje pro výbavu.
     *
     * @param id
     * @return Vybava
     */
    public Vybava getVybava(int id) {
        String sql = "SELECT * FROM vybava WHERE id=?";
        try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql); )
        {
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
            System.err.println("DataOut.getVybava(): " + CHYBA);
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Z databáze drddesk_db načte údaje pro kouzelnické kouzlo.
     *
     * @param id
     * @return Kouzlo
     */
    public Kouzlo getKouzlo(int id) {
        return getKouzlo(id, TabulkaDB.KOUZLO.getTabNazev());
    }

    /**
     * Z databáze drddesk_db načte údaje pro přírodní kouzlo.
     *
     * @param id
     * @return Kouzlo
     */
    public Kouzlo getPrirodniKouzlo(int id) {
        return getKouzlo(id, TabulkaDB.PRIRODNI_KOUZLO.getTabNazev());
    }

    /**
     * Z databáze drddesk_db načte údaje pro zbroj
     *
     * @param id
     * @return Vybava
     */
    public Zbroj getZbroj(int id) {
        String sql = "SELECT * FROM zbroj WHERE id=?";
        try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
            PreparedStatement dotaz = db.prepareStatement(sql); )
        {
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
            System.err.println("DataOut.getZbroj(): " + CHYBA);
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Převede seznamId na ArrayList Odkazů.
     *
     * @param seznamId Seznam odkazu ve tvaru {id1},{id2},{id3}, ...
     * @param tabulka Tabulka z databaze drddesk_db, které odpovídají id ze SeznamId.
     * @return
     */
    public ArrayList<Odkaz> stringToArrayListOdkaz(String seznamId, String tabulka) {
        if (seznamId != null) {
            String[] poleStrings = seznamId.split(",");
            int id;
            ArrayList<Odkaz> arrayList = new ArrayList<>();

            if (poleStrings != null) {
                for (String polozka : poleStrings) {
                    id = Integer.parseInt(polozka);
                    Odkaz odkaz = nactiOdkaz(id, tabulka);
                    if (odkaz != null) {
                        arrayList.add(odkaz);
                    } else System.err.println("DataOut.stringToArrayListOdkaz(): CHYBA," +
                            " pro id: " + id + " v tabulce: " + tabulka +
                            " neexistuje položka v databázi drddesk_db!");
                }
                return arrayList;
            }
        }
        return null;
    }

    /**
     * Vrátí odkaz na položku z databaze drddesk_db dle parametrů. Pokud neexistuje,
     * vrátí null.
     *
     * @param id Id položky v tabulce.
     * @param tabulka Tabulka odpovídající databázi drddesk_ db.
     * @return Odkaz Požadovaný Odkaz na položku.
     */
    public Odkaz nactiOdkaz(int id, String tabulka) {
        if (isTabOk(tabulka)) {
            String sql = "SELECT * FROM " + tabulka + " WHERE id=?";
            try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
                PreparedStatement dotaz = db.prepareStatement(sql); )
            {
                dotaz.setInt(1, id);
                try (ResultSet vysledky = dotaz.executeQuery()) {
                    vysledky.next();
                    Odkaz odkaz = vratOdkaz(vysledky, tabulka);
                    return odkaz;
                }
            } catch (SQLException ex) {
            System.err.println("DataOut.nactiOdkaz(): " + CHYBA);
            ex.printStackTrace();
            }
        } else {
            System.err.println("DataOut.nactiOdkaz(): Chybný název tabulky" +
                    " v parametru tabulka!");
        }
        return null;
    }


//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

    /** Vrátí číslo se znaménkem i pro kladná čísla a 0 ve String */
    private String getStringSeZnamenkem(int hodnota) {
        return String.format("%+d",hodnota);
    }

    /** Vrátí Odkaz s příslušným řádkovým popisem */
    private Odkaz vratOdkaz(ResultSet data, String tabulka) throws SQLException {

        int id = data.getInt("id");
        String nazev = data.getString("nazev");
        String radkovyPopis = nazev + "   ";
        // postava
        if (tabulka.equals(TabulkaDB.POSTAVA.getTabNazev())) {
            radkovyPopis += data.getString("rasa") + "  "
                           + data.getString("povolani") + "  "
                           + "úr. " + data.getInt("uroven");
        }
        // nestvůra
        if (tabulka.equals(TabulkaDB.NESTVURA.getTabNazev())) {
            String zvt = data.getString("zivotaschopnost");
            int konstanta = data.getInt("konstanta_zvt");
            if (zvt.equals("-1")) zvt = "1-2 životy";
            if (zvt.equals("-2")) zvt = "½ (1-4 životy)";
            if (konstanta > 0) zvt += " + " + konstanta;
            radkovyPopis += "žvt. " + zvt;
        }
        // zbraň tvt
        if (tabulka.equals(TabulkaDB.ZBRAN_TVT.getTabNazev())) {
            radkovyPopis += data.getInt("sila")
                        + getStringSeZnamenkem(data.getInt("utocnost"))
                        + getStringSeZnamenkem(data.getInt("obrana")) + "  "
                        + data.getInt("vaha") + "mn";
        }
        // zbraň sav
        if (tabulka.equals(TabulkaDB.ZBRAN_SAV.getTabNazev())) {
            radkovyPopis +=  data.getInt("sila")
                        + getStringSeZnamenkem(data.getInt("utocnost")) + "  "
                             + data.getInt("maly_dostrel") + "/"
                             + data.getInt("stredni_dostrel") + "/"
                             + data.getInt("velky_dostrel") + "  "
                             + data.getInt("vaha") + "mn";
        }
        // zbroj
        if (tabulka.equals(TabulkaDB.ZBROJ.getTabNazev())) {
            radkovyPopis += getStringSeZnamenkem(data.getInt("kvalita"));
        }
        // výbava
        if (tabulka.equals(TabulkaDB.VYBAVA.getTabNazev())) {
            radkovyPopis += data.getInt("vaha") + "mn";
        }
        // kouzlo
        if (tabulka.equals(TabulkaDB.KOUZLO.getTabNazev())
                || tabulka.equals(TabulkaDB.PRIRODNI_KOUZLO.getTabNazev())) {
            radkovyPopis += data.getString("magy");
        }
        // zvláštní schopnosti
        if (tabulka.equals(TabulkaDB.ZVL_SCHOPNOSTI.getTabNazev())) {
            radkovyPopis = radkovyPopis.trim();
        }

        return new Odkaz(id, radkovyPopis, tabulka);
    }

    /**
     * Slouží ke čtení kouzelnických nebo přírodních kouzel. Druh se určí podle
     * tabulky z enum TabulkaDB. Platné hodnoty jsou pouze KOUZLO a PRIRODNI_KOUZLO.
     * Pro neplatnou tabulku vrátí null.
     */
    private Kouzlo getKouzlo(int id, String tabulka) {
        // pokud tabulka odpovídá kouzelnickým nebo přírodním kouzlům ...
        if (tabulka.equals(TabulkaDB.KOUZLO.getTabNazev())
                || tabulka.equals(TabulkaDB.PRIRODNI_KOUZLO.getTabNazev())) {
            String sql = "SELECT * FROM " + tabulka + " WHERE id=?";
            try (Connection db = DriverManager.getConnection(URL, USER, HESLO);
                PreparedStatement dotaz = db.prepareStatement(sql); )
            {
                dotaz.setInt(1, id);
                try (ResultSet vysledky = dotaz.executeQuery()) {
                    vysledky.next();

                    Kouzlo kouzlo = new Kouzlo(id,
                            vysledky.getString("nazev"),
                            vysledky.getString("magy"));

                    return kouzlo;
                }
            } catch (SQLException ex) {
                System.err.println("DataOut.getKouzlo(): " + CHYBA);
                ex.printStackTrace();
            }
        } else {
            System.err.println("DataOut.getKouzlo(): Chybný název tabulky" +
                    " v parametru tabulka!");
        }
        return null;
    }

//    /** Převede String s kouzly na ArrayList. Kouzlo reprezentuje id z databáze
//     * drddesk_db a druh, ty jsou oddělené ",". Jednotlivá kouzla (tedy id a druh) jsou
//     * oddělená ";". */
//    private ArrayList<Kouzlo> vratKouzla(String kouzla) throws ParseException {
//        if (kouzla != null) {
//            ArrayList<Kouzlo> kouzlaArrayList = new ArrayList<>();
//            Kouzlo kouzlo;
//            int id;
//            for (String s : ukazatele) {
//                ukazatel = s.split(",");
//                id = Integer.parseInt(ukazatel[1]);
//                kouzlo = vratKouzlo(ukazatel[0], id);
//                if (kouzlo != null) kouzlaArrayList.add(kouzlo);
//            }
//            return kouzlaArrayList;
//        }
//        return null;
//    }

//    /** Načte kouzlo z databaze drddesk_db podle id a druhu. */
//    private Kouzlo vratKouzlo(String druh, int id) {
//        if (druh.equals("k")) return getKouzlo(id);
//        if (druh.equals("p")) return getPrirodniKouzlo(id);
//        return null;
//    }

    /** Načte z databáze drddesk_db hodnotu Integer, v případě null vrátí null.  */
    private Integer getInteger(ResultSet vysledky, String sloupecVDB) {
        try {
            int hodnotaInt = vysledky.getInt(sloupecVDB);
            if (hodnotaInt != 0) return hodnotaInt;
        } catch (SQLException ex) {
            System.err.println("DataOut.getInteger(): " + CHYBA);
            ex.printStackTrace();
        }
        return null;
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





//##############################################################################
//== NESTED DATA TYPES =========================================================

}

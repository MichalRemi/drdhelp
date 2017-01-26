/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;

import java.util.ArrayList;





/*******************************************************************************
 * Instance třídy {@code Postava} představují postavu v Dračím doupěti.
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2016-09-18
 */
public class Postava extends Tvor implements IPopis {

//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT AND VARIABLE INSTANCE ATTRIBUTES =================================


    /** Rasa postavy. */
    private final String RASA;

    /** Povolání postavy. */
    private final String POVOLANI;

    /** Aktuální životy postavy. */
    private int zivoty;

    /** Maximum životů postavy. */
    private int zivotyMax;

    /** Aktuální magenergie postavy. */
    private int magy;

    /** Maximální magenergie postavy. */
    private int magyMax;

    /** Úroveň postavy. */
    private int uroven;

    /** Zkušenosti postavy. */
    private int zkusenosti;

    /** Zkušenosti potřebné na další úroveň. */
    private int zkusenostiDalsiUroven;

    /** Výška postavy v coulech (1 coul [cl] je 1 cm). */
    private final int VYSKA;

    /** Váha postavy v mincích (20 mincí [mn] je 1kg). */
    private final int VAHA;

    /** Zbraně pro boj tváří v tvář */
    private String zbranTVT;

    /** Zbraně střelné a vrhací */
    private String zbranSAV;

    /** Zbroj a štít */
    private String zbroj;

    /** Vybavení tvora */
    private String vybaveni;

    /** Rodová zbraň podle rasy postavy. */
    private final String RODOVA_ZBRAN;

     /** Zvláštní schopnosti podle rasy a podle povolání. */
    private String zvlastniSchopnosti;



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /**
     * Konstruktor
     *
     * @param id Id postavy v databázi
     * @param nazev Jméno postavy
     * @param rasa Rasa postavy
     * @param povolani Povolání postavy
     * @param zivoty Aktuální počet životů
     * @param zivotyMax Maximum životů
     * @param magy Aktuální magenergie
     * @param magyMax Maximum magenergie
     * @param hodnotyVlastnosti Hodnoty vlastností postavy - int[]
     * @param zkusenosti Získané zkušenosti postavy
     * @param zkusenostiDalsiUroven Zkušenosti potřebné na přestup na další úroveň
     * @param uroven Úroveň postavy
     * @param pohyblivost Pohyblivost postavy
     * @param vyska Výška postavy
     * @param vaha Váha postavy
     * @param zbranTVT Zbraně pro boj tváří v tvář
     * @param zbranSAV Zbraně střelné a vrhací
     * @param zbroj Zbroj a štít
     * @param vybaveni Vybavení postavy
     * @param rodovaZbran Rodová zbraň podle rasy postavy
     * @param velikost Velikost postavy
     * @param zvlastniSchopnosti Zvláštní schopnosti podle rasy a podle povolání
     * @param poznamka Zde může být cokoliv
     */
    public Postava(int id, String nazev, String rasa, String povolani, int zivoty,
                   int zivotyMax, int magy, int magyMax, int uroven, int zkusenosti,
                   int zkusenostiDalsiUroven, Integer[] hodnotyVlastnosti,
                   Vlastnost pohyblivost, int vyska, int vaha, String zbranTVT,
                   String zbranSAV, String zbroj, String vybaveni, String rodovaZbran,
                   String velikost, String zvlastniSchopnosti, String poznamka) {

        super(id, nazev, hodnotyVlastnosti, pohyblivost, velikost, poznamka);
        this.RASA = rasa;
        this.POVOLANI = povolani;
        this.zivoty = zivoty;
        this.zivotyMax = zivotyMax;
        this.magy = magy;
        this.magyMax = magyMax;
        this.uroven = uroven;
        this.zkusenostiDalsiUroven = zkusenostiDalsiUroven;
        this.VYSKA = vyska;
        this.VAHA = vaha;
        this.zbranTVT = zbranTVT;
        this.zbranSAV = zbranSAV;
        this.zbroj = zbroj;
        this.vybaveni = vybaveni;
        this.RODOVA_ZBRAN = rodovaZbran;
        this.zvlastniSchopnosti = zvlastniSchopnosti;
    }



//== ABSTRACT METHODS ==========================================================

    @Override
    public String getPodrobnyPopis() {
        String popis =    "Jméno:   " + super.getNazev() + "\n"
                        + "Rasa:   " + RASA + "\n"
                        + "Povolání:   " + POVOLANI + "\n"
                        + "Životy:   " + zivoty + "\n"
                        + "Úroveň:   " + uroven + "\n";
        if (magy != 0) popis += "Magy:   " + magy + "\n";
        popis += "\n";

        // přidá zbraně, zbroj a štít
        popis += arrayListdoRadku(getBojArrayList());
        popis += "\n";

        // přidá vlastnosti, pohyblivost a nosnost
        popis += arrayListdoRadku(getAtributyArrayList());

        // přidá zvláštní schopnosti
        popis += "\nZvláštní schopnosti:\n"
                + arrayListdoRadku(stringToArrayList(zvlastniSchopnosti));

        popis += nactiPoznamku();

        return popis;
    }

//== INSTANCE GETTERS AND SETTERS ==============================================


    public int getZivoty() {
        return zivoty;
    }

    public int getUroven() {
        return uroven;
    }

    public int getVyska() {
        return VYSKA;
    }

    public int getVaha() {
        return VAHA;
    }

    public String getZbranSAV() {
        return zbranSAV;
    }

    public String getZbranTVT() {
        return zbranTVT;
    }

    public String getZbroj() {
        return zbroj;
    }

    public String getVybaveni() {
        return vybaveni;
    }

    public String getRasa() {
        return RASA;
    }

    public String getPovolani() {
        return POVOLANI;
    }

    public int getZivotyMax() {
        return zivotyMax;
    }

    public void setZivotyMax(int zivotyMax) {
        this.zivotyMax = zivotyMax;
    }

    public int getMagy() {
        return magy;
    }

    public void setMagy(int magy) {
        this.magy = magy;
    }

    public int getMagyMax() {
        return magyMax;
    }

    public void setMagyMax(int magyMax) {
        this.magyMax = magyMax;
    }

    public int getZkusenosti() {
        return zkusenosti;
    }

    public void setZkusenosti(int zkusenosti) {
        this.zkusenosti = zkusenosti;
    }

        public String getZvlastniSchopnosti() {
        return zvlastniSchopnosti;
    }

    public void setZvlastniSchopnosti(String zvlastniSchopnosti) {
        this.zvlastniSchopnosti = zvlastniSchopnosti;
    }

    public int getZkusenostiDalsiUroven() {
        return zkusenostiDalsiUroven;
    }

    public void setZkusenostiDalsiUroven(int zkusenostiDalsiUroven) {
        this.zkusenostiDalsiUroven = zkusenostiDalsiUroven;
    }

    public void setVybaveni(String vybaveni) {
        this.vybaveni = vybaveni;
    }

    public void setZbranTVT(String zbranTVT) {
        this.zbranTVT = zbranTVT;
    }

    public void setZbranSAV(String zbranSAV) {
        this.zbranSAV = zbranSAV;
    }

    public void setZbroj(String zbroj) {
        this.zbroj = zbroj;
    }



//== OTHER NON-PRIVATE INSTANCE METHODS ========================================


    /**
     * Vrátí String s aktuálním počtem životů/maximálním počtem životů
     *
     * @return String aktuální životy/maximální životy.
     */
    public String getZivotyString() {
        return String.format("%d/%d",getZivoty(),getZivotyMax());
    }

    /**
     * Kouzlí postava? ano/ne - true/false.
     *
     * @return Boolean kouzlí/nekouzlí
     */
    public Boolean postavaKouzli() {
        if (getMagyMax() == 0) return false;
        else return true;
    }

    /**
     * Vrátí String s aktuálním počtem magů/maximálním počtem magů.
     *
     * @return String aktuální magy/maximální magy.
     */
    public String getMagyString() {
        if (getMagyMax() != 0) return String.format("%d/%d",getMagy(),getMagyMax());
        else return null;
    }

    /**
     * Vrátí String s aktuální úrovní.
     *
     * @return String aktuální úroveň.
     */
    public String getUrovenString() {
        return String.valueOf(getUroven());
    }

    /**
     * Vrátí String s aktuálním počtem zkušeností.
     *
     * @return String aktuální magy/maximální magy.
     */
    public String getZkusenostiString() {
        return String.format("%d/%d",getZkusenosti(),getZkusenostiDalsiUroven());
    }

    /**
     * Vrátí ArrayList pro Naložení žádné, mírné, střední a velké.
     *
     * @return ArrayListString
     */
    public ArrayList<String> getNosnostArrayList() {
        int bonusSila = getVlastnosti().getVlastnost(0).getBonus();
        int hodnota = (5 + bonusSila) * 30 + 210;

        ArrayList<String> pohyblivostArrayList = new ArrayList<>();
        pohyblivostArrayList.add("Nosnost");
        pohyblivostArrayList.add(vypisString("- žádné", hodnota) + " mn");
        pohyblivostArrayList.add(vypisString("- mírné", hodnota * 2) + " mn");
        pohyblivostArrayList.add(vypisString("- střední", hodnota * 3) + " mn");
        pohyblivostArrayList.add(vypisString("- velké", hodnota * 4) + " mn");

        return pohyblivostArrayList;
    }

    /**
     * Vrátí ArrayList pro Postřeh při hledaní.
     *
     * @return ArrayListString
     */
    public ArrayList<String> getPostrehArrayList() {
        String povolani = getPovolani();
        int postrehObjekty, postrehMechanismy;

        // Určení postřehu pro Zloděje
        if (povolani.equals("zloděj")) {
            int bonusObratnost = getVlastnosti().getVlastnost(1).getBonus();
            int uroven = getUroven();
            postrehObjekty = 5 * uroven + 3 * bonusObratnost;
            postrehMechanismy = 5 * uroven + 2 * bonusObratnost;
        }

        // Určení postřehu pro jiná povolání než Zloděj
        else {
            String rasa = getRasa();
            int inteligence = getVlastnosti().getVlastnost(3).getHodnota();
            postrehObjekty = inteligence;
            if ((rasa.equals("Kroll")) || (rasa.equals("Barbar"))
                || (rasa.equals("Trpaslík"))) postrehObjekty += 5;

            postrehMechanismy = inteligence / 2;
            if ((rasa.equals("Elf")) || (rasa.equals("Hobit"))
                || (rasa.equals("Kudůk"))) postrehObjekty += 5;
        }

        ArrayList<String> postrehArrayList = new ArrayList<>();
        postrehArrayList.add(vypisString("Objekty", postrehObjekty) + " %");
        postrehArrayList.add(vypisString("Mechanismy", postrehMechanismy) + " %");

        return postrehArrayList;
    }

    /**
     * @return Návev vlastnosti, hodnotu vlastnosti a bonus se znaménkem i pro
     * kladná čísla a 0
     */
    public String vypisString(String nazev, int hodnota) {
        return String.format("%-10s %6d", nazev, hodnota);

    }

    /**
     * Vrátí ArrayList s Atributy - Vlastnosti, Výška, Váha, Nosnost a postřeh.
     *
     * @return ArrayListString
     */
    public ArrayList<String> getAtributyArrayList() {
        ArrayList<String> atributy = new ArrayList<>();
        // Síla, Obratnost, Odolnost, Inteligence, Charisma
        atributy.addAll(getVlastnosti().getVlastnostiArrayList());
        atributy.add("");
        // Výška
        atributy.add("Výška   " + getVyska() + " cl");
        // Váha
        atributy.add("Váha    " + getVaha() + " mn");
        atributy.add("");
        // Pohyblivost
        if (getPohyblivost().getHodnota() != null) {
            atributy.addAll(getPohyblivostArrayList());
            atributy.add("");
        }
        // Nosnost
        if (getVlastnosti().getSila() != null) {
            atributy.addAll(getNosnostArrayList());
            atributy.add("");
        }
        //Postřeh
        if (getVlastnosti().getObratnost() != null) {
            atributy.add("Postřeh hledání");
            atributy.addAll(getPostrehArrayList());
        }
        return atributy;
    }

    /**
     * Vrátí ArrayList pro bojovou výbavu postavy. Jsou to zbraně tváří v tvář,
     * střelné a vrhací, a zbroj a štít.
     *
     * @return ArrayListString
     */
    public ArrayList<String> getBojArrayList() {
        ArrayList<String> boj = new ArrayList<>();
        // Zbraně tváří v tvář
        if (!getZbranTVT().equals("null")) {
            boj.add("Zbraně tváří v tvář");
            boj.addAll(stringToArrayList(getZbranTVT()));
            boj.add("");
        }
        // Zbraně střelné a vrhací
        if (!getZbranSAV().equals("null")) {
            boj.add("Zbraně střelné a vrhací");
            boj.addAll(stringToArrayList(getZbranSAV()));
            boj.add("");
        }
        // Zbroj a štít
        if (!getZbranSAV().equals("null")) {
            boj.add("Zbroj");
            boj.addAll(stringToArrayList(getZbroj()));
        }
      return boj;
    }

    /**
    * Vrací textovou reprezentaci postavy - vypíše jméno, rasu, povolání
    * a vlastnosti postavy
    *
    * @return Textová reprezentace postavy
    */
    @Override
    public String toString(){
        return getNazev()+ " " + getRasa() + " " + getPovolani() + " uroveň: "
               + getUroven();
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}

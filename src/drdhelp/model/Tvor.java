/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;

import java.util.ArrayList;
import java.util.Arrays;





/*******************************************************************************
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2017-01-06
 */
public abstract class Tvor {

//== CONSTANT CLASS ATTRIBUTES =================================================

    public final static String[] hodnotyArray = {"1", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
            "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
            "31", "32", "33", "34", "35", "36", "37", "38", "39", "40"};

    public final static String[] hodnotyNAArray = {"N/A", "1", "2", "3", "4", "5", "6",
            "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18",
            "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
            "31", "32", "33", "34", "35", "36", "37", "38", "39", "40"};


//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT AND VARIABLE INSTANCE ATTRIBUTES =================================

    /** Id - primární id z databáze */
    private final int ID;

    /** Název tvora */
    private String nazev;

    /** Vlastnosti (Síla, Obratnost, Odolnost, Inteligence, Charisma) tvora */
    private Vlastnosti vlastnosti;

    /** Pohyblivost tvora. */
    private Vlastnost pohyblivost;

    /** Velikost tvora */
    private String velikost;

    /** Poznámka - popis, zvláštnosti, atd. */
    private String poznamka;



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /**
     * Konstruktor
     *
     * @param id Id tvora
     * @param nazev Název tvora
     * @param hodnotyVlastnosti Hodnoty vlastností tvora - int[]
     * @param pohyblivost Pohyblivost tvora
     * @param velikost Velikost tvora
     * @param poznamka popis, zvláštnosti, atd.
     */
    public Tvor(int id, String nazev, Integer[] hodnotyVlastnosti,
            Vlastnost pohyblivost, String velikost, String poznamka) {

        this.ID = id;
        this.nazev = nazev;
        Vlastnosti vlastnosti = new Vlastnosti(hodnotyVlastnosti);
        this.vlastnosti = vlastnosti;
        this.pohyblivost = pohyblivost;
        this.velikost = velikost;
        this.poznamka = poznamka;
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    public int getId() {
        return ID;
    }

    public String getNazev() {
        return nazev;
    }

    public Vlastnosti getVlastnosti() {
        return vlastnosti;
    }

    public Vlastnost getPohyblivost() {
        return pohyblivost ;
    }

    public String getVelikost() {
        return velikost;
    }

    public String getPoznamka() {
        return poznamka;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public void setPohyblivost(Vlastnost pohyblivost) {
        this.pohyblivost = pohyblivost;
    }

    public void setVlastnosti(Vlastnosti vlastnosti) {
        this.vlastnosti = vlastnosti;
    }

    public void setVelikost(String velikost) {
        this.velikost = velikost;
    }

    public void setPoznamka(String poznamka) {
        this.poznamka = poznamka;
    }


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================


    /** Převede ArrayList na String (výpis do řádků), jednotlivé položky
     * ArrayListu jsou odřádkované "\n"
     */
    public String arrayListdoRadku(ArrayList<String> list) {
        String vypis = new String();
        for (String s : list) {
            vypis += s + "\n";
        }
        return vypis;
    }

    /** Převede String na arrayList (oddělovač je ",") */
    public ArrayList<String> stringToArrayList(String text) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(text.split(",")));
        return arrayList;
    }

    /**
     * Vrátí ArrayList s Pohyblivostí pro naložení žádné, mírné, střední a velké.
     *
     * @return ArrayListString
     */
    public ArrayList<String> getPohyblivostArrayList() {
        ArrayList<String> pohyblivostArrayList = new ArrayList<>();
        Vlastnost pohyblivost = getPohyblivost();
        Integer hodnota = pohyblivost.getHodnota();
        Vlastnost[] ctvrtiny = new Vlastnost[4];
        ctvrtiny[0] = pohyblivost;
        ctvrtiny[1] = new Vlastnost("- mírné", pohyblivost.deleniNahoru(hodnota * 3, 4));
        ctvrtiny[2] = new Vlastnost("- střední", pohyblivost.deleniNahoru(hodnota, 2));
        ctvrtiny[3] = new Vlastnost("- velké", pohyblivost.deleniNahoru(hodnota, 4));
        for (Vlastnost v : ctvrtiny) pohyblivostArrayList.add(v.toString());

        return pohyblivostArrayList;
    }

    public String getSilaString() {
        return String.valueOf(getVlastnosti().getSila());
    }

    public String getObratnostString() {
        return String.valueOf(getVlastnosti().getObratnost());
    }

    public String getOdolnostString() {
        return String.valueOf(getVlastnosti().getOdolnost());
    }

    public String getInteligenceString() {
        return String.valueOf(getVlastnosti().getInteligence());
    }

    public String getCharismaString() {
        return String.valueOf(getVlastnosti().getCharisma());
    }

    public Integer getSila() {
        return getVlastnosti().getVlastnost(0).getHodnota();
    }

    public Integer getObratnost() {
        return getVlastnosti().getVlastnost(1).getHodnota();
    }

    public Integer getOdolnost() {
        return getVlastnosti().getVlastnost(2).getHodnota();
    }

    public Integer getInteligence() {
        return getVlastnosti().getVlastnost(3).getHodnota();
    }

    public Integer getCharisma() {
        return getVlastnosti().getVlastnost(4).getHodnota();
    }


//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

    /** Ošetřuje situaci, kdy není poznámka zadaná v db(null), jinak ji vrátí ve String */
    protected String nactiPoznamku() {

        String poznamka = "";
        if (this.poznamka != null) {
            poznamka = "\nPoznámka:\n" + getPoznamka();
        }
        return poznamka;
    }


//##############################################################################
//== NESTED DATA TYPES =========================================================

public enum Presvedceni {
        NA("N/A"),
        ZKD("ZkD"),
        ZMD("ZmD"),
        N("N"),
        ZMZ("ZmZ"),
        ZKZ("ZkZ");

        private final String nazev;

        Presvedceni(String nazev) {
            this.nazev = nazev;
        }

        @Override
        public String toString() {
            return nazev;
        }
    }


}

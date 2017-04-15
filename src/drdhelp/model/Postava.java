/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;

import drdhelp.model.io.DataOut;
import java.util.ArrayList;





/*******************************************************************************
 * Instance třídy {@code Postava} představují postavu v Dračím doupěti.
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class Postava extends Tvor implements IPopis {

//== CONSTANT CLASS ATTRIBUTES =================================================

    public final static int[] UROVEN = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
            13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29,
            30, 31, 32, 33, 34, 35, 36};

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

    /** Může postava ovládat magii? */
    private final boolean KOUZLI;

    /** Aktuální životy postavy. */
    private int zivoty;

    /** Aktuální magenergie postavy. */
    private int magy;

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
    private ArrayList<Odkaz> zbranTVT;

    /** Zbraně střelné a vrhací */
    private ArrayList<Odkaz> zbranSAV;

    /** Zbroj a štít */
    private ArrayList<Odkaz> zbroj;

    /** Vybavení tvora */
    private ArrayList<Odkaz> vybava;

    /** Rodová zbraň podle rasy postavy. */
    private final String RODOVA_ZBRAN;

     /** Zvláštní schopnosti podle rasy a podle povolání. */
    private ArrayList<Odkaz> zvlastniSchopnosti;

    /** Kouzelnická kouzla postavy. */
    private ArrayList<Odkaz> kouzla;

    /** Přírodní kouzla postavy. */
    private ArrayList<Odkaz> prirodniKouzla;

    /** Popis, poznámka, atd... . */
    private String poznamka;


    DataOut dataOut = new DataOut();



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /**
     * Konstruktor
     *
     * @param id Id postavy v databázi
     * @param nazev Jméno postavy
     * @param rasa Rasa postavy
     * @param povolani Povolání postavy
     * @param kouzli Umí postava ovládat magii?
     * @param zivoty Aktuální počet životů
     * @param magy Aktuální magenergie
     * @param hodnotyVlastnosti Hodnoty vlastností postavy - int[]
     * @param zkusenosti Získané zkušenosti postavy
     * @param uroven Úroveň postavy
     * @param pohyblivost Pohyblivost postavy
     * @param vyska Výška postavy
     * @param vaha Váha postavy
     * @param zbranTVT Zbraně pro boj tváří v tvář
     * @param zbranSAV Zbraně střelné a vrhací
     * @param zbroj Zbroj a štít
     * @param vybava Vybavení postavy
     * @param rodovaZbran Rodová zbraň podle rasy postavy
     * @param velikost Velikost postavy
     * @param zvlastniSchopnosti Zvláštní schopnosti podle rasy a podle povolání
     * @param kouzla Kouzelnická kouzla postavy
     * @param prirodniKouzla Hraničářská kouzla postavy
     * @param poznamka Zde může být cokoliv
     */
    public Postava(int id, String nazev, String rasa, String povolani, boolean kouzli,
            int zivoty, int magy, int uroven,
            int zkusenosti, Integer[] hodnotyVlastnosti,
            Vlastnost pohyblivost, int vyska, int vaha, ArrayList<Odkaz> zbranTVT,
            ArrayList<Odkaz> zbranSAV, ArrayList<Odkaz> zbroj,
            ArrayList<Odkaz> vybava, String rodovaZbran, String velikost,
            ArrayList<Odkaz> zvlastniSchopnosti, ArrayList<Odkaz> kouzla,
            ArrayList<Odkaz> prirodniKouzla, String poznamka) {

        this(id, nazev, rasa, povolani, kouzli, vyska, vaha, hodnotyVlastnosti, pohyblivost,
            velikost, rodovaZbran);
        this.zivoty = zivoty;
        this.magy = magy;
        this.uroven = uroven;
        this.zbranTVT = zbranTVT;
        this.zbranSAV = zbranSAV;
        this.zbroj = zbroj;
        this.vybava = vybava;
        this.zvlastniSchopnosti = zvlastniSchopnosti;
        this.kouzla = kouzla;
        this.prirodniKouzla = prirodniKouzla;
    }

    private Postava(int id, String nazev, String rasa, String povolani, boolean kouzli,
            int vyska, int vaha, Integer[] hodnotyVlastnosti, Vlastnost pohyblivost,
            String velikost, String rodovaZbran) {

        super(id, nazev, hodnotyVlastnosti, pohyblivost, velikost, null);
        this.RASA = rasa;
        this.POVOLANI = povolani;
        this.KOUZLI = kouzli;
        this.VYSKA = vyska;
        this.VAHA = vaha;
        this.RODOVA_ZBRAN = rodovaZbran;
    }

    /** Konstruktor pro tvobu nové postavy */
    public Postava(String nazev, String rasa, String povolani, boolean kouzli, int vyska,
            int vaha, Integer[] hodnotyVlastnosti, Vlastnost pohyblivost,
            String velikost, String rodovaZbran) {

        this(0, nazev, rasa, povolani, kouzli, vyska, vaha, hodnotyVlastnosti, pohyblivost,
                velikost, rodovaZbran);
          this.zivoty = 0;
        this.magy = 0;
        this.uroven = 1;
        this.zkusenosti = 0;
}


//== ABSTRACT METHODS ==========================================================
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

    public ArrayList<Odkaz> getZbranSAV() {
        return zbranSAV;
    }

    public ArrayList<Odkaz> getZbranTVT() {
        return zbranTVT;
    }

    public ArrayList<Odkaz> getZbroj() {
        return zbroj;
    }

    public ArrayList<Odkaz> getVybava() {
        return vybava;
    }

    public String getRodovaZbran() {
        return RODOVA_ZBRAN;
    }

    public String getRasa() {
        return RASA;
    }

    public String getPovolani() {
        return POVOLANI;
    }

    public boolean isKouzli() {
        return KOUZLI;
    }

    public int getMagy() {
        return magy;
    }

    public void setMagy(int magy) {
        this.magy = magy;
    }

    public int getZkusenosti() {
        return zkusenosti;
    }

    public void setZkusenosti(int zkusenosti) {
        this.zkusenosti = zkusenosti;
    }

    public ArrayList<Odkaz> getZvlastniSchopnosti() {
        return zvlastniSchopnosti;
    }

    public void setZvlastniSchopnosti(ArrayList<Odkaz> zvlastniSchopnosti) {
        this.zvlastniSchopnosti = zvlastniSchopnosti;
    }

    public ArrayList<Odkaz> getKouzla() {
        return kouzla;
    }

    public void setKouzla(ArrayList<Odkaz> kouzla) {
        this.kouzla = kouzla;
    }

    public ArrayList<Odkaz> getPrirodniKouzla() {
        return prirodniKouzla;
    }

    public void setPrirodniKouzla(ArrayList<Odkaz> prirodniKouzla) {
        this.prirodniKouzla = prirodniKouzla;
    }

    public int getZkusenostiDalsiUroven() {
        return zkusenostiDalsiUroven;
    }

    public void setZkusenostiDalsiUroven(int zkusenostiDalsiUroven) {
        this.zkusenostiDalsiUroven = zkusenostiDalsiUroven;
    }

    public void setVybava(ArrayList<Odkaz> vybava) {
        this.vybava = vybava;
    }

    public void setZbranTVT(ArrayList<Odkaz> zbranTVT) {
        this.zbranTVT = zbranTVT;
    }

    public void setZbranSAV(ArrayList<Odkaz> zbranSAV) {
        this.zbranSAV = zbranSAV;
    }

    public void setZbroj(ArrayList<Odkaz> zbroj) {
        this.zbroj = zbroj;
    }


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

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
        String vyzbroj = arrayListdoRadku(getBojArrayList());
        if (vyzbroj != null) {
            popis += vyzbroj;
        }

        // přidá vlastnosti, pohyblivost a nosnost
        popis += arrayListdoRadku(getAtributyArrayList());

        // přidá zvláštní schopnosti
        if (zvlastniSchopnosti != null) {
            popis += "Zvláštní schopnosti:\n"
                    + arrayListNazvydoRadku(zvlastniSchopnosti);
        }

        popis += nactiPoznamku();

        return popis;
    }

    /** Vrátí String s počtem životů */
    public String getZivotyString() {
        return String.valueOf(getZivoty());
    }

    /** Kouzlí postava? ano/ne - true/false. */
    public boolean postavaKouzli() {
        for (MagickaPovolani m : MagickaPovolani.values()) {
            if (POVOLANI.equals(m.toString())) {
                return true;
            }
        }
        return false;
    }

    /** Pokud postava kouzlí, vrátí String s počtem magů, jinak null. */
    public String getMagyString() {
        if (postavaKouzli()) return String.valueOf(getMagy());
        else return null;
    }

    /** Vrátí String s úrovní postavy. */
    public String getUrovenString() {
        return String.valueOf(getUroven());
    }

    /** Vrátí String s aktuálním počtem zkušeností. */
    public String getVypisZkusenostiString() {
        return String.format("%d/%d",getZkusenosti(),getZkusenostiDalsiUroven());
    }

    /** Vrátí String se zkušenostmi postavy. */
    public String getZkusenostiString() {
        return String.valueOf(getZkusenosti());
    }

    /** Vrátí String se zkušenostmi postavy. */
    public String getZkusenostiDalsiUrovenString() {
        return String.valueOf(getZkusenostiDalsiUroven());
    }

    /** Vrátí String s výškou postavy. */
    public String getVyskaString() {
        return String.valueOf(getVyska());
    }

    /** Vrátí String s váhou postavy. */
    public String getVahaString() {
        return String.valueOf(getVaha());
    }

    public String urciZkusenostiNaDalsiUroven() {
        Integer uroven = this.uroven;
        String povolani = this.POVOLANI;
        if (uroven != null) {
            if (uroven >= 1 && uroven <= 35) {
                int zkusenostiNaDalsi = dataOut.getZkusenosti(povolani, uroven + 1);
                return String.valueOf(zkusenostiNaDalsi);
            }
        }
        return "N/A";
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
            atributy.add("");
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
        if (getZbranTVT() != null) {
            boj.add("Zbraně tváří v tvář");
            for (Odkaz o : getZbranTVT()) boj.add(o.getNazev());
            boj.add("");
        }
        // Zbraně střelné a vrhací
        if (getZbranSAV() != null) {
            boj.add("Zbraně střelné a vrhací");
            for (Odkaz o : getZbranSAV()) boj.add(o.getNazev());
            boj.add("");
        }
        // Zbroj a štít
        if (getZbranSAV() != null) {
            boj.add("Zbroj");
            for (Odkaz o : getZbroj()) boj.add(o.getNazev());
            boj.add("");
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

    public enum MagickaPovolani {
        KOUZELNIK("kouzelník",TabulkaDB.KOUZLO.getTabNazev()),
        HRANICAR("hraničář",TabulkaDB.PRIRODNI_KOUZLO.getTabNazev());


        private final String nazev;
        private final String tabulkaKouzla;

        private MagickaPovolani(String nazev, String tabulkaKouzla) {
            this.nazev = nazev;
            this.tabulkaKouzla = tabulkaKouzla;
        }

        public String getNazev() {
            return nazev;
        }

        public String getTabulkaKouzla() {
            return tabulkaKouzla;
        }

        @Override
        public String toString() {
            return nazev;
        }


    }

}

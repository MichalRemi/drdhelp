/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;

import java.util.ArrayList;



/*******************************************************************************
 * Instance třídy {@code Nestvura} reprezentují nestvůry ze světa Dračího Doupěte
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class Nestvura extends Tvor implements IPopis{

//== CONSTANT CLASS ATTRIBUTES =================================================

    public final static String[] bojovnostArray = {"N/A", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10", "11", "12"};

    public final static String[] hodnotyZvtArray = {"½ (1-4 životy)", "1-2 životy",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
            "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37",
            "38", "39", "40"};

//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    /** životaschopnost */
    private Integer zivotaschopnost;

    /** konstanta životaschopnosti, opravuje celkový počet životů  */
    private Integer konstavtaZvt;

    /** útok */
    private String utok;

    /** obrana */
    private Integer obrana;

    /** bojovnost */
    private Integer bojovnost;

    /** zranitelnost */
    private String zranitelnost;

    /** skupiny - zranitelnost (zvíře, humanoid, drak, ...) */
    private String skupinaZranitelnost;

    /** skupiny - pohyblivost (zvěř, šelmy, ...) */
    private String skupinaPohyblivost;

    /** vytrvalost */
    private Vlastnost vytrvalost;

    /** skupiny - vytrvalost (zvěř, šelmy, ...) */
    private String skupinaVytrvalost;

    /** manévrovací schopnost */
    private Integer manevrSchopnost;

    /** základní síla mysli */
    private Integer zaklSilaMysli;

    /** přesvědčení */
    private String presvedceni;

    /** poklady */
    private String poklady;

    /** zkusenost */
    private Integer zkusenost;

    /** ochočení */
    private Integer ochoceni;


//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /**
     * Konstruktor
     *
     * @param id Id nestvůry v databázi
     * @param nazev Název nestvůry
     * @param zivotaschopnost Životaschopnost nestvůry
     * @param konstantaZvt konstanta životaschopnosti, opravuje celkový počet životů
     * @param utok Útok nestvůry
     * @param obrana Obrana nestvůry
     * @param vlastnosti Hodnoty vlastností nestvůry - int[]
     * @param velikost Velikost nestvůry
     * @param bojovnost Bojovnost nestvůry
     * @param zranitelnost Zranitelnost nestvůry
     * @param skupinaZranitelnost Skupiny zranitelnosti podle pravidel DrD pro
     * pokročilé pro PJ
     * @param pohyblivost vlastnost Pohyblivost
     * @param skupinyPohyblivost pohyblivost (zvěř, šelmy, ...)
     * @param vytrvalost Vytrvalost (zvěř, šelmy, ...)
     * @param skupinyVytrvalost vytrvalost (zvěř, šelmy, ...)
     * @param manevrovaciSchopnost Manévrovací schopnost nestvůry
     * @param zakladniSilaMysli Základní síla mysli nestvůry (mentální útok)
     * @param presvedceni Přesvědčení nestvůry
     * @param poklady Poklady nestvůry
     * @param zkusenost Zkušenost za nestvůru
     * @param ochoceni Ochočení nestvůry
     * @param poznamka Zvláštní schopnosti/útoky atd.
     */
    public Nestvura(int id, String nazev, Integer zivotaschopnost, Integer konstantaZvt,
            String utok, Integer obrana, Integer[] vlastnosti, String velikost,
            Integer bojovnost, String zranitelnost, String skupinaZranitelnost,
            Vlastnost pohyblivost, String skupinyPohyblivost, Vlastnost vytrvalost,
            String skupinyVytrvalost, Integer manevrovaciSchopnost,
            Integer zakladniSilaMysli, String presvedceni, String poklady,
            Integer zkusenost, Integer ochoceni, String poznamka) {

        super(id, nazev, vlastnosti, pohyblivost, velikost, poznamka);
        this.zivotaschopnost = zivotaschopnost;
        this.konstavtaZvt = konstantaZvt;
        this.utok = utok;
        this.obrana = obrana;
        this.bojovnost = bojovnost;
        this.zranitelnost = zranitelnost;
        this.skupinaZranitelnost = skupinaZranitelnost;
        this.skupinaPohyblivost = skupinyPohyblivost;
        this.vytrvalost = vytrvalost;
        this.skupinaVytrvalost = skupinyVytrvalost;
        this.manevrSchopnost = manevrovaciSchopnost;
        this.zaklSilaMysli = zakladniSilaMysli;
        this.presvedceni = presvedceni;
        this.poklady = poklady;
        this.zkusenost = zkusenost;
        this.ochoceni = ochoceni;
    }


//== ABSTRACT METHODS ==========================================================


//== INSTANCE GETTERS AND SETTERS ==============================================

    public Integer getZivotaschopnost() {
        return zivotaschopnost;
    }
    public Integer getKonstantaZvt() {
        return konstavtaZvt;
    }
    public void setZivotaschopnost(Integer zivotaschopnost) {
        this.zivotaschopnost = zivotaschopnost;
    }
    public void setKonstantaZvt(Integer konstantaZvt) {
        this.konstavtaZvt = konstantaZvt;
    }
    public String getUtok() {
        return utok;
    }
    public void setUtok(String utok) {
        this.utok = utok;
    }
    public Integer getObrana() {
        return obrana;
    }
    public void setObrana(Integer obrana) {
        this.obrana = obrana;
    }
    public Integer getBojovnost() {
        return bojovnost;
    }
    public void setBojovnost(Integer bojovnost) {
        this.bojovnost = bojovnost;
    }
    public String getZranitelnost() {
        return zranitelnost;
    }
    public void setZranitelnost(String zranitelnost) {
        this.zranitelnost = zranitelnost;
    }
    public String getSkupinaZranitelnost() {
        return skupinaZranitelnost;
    }
    public void setSkupinaZranitelnost(String skupinyZranitelnost) {
        this.skupinaZranitelnost = skupinyZranitelnost;
    }
    public String getSkupinaPohyblivost() {
        return skupinaPohyblivost;
    }
    public void setSkupinaPohyblivost(String skupinyPohyblivost) {
        this.skupinaPohyblivost = skupinyPohyblivost;
    }
    public Vlastnost getVytrvalost() {
        return vytrvalost;
    }
    public void setVytrvalost(Vlastnost vytrvalost) {
        this.vytrvalost = vytrvalost;
    }
    public String getSkupinaVytrvalost() {
        return skupinaVytrvalost;
    }
    public void setSkupinaVytrvalost(String skupinyVytrvalost) {
        this.skupinaVytrvalost = skupinyVytrvalost;
    }
    public Integer getManevrSchopnost() {
        return manevrSchopnost;
    }
    public void setManevrSchopnost(Integer manevrSchopnost) {
        this.manevrSchopnost = manevrSchopnost;
    }
    public Integer getZaklSilaMysli() {
        return zaklSilaMysli;
    }
    public void setZaklSilaMysli(Integer zaklSilaMysli) {
        this.zaklSilaMysli = zaklSilaMysli;
    }
    public String getPresvedceni() {
        return presvedceni;
    }
    public void setPresvedceni(String presvedceni) {
        this.presvedceni = presvedceni;
    }
    public String getPoklady() {
        return poklady;
    }
    public void setPoklady(String poklady) {
        this.poklady = poklady;
    }
    public Integer getZkusenost() {
        return zkusenost;
    }
    public void setZkusenost(Integer zkusenost) {
        this.zkusenost = zkusenost;
    }
    public Integer getOchoceni() {
        return ochoceni;
    }
    public void setOchoceni(Integer ochoceni) {
        this.ochoceni = ochoceni;
    }

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    @Override
    public String getPodrobnyPopis() {
        String popis =    "Název:   " + super.getNazev() + "\n"
                        + "Životaschopnost:   " + getZivotaschopnostString()
                        + getVypis(" + ", getKonstantaZvt()) + "\n"
                        + "Útok:   " + getUtok() + "\n"
                        + "Obrana:   " + getObranaString()+ "\n";

        // výpis Síla, Obratnost, Odolnost, Inteligence, Charisma
        ArrayList<String> vlastnosti = getVlastnosti().getVlastnostiArrayList();
        if (vlastnosti != null) {
            popis += arrayListdoRadku(vlastnosti);
        }

        String zranitelnost = "";
        if (getVypis(getZranitelnost()).equals("")) {
            zranitelnost = getVypis(getSkupinaZranitelnost());
        } else zranitelnost = getVypis(getZranitelnost());

        popis +=  getVypis("Velikost:   ", super.getVelikost(), "\n" )
                + getVypis("Bojovnost:   ", getBojovnost(), "\n")
                + "Zranitelnost:   " + zranitelnost + "\n"
                + getVypis("Pohyblivost:   ", getPohyblivost().getHodnota(), "/")
                + getVypis(getSkupinaPohyblivost(), "\n")
                + getVypis("Vytrvalost:   ", getVytrvalost().getHodnota(), "/")
                + getVypis(getSkupinaVytrvalost(), "\n")
                + getVypis("Manévrovací schopnost:   ", getManevrSchopnost(), "\n")
                + getVypis("Základní síla mysli:   ", getZaklSilaMysli(), "\n")
                + getVypis("Přesvědčení:   ", getPresvedceni(), "\n")
                + getVypis("Poklady:   ", getPoklady(), "\n")
                + getVypis("Zkušenost:   ", getZkusenost(), "\n")
                + getVypis("Ochočení:   ", getOchoceni())
                + getVypis("\nPoznámka:\n", getPoznamka());

        return popis;
    }

    /**
     * Vrátí obranu nestvůry. U humanoidů bonus za obratnost + text "kvalita zbroje"
     * případně "+ štít". Pro ostatní nestvůry vrátí hodnotu obrany
     *
     * @return String Obrana dané nestvůry
     */
    public String getObranaString() {
        Integer obrana = getObrana();
        // načte obratnost nestvůry
        Integer obratnost = getObratnost();
        if (obratnost != null) {
            Vlastnost vlastnostObratnost = new Vlastnost("Obratnost", obratnost);
            if (obrana == -1) {
                // vrátí bonus za obratnost nestvůry + kvalita zbroje
                return vlastnostObratnost.getBonusString() + " + kvalita zbroje";
            }
            if (obrana == -2) {
                // vrátí bonus za obratnost nestvůry + kvalita zbroje + štít
                return vlastnostObratnost.getBonusString() + " + kvalita zbroje + štít";
            }
        }
        if (obrana != null) return String.valueOf(obrana);
        return "";
    }

    /**
     * Vrátí životaschopnost nestvůry. Ošetřuje situaci, kdy je životaschopnost
     * "½ (1-4 životy)",které odpovídá int hodnota -2 a "1-2 životy",
     * a "1-2 životy" které odpovídá hodnota -1.
     */
    public String getZivotaschopnostString() {
        Integer zivotaschopnost = getZivotaschopnost();
        if (zivotaschopnost != null) {
            // zvláštní případ - hodnota -2 odpovídá "½ (1-4 životy)"
            if (zivotaschopnost == -2) return Nestvura.hodnotyZvtArray[0];
            // zvláštní případ - hodnota -1 odpovídá "1-2 životy"
            if (zivotaschopnost == -1) return Nestvura.hodnotyZvtArray[1];
            // ostatní platné hodnoty z Nestvura.hodnotyZvtArray
            String zvt = String.valueOf(zivotaschopnost);
            for (String s : Nestvura.hodnotyZvtArray) {
                if (s.equals(zvt)) return zvt;
            }
        }
        return null;
    }

    /**
     * Vrátí velikost nestvůry, pokud odpovídá enum Velikost, jinak vrátí null.
     */
    public VelikostNestvura urciVelikost() {
        String velikost = getVelikost();
        for (VelikostNestvura v : VelikostNestvura.values()) {
            if (velikost.equals(v.toString())) return v;
        }
        return null;
    }

    /**
     * Vrátí zranitelnost nestvůry, pokud odpovídá enum Zranitelnost, jinak vrátí null.
     */
    public Zranitelnost urciZranitelnost() {
        String zranitelnost = getZranitelnost();
        String skupinyZranitelnost = getSkupinaZranitelnost();
        if (zranitelnost != null) {
            for (Zranitelnost z : Zranitelnost.values()) {
                if (zranitelnost.equals(z.toString()) && skupinyZranitelnost
                        .equals(z.getSkupinyZranitelnost())) return z;
            }
        }
        return null;
    }

    /**
     * Vrátí skupinu pohyblivosti nestvůry, pokud odpovídá enum Pohyblivost,
     * jinak vrátí null.
     */
    public Pohyblivost urciSkupinaPohyblivost() {
        String skupinaPohyblivost = getSkupinaPohyblivost();
        if (skupinaPohyblivost != null) {
            for (Pohyblivost p : Pohyblivost.values()) {
                if (skupinaPohyblivost.equals(p.toString())) return p;
            }
        }
        return null;
    }

    /**
     * Vrátí skupinu vytrvalosti nestvůry, pokud odpovídá enum Pohyblivost (hodnoty
     * jsou stejné i pro vytrvalost), jinak vrátí null.
     */
    public Pohyblivost urciSkupinaVytrvalost() {
        String skupinaVytrvalost = getSkupinaVytrvalost();
        if (skupinaVytrvalost != null) {
            for (Pohyblivost p : Pohyblivost.values()) {
                if (skupinaVytrvalost.equals(p.toString())) {
                    return p;
                }
            }
        }
        return null;
    }

    /**
     * Vrátí přesvědčení nestvůry, pokud odpovídá enum Tvor.Přesvědčení, jinak
     * vrátí null.
     */
    public Presvedceni urciPresvedceni() {
        String presvedceni = getPresvedceni();
        if (presvedceni != null) {
            for (Presvedceni p : Presvedceni.values()) {
                if (presvedceni.equals(p.toString())) return p;
            }
        }
        return null;
    }


//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

    private String getVypis(String text) {
        if (text != null) return text;
        return "";
    }

    private String getVypis(String text, String zaTextem) {
        if (text != null && zaTextem != null) return text + zaTextem;
        return "";
    }

    private String getVypis(String predTextem, String text, String zaTextem) {
        if (text != null && !text.equals("")) return predTextem + text + zaTextem;
        return "";
    }

    private String getVypis(Integer hodnota) {
        if (hodnota != null) return String.valueOf(hodnota);
        return "";
    }

    private String getVypis(String predHodnotou, Integer hodnota) {
        if (hodnota != null) return predHodnotou + String.valueOf(hodnota);
        return "";
    }

    private String getVypis(String predHodnotou, Integer hodnota, String zaHodnotou) {
        if (hodnota != null) return predHodnotou + String.valueOf(hodnota) + zaHodnotou;
        return "";
    }


//##############################################################################
//== NESTED DATA TYPES =========================================================

    public enum VelikostNestvura {
        A0("A0"),
        A("A"),
        B("B"),
        C("C"),
        D("D"),
        E("E");


        private final String nazev;

        VelikostNestvura(String nazev) {
            this.nazev = nazev;
        }

        @Override
        public String toString() {
            return nazev;
        }
    }

    public enum Zranitelnost {
        NA("N/A",null),
        ZVIRE("zvíře", "B,C,D,G,H,I,J,K,L"),
        HUMANOID("humanoid", "A,B,C,D,G,H,I,J,K,L,M,O"),
        DRAK("drak", "B,C,D,G¼,H¼,I,J,K½,P+"),
        LYKANTROP("lykantrop", "A½,B½,C stín.,D2,F,G½,I½,J,K,L,M"),
        NEMRTVY("nemrtvý", "E,I,J,K,L,N,P"),
        NEVIDENY("nevidený", "C,I,J,N,P+");


        private final String nazev;
        private final String skupinaZranitelnost;

        Zranitelnost(String nazev, String skupinaZranitelnost) {
            this.nazev = nazev;
            this.skupinaZranitelnost = skupinaZranitelnost;
        }

        public String getSkupinyZranitelnost() {
            return skupinaZranitelnost;
        }

        @Override
        public String toString() {
            return nazev;
        }
    }

    public enum Pohyblivost {
        HUMANOID("humanoid"),
        ZVIRE("zvíře"),
        SELMA("šelma"),
        DRAK("drak"),
        PLAZ("plaz"),
        HMYZ("hmyz"),
        VODNI_TVOR("vodní tvor"),
        OKRIDLENEC("okřídlenec"),
        MAGICTI_TVOR("magický tvor");


        private final String nazev;

        Pohyblivost(String nazev) {
            this.nazev = nazev;
        }

        @Override
        public String toString() {
            return nazev;
        }
    }

}
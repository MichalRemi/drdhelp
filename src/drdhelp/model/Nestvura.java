/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;







/*******************************************************************************
 * Instance třídy {@code Nestvura} reprezentují nestvůry ze světa Dračího Doupěte
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2017-01-03
 */
public class Nestvura extends Tvor implements IPopis{

//== CONSTANT CLASS ATTRIBUTES =================================================

    public final static String[] BOJOVNOST = {"N/A", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10", "11", "12"};

//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================



//    super(id, nazev, vlastnosti, pohyblivost, velikost, poznamka);

    /** životaschopnost */
    private Integer zivotaschopnost;

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
     * @param utok Útok nestvůry
     * @param obrana Obrana nestvůry
     * @param vlastnosti Hodnoty vlastností nestvůry - int[]
     * @param velikost Velikost nestvůry
     * @param bojovnost Bojovnost nestvůry
     * @param zranitelnost Zranitelnost nestvůry
     * @param skupinyZranitelnost Skupiny zranitelnosti podle pravidel DrD pro
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
    public Nestvura(int id, String nazev, int zivotaschopnost, String utok,
        int obrana, Integer[] vlastnosti, String velikost, int bojovnost,
        String zranitelnost, String skupinyZranitelnost,
        Vlastnost pohyblivost, String skupinyPohyblivost,
        Vlastnost vytrvalost, String skupinyVytrvalost,
        int manevrovaciSchopnost, int zakladniSilaMysli,
        String presvedceni, String poklady, int zkusenost, int ochoceni,
        String poznamka) {

        super(id, nazev, vlastnosti, pohyblivost, velikost, poznamka);
        this.zivotaschopnost = zivotaschopnost;
        this.utok = utok;
        this.obrana = obrana;
        this.bojovnost = bojovnost;
        this.zranitelnost = zranitelnost;
        this.skupinaZranitelnost = skupinyZranitelnost;
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

    @Override
    public String getPodrobnyPopis() {
        String popis =    "Název:   " + super.getNazev() + "\n"
                        + "Životaschopnost:   " + getZivotaschopnost()+ "\n"
                        + "Útok:   " + getUtok()+ "\n"
                        + "Obrana:   " + getObrana()+ "\n";

        popis += arrayListdoRadku(getVlastnosti().getVlastnostiArrayList());

        if (getPohyblivost().getHodnota() != null) {
            popis += arrayListdoRadku(getPohyblivostArrayList());
        }

        popis +=    "Velikost:   " + super.getVelikost() + "\n"
                +   "Bojovnost:   " + getBojovnost()+ "\n"
                +   "Zranitelnost:   " + getZranitelnost()+ "\n"
                +   "Vytrvalost:   " + getVytrvalost()+ "\n"
                +   "Manévrovací schopnost:   " + getManevrSchopnost()+ "\n"
                +   "Základní síla mysli:   " + getZaklSilaMysli()+ "\n"
                +   "Přesvědčení:   "   + getPresvedceni()+ "\n"
                +   "Poklady:   " + getPoklady()+ "\n"
                +   "Zkušenost:   " + getZkusenost()+ "\n"
                +   "Ochočení:   " + getOchoceni()
                +   nactiPoznamku();

        return popis;
    }


//== INSTANCE GETTERS AND SETTERS ==============================================

    public int getZivotaschopnost() {
        return zivotaschopnost;
    }
    public void setZivotaschopnost(int zivotaschopnost) {
        this.zivotaschopnost = zivotaschopnost;
    }
    public String getUtok() {
        return utok;
    }
    public void setUtok(String utok) {
        this.utok = utok;
    }
    public int getObrana() {
        return obrana;
    }
    public void setObrana(int obrana) {
        this.obrana = obrana;
    }
    public int getBojovnost() {
        return bojovnost;
    }
    public void setBojovnost(int bojovnost) {
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
    public int getManevrSchopnost() {
        return manevrSchopnost;
    }
    public void setManevrSchopnost(int manevrSchopnost) {
        this.manevrSchopnost = manevrSchopnost;
    }
    public int getZaklSilaMysli() {
        return zaklSilaMysli;
    }
    public void setZaklSilaMysli(int zaklSilaMysli) {
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
    public int getZkusenost() {
        return zkusenost;
    }
    public void setZkusenost(int zkusenost) {
        this.zkusenost = zkusenost;
    }
    public int getOchoceni() {
        return ochoceni;
    }
    public void setOchoceni(int ochoceni) {
        this.ochoceni = ochoceni;
    }

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /**
     * Vrátí obranu nestvůry. U humanoidů bonus za obratnost + text "kvalita zbroje"
     * případně "+ štít". Pro ostatní nestvůry vrátí hodnotu obrany
     *
     * @return String Obrana dané nestvůry
     */
    public String getObranaString() {
        int obrana = getObrana();
        // načte obratnost nestvůry
        Integer obratnost = getObratnost();
        System.out.println("Obratnost nestvůry je : " + obratnost);
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
        return "";
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
        if (zranitelnost != null) {
            for (Zranitelnost z : Zranitelnost.values()) {
                if (zranitelnost.equals(z.toString())) return z;
            }
        }
        return null;
    }

    /**
     * Vrátí skupinu pohyblivosti nestvůry, pokud odpovídá enum Pohyblivost,
     * jinak vrátí null.
     */
    public Pohyblivost urciSkupinaPohyblivost() {
        String skupinapohyblivost = getSkupinaPohyblivost();
        if (skupinapohyblivost != null) {
            for (Pohyblivost p : Pohyblivost.values()) {
                if (skupinapohyblivost.equals(p.toString())) return p;
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
                if (skupinaVytrvalost.equals(p.toString())) return p;
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
        ZVER("zvíře"),
        SELMY("šelma"),
        DRACI("drak"),
        PLAZY("plaz"),
        HMYZ("hmyz"),
        VODNI_TVOROVE("vodní tvor"),
        OKRIDLENCI("okřídlenec"),
        MAGICTI_TVOROVE("magický tvor");


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

/**
 * pohyblivost:
 * humanoid
 * zvěř
 * šelmy
 * draci
 * plazi
 * hmyz
 * vodní tvorové
 * okřídlenci
 * magičtí tvorové
 *
 * zranitelnost:
 * zvíře
 * humanoid
 * drak
 * lykantrop
 * nemrtní
 * neviděný
 *
 * "A" - "P"
 *
 * "+" "0" "½" "¼"
 */

/**
 *1  int id,
 *2  String nazev,
 *3  int zivotaschopnost,
 *4  String utok,
 *5  int obrana,
 *6  int[] vlastnosti,
 *7  String velikost,
 *8  int bojovnost,
 *9  String zranitelnost,
 *10 String skupinyZranitelnost,
 *11 Vlastnost pohyblivost,
 *12 String skupinyPohyblivost,
 *13 Vlastnost vytrvalost,
 *14 String skupinyVytrvalost,
 *15 int manevrovaciSchopnost,
 *16 int zakladniSilaMysli,
 *17 String presvedceni,
 *18 String poklady,
 *19 int zkusenost,
 *20 int ochoceni,
 *21 String poznamka
 */


//    /**
//     * Vyhodnotí String a převede na int. Pro "N/A", null nebo hodnoty
//     * neodpovídající obsahu String[] pole vrátí 0.
//     */
//    private int prevedHodnotuNaInt(String hodnota, String[] pole) {
//        for (String s : pole) {
//            if (hodnota.equals(s)) {
//                if (s.equals("N/A")) return 0;
//                else return Integer.parseInt(s);
//            }
//        }
//        return 0;
//    }

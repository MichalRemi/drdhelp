/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;



/*******************************************************************************
 * Instance třídy {@code Vlastnost} představují Hodnotu vlastnosti a bonusu.
 * Součástí bonusu je i znaménko + a to i pro hodnotu 0.
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class Vlastnost {


//== CONSTANT CLASS ATTRIBUTES =================================================

    /**
     * Uchovává bonusy od -5 do +19 pro vlastnosti od 0 až 50. Hodnota vlastnosti
     * je zároveň index pole příslušného bonusu.
     */
    private static final int[] BONUSY = {-6, -5, -4, -4, -3, -3, -2, -2, -1, -1,
    //                          indexy:   0   1   2   3   4   5   6   7   8   9
            0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10,
        // 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30  31  32
           11, 11, 12, 12, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17, 18, 18, 19, 19};
        // 33  34  35  36  37  38  39  40  41  42  43  44  45  46  47  48  49  50

//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================

    /**
     * Vrátí bonus včetně znaménka.
     *
     * @param vlastnost hodnota 1 - 50, nebo null.
     */
    public static String getBonus(Integer vlastnost) {
        if (vlastnost != null && vlastnost >= 0 && vlastnost <= 50) {
            int bonus = BONUSY[vlastnost];
            if (bonus == 0) return "+0";
            else return String.format("%+d",bonus);
        }
        return null;
    }

//== OTHER NON-PRIVATE CLASS METHODS ===========================================

    /**
     * Náhodně vygeneruje hodnotu vlastnosti.
     *
     * @param pocetKostek Počet hodů šestistěnnou kostkou.
     * @param konstanta Konstanta upravující hodnotu vlastnosti.
     * @return Hodnota vlastnosti.
     */
    public static int generujVlastnost(int pocetKostek, int konstanta) {
        Kostka k6 = new Kostka(6);
        int pomocna = 0;
        for (int i = 0; i < pocetKostek; i++) pomocna += k6.hod();
        return pomocna + konstanta;
    }


//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    /**
     * Název vlastnosti.
     */
    private final String NAZEV;


//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    /**
     * Bonus vlastnosti.
     */
    private Integer bonus;

    /**
     * Hodnota vlastnosti.
     */
    private Integer hodnota;

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /**
     * Konstruktor. Hodnota vlastnosti musí být z intervalu 0 - 50 včetně,
     * nebo null(null je platná hodnota), jinak bude hodnota
     * vlastnosti a bonusu null a v konzoli vyskočí varovná hláška
     * @param nazev Název vlastnosti.
     * @param hodnota
     */
    public Vlastnost(String nazev, Integer hodnota) {
        this.NAZEV = nazev;
        // if (hodnota == 0) hodnota = null;
        if (hodnota != null) {
            if ((hodnota >= 0) && (hodnota <= 50)) {
                this.bonus = BONUSY[hodnota];
                this.hodnota = hodnota;
            }
            else {
                this.hodnota = hodnota;
                this.bonus = null;
                System.err.println("Chybný parametr hodnota v konstruktoru" +
                    " Vlastnost(), hodnota musí být z intervalu <0-50> nebo null");
                System.err.println("Vlastnost je: " + nazev);
                System.err.println("Nyní je hodnota: " + hodnota);
            }
        } else {
        this.hodnota = null;
        this.bonus = null;
        }
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

   /**
     * @return nazev
     */
    public String getNazev() {
        return NAZEV;
    }

    /**
     * @return hodnota
     */
    public Integer getHodnota() {
        return hodnota;
    }

    /**
     * @return bonus
     */
    public Integer getBonus() {
        return bonus;
    }

    /**
     * @return bonus typu String včetně kladného znaménka
     */
    public String getBonusString() {
        if (bonus != null) {
            if (bonus == 0) return "+0";
            else return String.format("%+d",bonus);
        }
        return null;
    }

    /**
     * @return hodnota
     */
    public String getHodnotaString() {
        if (hodnota != null) {
            return String.valueOf(hodnota);
        }
        return null;
    }

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /** Vrátí celočíselný podíl dělence a dělitele zaokrouhlený nahoru. */
    public int deleniNahoru(int delenec, int delitel) {
        if (delenec % delitel > 0) return (delenec / delitel + 1);
        else return (delenec / delitel);
    }

    /**
     * @return Návev vlastnosti, hodnotu vlastnosti a bonus se znaménkem (včetně
     * + pro 0).
     */
    @Override
    public String toString() {
        if (hodnota != null || bonus != null) {
        return getNazev() + ":   " + getHodnota() + " " + getBonusString();
        }
        return null;
    }


//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

//##############################################################################
//== NESTED DATA TYPES =========================================================
}

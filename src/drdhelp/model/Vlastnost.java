/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;



/*******************************************************************************
 * Instance třídy {@code Vlastnost} představují Hodnotu vlastnosti a bonusu.
 * Součástí bonusu je i znaménko + a to i pro hodnotu 0.
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2016-09-18
 */
public class Vlastnost {


//== CONSTANT CLASS ATTRIBUTES =================================================

    /**
     * Uchovává bonusy od -5 do +19 pro vlastnosti od 1 až 50. Hodnota vlastnosti
     * je zároveň index pole příslušného bonusu.
     */
    private static final int[] BONUSY = {-100, -5, -4, -4, -3, -3, -2, -2, -1, -1,
    //                              indexy: 0   1   2   3   4   5   6   7   8   9
            0, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10, 10,
        // 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30  31  32
           11, 11, 12, 12, 13, 13, 14, 14, 15, 15, 16, 16, 17, 17, 18, 18, 19, 19};
        // 33  34  35  36  37  38  39  40  41  42  43  44  45  46  47  48  49  50

//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
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

    /**
     * Vytvoří vzestupné pole hodnot od minima po maximum.
     * @param minimum Dolní mez intervalu včetně.
     * @param maximum Horní mez intervalu včetně.
     * @param krok Krok mezi sousedícími hodnotami.
     * @return pole Integer
     */
    public static Integer[] hodnotyPodleMezi(int minimum, int maximum, int krok) {
        int konstanta = ((maximum - minimum) / krok);
        Integer[] pomocne = new Integer[konstanta + 1];
        for (int i = 0; i <= konstanta; i++) {
            pomocne[i] = minimum + i * krok;
        }
        return pomocne;
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
    private Integer BONUS;

    /**
     * Hodnota vlastnosti.
     */
    private Integer HODNOTA;

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /**
     * Konstruktor. Hodnota vlastnosti musí být z intervalu <1-50>, jinak bude
     * hodnota vlastnosti 0 a bonus -100.
     *
     * @param nazev Název vlastnosti.
     * @param hodnota
     */
    public Vlastnost(String nazev, Integer hodnota) {
        this.NAZEV = nazev;
        if (hodnota != null) {
            if ((hodnota >= 1) && (hodnota <= 50)) {
                this.BONUS = BONUSY[hodnota];
                this.HODNOTA = hodnota;
            }
            else {
                this.BONUS = -100;
                this.HODNOTA = 0;
                System.err.println("Chybný parametr hodnota v konstruktoru" +
                    " Vlastnost(), hodnota musí být z intervalu <1-50> nebo null");
            }
        }
        this.HODNOTA = null;
        this.BONUS = null;
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
        return HODNOTA;
    }

    /**
     * @return bonus
     */
    public Integer getBonus() {
        return BONUS;
    }

    /**
     * @return bonus typu String včetně kladného znaménka
     */
    public String getBonusString() {
        if (BONUS != null) {
            if (BONUS == 0) return "+0";
            else return String.format("%+d",BONUS);
        }
        else return "-100";
    }

    /**
     * @return hodnota
     */
    public String getHodnotaString() {
        return String.valueOf(HODNOTA);
    }

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /**
     * Vrátí celočíselný podíl dělence a dělitele zaokrouhlený nahoru.
     *
     * @return String aktuální magy/maximální magy.
     */
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
        return String.format("%-10s %6d %s", getNazev(), getHodnota(),
                             getBonusString());

    }


//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

//##############################################################################
//== NESTED DATA TYPES =========================================================
}
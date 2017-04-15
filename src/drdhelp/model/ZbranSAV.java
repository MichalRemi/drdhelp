/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;



/*******************************************************************************
 * Instance třídy {@code ZbranSAV} představují střelné a vrhací zbraně.
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class ZbranSAV extends Vybava implements IPopis {

//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================

    /** název tabulky s atributy instancí v databázi drddesk_db */
    public static final String tabulka = "zbran_sav";


//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================

    public static String getTabulka() {
        return tabulka;
    }


//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT AND VARIABLE INSTANCE ATTRIBUTES =================================

    /** lehká/střední/těžká */
    private final String TYP;

    private final int SILA;

    /** Útočnost zbraně */
    private final int UTOCNOST;

    /** Dostřel zbraně - malý dostřel */
    private final int MALY_DOSTREL;

    /** Dostřel zbraně - střední dostřel */
    private final int STREDNI_DOSTREL;

    /** Dostřel zbraně - velký dostřel */
    private final int VELKY_DOSTREL;


//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /***************************************************************************
     * Konstruktor - instance střelných nebo vrhacích zbraní.
     *
     * @param id Identifikační číslo řádku v databázi.
     * @param nazev Název střelné nebo vrhací zbraně.
     * @param druh Druh zbraně (lehká/střední/těžká nebo střelná/vrhací).
     * @param typ
     * @param sila Síla zbraně.
     * @param utocnost Útočnost zbraně.
     * @param malyDostrel Dostřel zbraně - malý dostřel
     * @param velkyDostrel Dostřel zbraně - střední dostřel
     * @param stredniDostrel Dostřel zbraně - velký dostřel
     * @param vaha Váha zbraně.
     * @param zlataky Cena vybavení - zlaťáky
     * @param stribrnaky Cena vybavení - stříbrňáky
     * @param medaky Cena vybavení - měďáky
     * @param poznamka Poznámka.
     */
    public ZbranSAV(int id, String nazev, String druh, String typ, int sila,
                    int utocnost, int malyDostrel, int stredniDostrel,
                    int velkyDostrel, int vaha, int zlataky, int stribrnaky,
                    int medaky, String poznamka) {
        super(id, nazev, druh, vaha, zlataky, stribrnaky, medaky, poznamka);
        this.TYP = typ;
        this.SILA = sila;
        this.UTOCNOST = utocnost;
        this.MALY_DOSTREL = malyDostrel;
        this.STREDNI_DOSTREL = stredniDostrel;
        this.VELKY_DOSTREL = velkyDostrel;
    }

    public String getDostrel() {
        return MALY_DOSTREL + "/" + STREDNI_DOSTREL + "/" + VELKY_DOSTREL;
    }


//== ABSTRACT METHODS ==========================================================


//== INSTANCE GETTERS AND SETTERS ==============================================

    public String getTyp() {
        return TYP;
    }

    public int getSila(){
        return SILA;
    }

    public int getUtocnost() {
        return UTOCNOST;
    }

    public int getMalyDostrel() {
        return MALY_DOSTREL;
    }

    public int getStredniDostrel() {
        return STREDNI_DOSTREL;
    }

    public int getVelkyDostrel() {
        return VELKY_DOSTREL;
    }


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    @Override
    public String getPodrobnyPopis() {
        return    "Název:   " + super.getNazev() + "\n"
                + "Druh:   " + super.getDruh() + " " + TYP + "\n"
                + "Síla zbraně:   " + SILA + "\n"
                + "Útočnost:   " + getUtocnostString() + "\n"
                + "Dostřel:   " + getDostrel() + "\n"
                + "Váha:   " + super.getVaha() + " mn\n"
                + "Cena:   " + super.getCenaVypis()
                + super.vratPopis();
    }

    /** Vrátí útočnost se znaménkem i pro kladná čísla a 0 */
    public String getUtocnostString() {
        return String.format("%+d",UTOCNOST);
    }

    public String vypisDoRadku() {
        return String.format("%-17s%2d%+3d%9s%4d mn%8s",getNazev(),getSila(),
            getUtocnost(),getDostrel(),getVaha(),getCenaVypis());
    }

    @Override
    public String toString()
    {
        return "název: \t" + getNazev() + "\n" +
               "druh: \t" + getDruh() + "\n" +
               "síla zbraně: \t" + getSila() + "\n" +
               "útočnost:  \t" + getUtocnost() + "\n" +
               "dostřel: \t" + getDostrel() + "\n" +
               "cena: \t" + getCenaVypis()+ "\n" +
               "vaha: \t" + getVaha() + "\n" +
               "\npopis:\n" + getPopis();
    }

//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================
//##############################################################################
//== NESTED DATA TYPES =========================================================
}

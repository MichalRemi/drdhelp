/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;



/*******************************************************************************
 * Instance třídy {@code Rasa} představují rasu v Dračím Doupěti
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2016-09-18
 */
public class Rasa {
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================



//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================

    /**
     * Jméno rasy.
     */
    private final String NAZEV;

    /**
     * Hodnoty vlastností (atributů) rasy v pořadí Síla, Obratnost, Odolnost,
     * Inteligence * a Charisma. Hodnota vlastnosti se určuje určitým počtem
     * hodů šestistěnnou kostkou(k6) a připočtením konstanty. V prvním rozměru
     * je počet hodů k6 a ve druhém konstanta.
     */
    private final int[][] VLASTNOSTI;

    /**
     * Základní vlastnosti povolání (jsou vždy dvě) je potřeba opravit
     * v závislosti na rase, tj. přičíst konstantu k vlastnostem určeným podle
     * povolání v pořadí Síla, Obratnost, Odolnost, Inteligence a Charisma.
     */
    private final int[] OPRAVY;

    /**
     * Dolní a horní mez výšky rasy.
     */
    private final int[] VYSKA;

    /**
     * Dolní a horní mez váhy rasy.
     */
    private final int[] VAHA;

    /**
     * Pohyblivost rasy.
     */
    private final int POHYBLIVOST;

    /**
     * Rodova zbran rasy.
     */
    private final String RODOVA_ZBRAN;

    /**
     * Velikost rasy.
     */
    private final String VELIKOST;

    /**
     * Zvlášní schopnosti rasy.
     */
    private final String ZVALSTNI_SCHOPNOSTI;

    /**
     * Popis rasy.
     */
    private final String POPIS;


//== VARIABLE INSTANCE ATTRIBUTES ==============================================

//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /**
     * Konstruktor.
     *
     * @param nazev Jméno rasy.
     * @param vlastnosti Vlastnosti rasy. Typ int [5][5].
     * @param opravy Opravy vlastností podle povolání. Typ int[5].
     * @param vyska Dolní a horní mez výšky rasy. Typ int[2].
     * @param vaha Dolní a horní mez váhy rasy. Typ int[2].
     * @param pohyblivost Pohyblivost rasy pro určení pohyblivosti postavy, Typ int.
     * @param zvlastniSchopnosti Zvláštní schopnosti rasy, pokud žádné postava
     *      nemá, obsahuje 0. Typ String.
     * @param rodovaZbran Rodová zbraň rasy. Typ String.
     * @param velikost Velikost rasy. Typ String - 2 znaky.
     * @param popis Popis rasy. Typ String.
     */
    public Rasa(String nazev, int[][] vlastnosti, int[] opravy, int[] vyska,
    int[] vaha, int pohyblivost, String zvlastniSchopnosti, String rodovaZbran,
    String velikost, String popis) {

        this.NAZEV = nazev;
        this.VLASTNOSTI = vlastnosti;
        this.OPRAVY = opravy;
        this.VYSKA = vyska;
        this.VAHA = vaha;
        this.POHYBLIVOST = pohyblivost;
        this.ZVALSTNI_SCHOPNOSTI = zvlastniSchopnosti;
        this.RODOVA_ZBRAN = rodovaZbran;
        this.VELIKOST = velikost;
        this.POPIS = popis;
    }


//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    /**
     * @return jmeno rasy
     */
    public String getNazev() {
        return NAZEV;
    }

    /**
     * @return vlastnosti rasy v pořadí Síla, Obratnost, Odolnost, Inteligence
     * a Charisma
     */
    public int[][] getVlastnosti() {
        return VLASTNOSTI;
    }

    /**
     * @return opravy vlastností rasy podle povolání v pořadí Síla, Obratnost,
     * Odolnost, Inteligence a Charisma
     */
    public int[] getOpravy() {
        return OPRAVY;
    }

    /**
     * @return Dolní a horní mez výšky rasy - int[2].
     */
    public int[] getVyska() {
        return VYSKA;
    }

    /**
     * @return Dolní a horní mez váhy rasy - int[2].
     */
    public int[] getVaha() {
        return VAHA;
    }

    /**
     * @return Pohyblivost rasy - int.
     */
    public int getPohyblivost() {
        return POHYBLIVOST;
    }

    /**
     * @return Zvláštní schopnosti rasy, pokud rasa žádnou nemá, vrací 0 - String.
     */
    public String getZvlastniSchopnosti() {
        return ZVALSTNI_SCHOPNOSTI;
    }

    /**
     * @return Rodová zbraň rasy - String.
     */
    public String getRodovaZbran() {
        return RODOVA_ZBRAN;
    }

    /**
     * @return Velikost rasy, dva znaky - String.
     */
    public String getVelikost() {
        return VELIKOST;
    }

    /**
     * @return Popis rasy - String.
     */
    public String getPopis() {
        return POPIS;
    }

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================
//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================

    /**
     * @return název rasy
     */
    @Override
    public String toString(){
        return getNazev();
    }


//##############################################################################
//== NESTED DATA TYPES =========================================================
}

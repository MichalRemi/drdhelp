/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;



/*******************************************************************************
 * Instance třídy {@code Povolani} představuje povolání postavy ze světa Dračího
 * Doupěte.
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class Povolani
{
//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================
//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT AND VARIABLE INSTANCE ATTRIBUTES =================================

    /**
     * Název povolání.
     */
    private final String nazev;

    /**
     * Hodnoty vlastností (atributů) rasy v pořadí Síla, Obratnost, Odolnost,
     * Inteligence a Charisma. Hodnota vlastnosti se určuje určitým počtem hodů
     * šestistěnnou kostkou(k6) a připočtením konstanty. V prvním rozměru je
     * počet hodů k6 a ve druhém konstanta.
     */
    private final int[][] vlastnosti;

    /**
     * Základ pro výpočet přírůstku životů.
     */
    private final int zivoty;

    /**
     * Zvláštní schopnosti povolání
     */
    private final String zvlastniSchopnosti;

    /**
     * Popis povolání.
     */
    private final String popis;


//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================

    /**
     * Konstruktor.
     *
     * @param nazev Název povolání.
     * @param vlastnosti Základní vlastnosti povolání, očekává se int [5][5].
     * @param zivoty Základ pro výpočet přírůstku životů.
     * @param zvlastniSchopnosti Zvláštní schopnosti povolání.
     * @param popis Popis povolání.
     */
    public Povolani(String nazev, int[][] vlastnosti, int zivoty,
                    String zvlastniSchopnosti, String popis) {
        this.nazev = nazev;
        this.vlastnosti = vlastnosti;
        this.zivoty = zivoty;
        this.zvlastniSchopnosti = zvlastniSchopnosti;
        this.popis = popis;
    }



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

     /**
     * @return jmeno povolání
     */
    public String getNazev() {
        return nazev;
    }

    /**
     * @return základní vlastnosti povolání
     */
    public int[][] getVlastnosti() {
        return vlastnosti;
    }


//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /**
     * @return název povolání
     */
    @Override
    public String toString(){
        return getNazev();
    }


//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================

}

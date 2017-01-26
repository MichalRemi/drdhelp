package drdhelp.model;

/**
 *
 * @author Lachi
 */
public class Povolani {

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

    /**
     * @return název povolání
     */
    @Override
    public String toString(){
        return getNazev();
    }



}

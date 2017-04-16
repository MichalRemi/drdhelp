/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package drdhelp.model;

import drdhelp.model.io.DataOut;
import java.util.ArrayList;
import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;



/*******************************************************************************
 * Instance třídy {@code SeznamOdkazu} představuje FXCollections ObservableList
 * pro nabindování seznamListView ve formuláři Main.
 *
 * @author  Michal Remišovský
 * @version 0.01.0000 — 2017-04-15
 */
public class SeznamOdkazu {

//== CONSTANT CLASS ATTRIBUTES =================================================
//== VARIABLE CLASS ATTRIBUTES =================================================

    private static Odkaz aktualniOdkaz = null;

    private final DataOut dataOut = new DataOut();



//##############################################################################
//== STATIC INITIALIZER (CLASS CONSTRUCTOR) ====================================
//== CLASS GETTERS AND SETTERS =================================================

    /**
     * Načte Odkaz ze statické proměnné. Ten slouží k načtení upravované položky
     * do přislušného formuláře (vyskakovací okna). Pokud se jedná o přidání
     * nové položky, má hodnotu null.
     */
    public static Odkaz getAktualniOdkaz() {
        return aktualniOdkaz;
    }

    /**
     * Uloží Odkaz do statické proměnné. Ten slouží k načtení upravované položky
     * do přislušného formuláře (vyskakovací okna). Pokud se jedná o přidání
     * nové položky, má hodnotu null.
     */
    public static void setAktualniOdkaz(Odkaz odkaz) {
        aktualniOdkaz = odkaz;
    }

//== OTHER NON-PRIVATE CLASS METHODS ===========================================
//== PRIVATE AND AUXILIARY CLASS METHODS =======================================



//##############################################################################
//== CONSTANT INSTANCE ATTRIBUTES ==============================================
//== VARIABLE INSTANCE ATTRIBUTES ==============================================

    // Odkazy nabindované do seznamListView
    private final ObservableList<Odkaz> odkazy = FXCollections.observableArrayList();

    // Poslední načtený seznam Odkazů
    private ArrayList<Odkaz> puvodniOdkazy = new ArrayList<Odkaz>();



//##############################################################################
//== CONSTUCTORS AND FACTORY METHODS ===========================================



//== ABSTRACT METHODS ==========================================================
//== INSTANCE GETTERS AND SETTERS ==============================================

    public ObservableList<Odkaz> getOdkazy() {
        return odkazy;
    }

//== OTHER NON-PRIVATE INSTANCE METHODS ========================================

    /** přidá odkaz do kolekce odkazy(nabindovaná se seznamlistView v main.fxml) */
    public void pridej(Odkaz odkaz) {
        odkazy.add(odkaz);
    }

    /** smaže odkaz z kolekce odkazy(nabindovaná se seznamlistView v main.fxml) */
    public void odeber(Odkaz odkaz) {
        odkazy.remove(odkaz);
    }

    /** seřadí kolekci odkazy(nabindovaná se seznamlistView v main.fxml) */
    public void serad(ArrayList<Odkaz> listOdkazu) {
        Collections.sort(listOdkazu);
    }

    /** načte odkazy do kolekce odkazy(nabindovaná se seznamlistView v main.fxml) */
    public void nactiOdkazy(String nazevTlacitka){
        if (nazevTlacitka != null) {
            puvodniOdkazy = dataOut.nactiOdkazy(getTabName(nazevTlacitka));
            if (puvodniOdkazy != null) {
                serad(puvodniOdkazy);
                odkazy.clear();
                if (!odkazy.addAll(puvodniOdkazy)) {
<<<<<<< HEAD
                    System.err.println("SeznamOdkazu.nactiOdkazy(): Nezdařilo" +
                            " se přidání ArrayList<Odkaz>:");
=======
                    System.err.println("SeznamOdkazu.nactiOdkazy(): Nezdařilo se přidání" +
                                                                    "ArrayList<Odkaz>:");
>>>>>>> origin/master
                    System.err.println(puvodniOdkazy);
                }
            }
        } else {
            System.err.println("SeznamOdkazu.nactiOdkazy(): Parametr " +
                    "nazevTlacitka je null");
        }
    }

    /**
     * hledání v kolekci odkazy(nabindovaná se seznamlistView v main.fxml)
     * zredukuje kolekci na položky začínající předaným řetězcem
     */
    public void vyberPodleZacinajicihoRetezce(String retezec) {
        ArrayList<Odkaz> hledane = new ArrayList<>();
        if (!"".equals(retezec)) {
            for (Odkaz o : puvodniOdkazy) {
                if (o.getNazev().toLowerCase().startsWith(retezec.toLowerCase())) {
                    hledane.add(o);
                }
                odkazy.setAll(hledane);
            }
        } else odkazy.setAll(puvodniOdkazy);
    }

    /**
     * Vrátí název tabulky odpovídající názvu tlačítka - předanému parametru
     * @param buttonName Tlačítko z ToggleGroup menu z formuláře Main
     */
    public String getTabName(String buttonName) {
        try {
            for (TabulkaDB t : TabulkaDB.values()) {
            if (t.getNazev().equals(buttonName)) return t.getTabNazev();
            }
        } catch (Exception e) {
        System.err.println("Chybné jméno tlačítka!\n" + e);
        }
        return null;
    }


//== PRIVATE AND AUXILIARY INSTANCE METHODS ====================================



//##############################################################################
//== NESTED DATA TYPES =========================================================
}
